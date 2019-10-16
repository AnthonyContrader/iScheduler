package it.contrader.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.EventDTO;
import it.contrader.dto.NotificaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.EventService;
import it.contrader.service.NotificaService;
import it.contrader.service.Service;

public class EventServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public EventServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<EventDTO> EventService = new EventService();
		final HttpSession session =  request.getSession();
		//VERIFICARE CHE FUNZIONI IL CAST !
		UserDTO user = (UserDTO) session.getAttribute("user");
		//-----------------------------------------------------
		
		List<EventDTO> listDTO = EventService.getAllById(user.getId());;
		request.setAttribute("list", listDTO);
	}
	
	public void updateListAll(HttpServletRequest request) {
		Service<EventDTO> EventService = new EventService();
		List<EventDTO> listDTO = EventService.getAll();
		request.setAttribute("list", listDTO);
	}
	
	public void updateNotificaList(HttpServletRequest request) {
		Service<NotificaDTO> NotificaService = new NotificaService();
		int idEvent = Integer.parseInt(request.getParameter("id"));
		List<NotificaDTO> listDTO = NotificaService.getAllById(idEvent);
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<EventDTO> service = new EventService();
		
		String mode = request.getParameter("mode");
		EventDTO dto;
		int id;
		int idUser;
		boolean ans;
		String nome,categoria,descrizione,input;
		Date scadenza;
		java.util.Date parsed;
		SimpleDateFormat sdf;
		Float posizioneX,posizioneY;
		
		switch(mode.toUpperCase()) {
		case "EVENTLISTALL":
			updateListAll(request);
			getServletContext().getRequestDispatcher("/event/eventallmanager.jsp").forward(request, response);
		case "EVENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/event/eventmanager.jsp").forward(request, response);
			break;
		case "READEVENT":
			updateNotificaList(request);
			getServletContext().getRequestDispatcher("/event/readnotificaevent.jsp").forward(request, response);
			break;
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			if(!(request.getParameter("type").equals("all"))) {
				if(request.getParameter("update") == null) {
					getServletContext().getRequestDispatcher("/event/readevent.jsp").forward(request, response);
				}
				
				else getServletContext().getRequestDispatcher("/event/updateevent.jsp").forward(request, response);
			}else {
				if(request.getParameter("update") == null) {
					getServletContext().getRequestDispatcher("/event/readeventall.jsp").forward(request, response);
				}
				
				else getServletContext().getRequestDispatcher("/event/updateeventall.jsp").forward(request, response);
			}
			
			
			break;
		case "INSERT":
			final HttpSession session =  request.getSession();
			UserDTO user = (UserDTO) session.getAttribute("user");
			idUser = user.getId();
			//idUser = Integer.parseInt(request.getParameter("idUser").toString());
			nome = request.getParameter("nome").toString();
			categoria = request.getParameter("categoria").toString();
			descrizione = request.getParameter("descrizione").toString();
			parsed = null;
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			input = request.getParameter("scadenza");
			try {
				parsed = sdf.parse(input);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scadenza = new Date(parsed.getTime());
			posizioneX = Float.parseFloat(request.getParameter("posizioneX").toString());
			posizioneY = Float.parseFloat(request.getParameter("posizioneY").toString());
			dto = new EventDTO(idUser, posizioneX, posizioneY, scadenza, nome, descrizione, categoria);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			if(!(request.getParameter("type").equals("all"))) {
				getServletContext().getRequestDispatcher("/event/eventmanager.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/event/eventallmanager.jsp").forward(request, response);
			}
			
			break;
		case "UPDATE":
			id = Integer.parseInt(request.getParameter("id").toString());
			idUser = Integer.parseInt(request.getParameter("idUser").toString());
			nome = request.getParameter("nome").toString();
			categoria = request.getParameter("categoria").toString();
			descrizione = request.getParameter("descrizione").toString();
			parsed = null;
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			input = request.getParameter("scadenza");
			try {
				parsed = sdf.parse(input);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scadenza = new Date(parsed.getTime());
			posizioneX = Float.parseFloat(request.getParameter("posizioneX").toString());
			posizioneY = Float.parseFloat(request.getParameter("posizioneY").toString());
			dto = new EventDTO(id, idUser, posizioneX, posizioneY, scadenza, nome, descrizione, categoria);
			ans = service.update(dto);
			updateList(request);
			if(!(request.getParameter("type").equals("all"))){
				getServletContext().getRequestDispatcher("/event/eventmanager.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/event/eventallmanager.jsp").forward(request, response);
			}
			
			break;
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			if(!(request.getParameter("type").equals("all"))){
				getServletContext().getRequestDispatcher("/event/eventmanager.jsp").forward(request, response);
			}else {
				getServletContext().getRequestDispatcher("/event/eventallmanager.jsp").forward(request, response);
			}
			
			break;
		}
	}
}
