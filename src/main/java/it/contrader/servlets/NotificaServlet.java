package it.contrader.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.EventDTO;
import it.contrader.dto.NotificaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.dto.UserNotificationDTO;
import it.contrader.service.EventService;
import it.contrader.service.NotificaService;
import it.contrader.service.Service;

public class NotificaServlet extends HttpServlet{
private static final long serialVersionUID = 1L;

public NotificaServlet() {
	
}

public void updateListAll(HttpServletRequest request) {
	Service<NotificaDTO> service = new NotificaService();
	List<NotificaDTO> listDTO = service.getAll();
	request.setAttribute("list", listDTO);
	}

public void updateList(HttpServletRequest request) {
	Service<NotificaDTO> service = new NotificaService();
	final HttpSession session =  request.getSession();
	UserDTO user = (UserDTO) session.getAttribute("user");
	List<NotificaDTO> listDTO = service.getAllByUser(user.getId());
	int id;
	Service<EventDTO> serviceEvent = new EventService();
	EventDTO eventDTO;
	List<UserNotificationDTO> listUser = new ArrayList<UserNotificationDTO>();
	for(NotificaDTO n: listDTO) {
		id = n.getId_event();
		eventDTO = serviceEvent.read(id);
		UserNotificationDTO userDTO = new UserNotificationDTO(n.getId(), eventDTO.getNome(), n.getNotifica_tempo(), n.getNotificato());
		listUser.add(userDTO);
	}
	request.setAttribute("list", listUser);
}


public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Service<NotificaDTO> service = new NotificaService();
	String mode = request.getParameter("mode");
	NotificaDTO dto;
	int id;
	boolean ans;
	
	switch (mode.toUpperCase()) {
	case "NOTIFICALISTALL":
		updateListAll(request);
		getServletContext().getRequestDispatcher("/notifica/notificaallmanager.jsp").forward(request, response);
		break;
	case "NOTIFICALIST" :
		updateList(request);
		getServletContext().getRequestDispatcher("/notifica/notificamanager.jsp").forward(request, response);
		break;
		
	case "READ" :
		id = Integer.parseInt(request.getParameter("id"));
		dto = service.read(id);
		request.setAttribute("dto", dto);
		if(!(request.getParameter("type").equals("all"))) {
			if(request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/notifica/readnotifica.jsp").forward(request, response);
			}
			else getServletContext().getRequestDispatcher("/notifica/updatenotifica.jsp").forward(request,response);
		}else {
			if(request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/notifica/readnotificaall.jsp").forward(request, response);
			}
			else getServletContext().getRequestDispatcher("/notifica/updatenotificaall.jsp").forward(request,response);
		}
		break;
		
	case "INSERT" :
		int id_event = Integer.parseInt(request.getParameter("id"));
		boolean notificato = Boolean.parseBoolean(request.getParameter("notificato"));
		String notifica_tempo = request.getParameter("notifica_tempo").toString();
		dto = new NotificaDTO(id_event, notificato, notifica_tempo);
		ans = service.insert(dto);
		request.setAttribute("ans", ans);
		updateList(request);
		if(!(request.getParameter("type").equals("all"))) {
			getServletContext().getRequestDispatcher("/EventServlet?type=none&mode=readevent&id="+id_event+"").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/notifica/notificaallmanager").forward(request, response);
		}
		
		break;
	
	case "UPDATE" :
		id_event = Integer.parseInt(request.getParameter("id_event"));
		notificato = Boolean.parseBoolean(request.getParameter("notificato"));
		notifica_tempo = request.getParameter("notifica_tempo").toString();
		id = Integer.parseInt(request.getParameter("id"));
		dto = new NotificaDTO(id,id_event,notificato,notifica_tempo);
		ans = service.update(dto);
		updateList(request);
		if(!(request.getParameter("type").equals("all"))) {
			getServletContext().getRequestDispatcher("/EventServlet?mode=readevent&id="+id_event+"").forward(request, response);
		}else {
			getServletContext().getRequestDispatcher("/notifica/notificaallmanager").forward(request, response);
		}
		
break;

	case "DELETE":
		id = Integer.parseInt(request.getParameter("id"));
		ans = service.delete(id);
		request.setAttribute("ans", ans);
		updateList(request);
		if(!(request.getParameter("type").equals("all"))) {
			if(request.getParameter("dest").equals("receiver")) {
				getServletContext().getRequestDispatcher("/notifica/notificamanager.jsp").forward(request, response);
			}
			else {
				id_event = Integer.parseInt(request.getParameter("id_e"));
				getServletContext().getRequestDispatcher("/EventServlet?mode=readevent&id="+id_event+"").forward(request, response);
			}
		}else {
			getServletContext().getRequestDispatcher("/notifica/notificaallmanager.jsp").forward(request, response);
		}
		
		break;
	}
	
		
	
}
}
