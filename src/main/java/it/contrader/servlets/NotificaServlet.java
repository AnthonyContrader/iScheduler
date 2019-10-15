package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.NotificaDTO;
import it.contrader.service.NotificaService;
import it.contrader.service.Service;

public class NotificaServlet extends HttpServlet{
private static final long serialVersionUID = 1L;

public NotificaServlet() {
	
}

public void updateList(HttpServletRequest request) {
	Service<NotificaDTO> service = new NotificaService();
	List<NotificaDTO> listDTO = service.getAll();
	request.setAttribute("list", listDTO);
	}


public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Service<NotificaDTO> service = new NotificaService();
	String mode = request.getParameter("mode");
	NotificaDTO dto;
	int id;
	boolean ans;
	
	switch (mode.toUpperCase()) {
	
	case "NOTIFICALIST" :
		updateList(request);
		getServletContext().getRequestDispatcher("/notifica/notificamanager.jsp").forward(request, response);
		break;
		
	case "READ" :
		id = Integer.parseInt(request.getParameter("id"));
		dto = service.read(id);
		request.setAttribute("dto", dto);
		
		if(request.getParameter("update") == null) {
			getServletContext().getRequestDispatcher("/notifica/readnotifica.jsp").forward(request, response);
		}
		else getServletContext().getRequestDispatcher("/notifica/updatenotifica.jsp").forward(request,response);
		break;
		
	case "INSERT" :
		int id_event = Integer.parseInt(request.getParameter("id_event"));
		boolean notificato = Boolean.parseBoolean(request.getParameter("notificato"));
		String notifica_tempo = request.getParameter("notifica_tempo").toString();
		dto = new NotificaDTO();
		ans = service.insert(dto);
		request.setAttribute("ans", ans);
		updateList(request);
		getServletContext().getRequestDispatcher("/notifica/notificamanager.jsp").forward(request, response);
		break;
	
	case "UPDATE" :
		id_event = Integer.parseInt(request.getParameter("id_event"));
		notificato = Boolean.parseBoolean(request.getParameter("notificato"));
		notifica_tempo = request.getParameter("notifica_tempo").toString();
		id = Integer.parseInt(request.getParameter("id"));
		dto = new NotificaDTO(id,id_event,notificato,notifica_tempo);
		ans = service.update(dto);
		updateList(request);
		getServletContext().getRequestDispatcher("/notifica/notificamanager.jsp").forward(request, response);
break;

	case "DELETE":
		id = Integer.parseInt(request.getParameter("id"));
		ans = service.delete(id);
		request.setAttribute("ans", ans);
		updateList(request);
		getServletContext().getRequestDispatcher("/notifica/notificamanager.jsp").forward(request, response);
		break;
	}
	
		
	
}
}
