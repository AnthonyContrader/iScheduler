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

import it.contrader.dto.EventDTO;
import it.contrader.service.EventService;
import it.contrader.service.Service;

public class EventServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public EventServlet() {
		
	}
	
	public void updateList(HttpServletRequest request) {
		Service<EventDTO> service = new EventService();
		List<EventDTO> listDTO = service.getAll();
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
		case "EVENTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/event/eventmanager.jsp").forward(request, response);
			break;
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if(request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/event/updateevent.jsp").forward(request, response);
			}
			
			else getServletContext().getRequestDispatcher("/event/eventupdate.jsp").forward(request, response);
			
			break;
		case "INSERT":
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
			dto = new EventDTO(idUser, posizioneX, posizioneY, scadenza, nome, descrizione, categoria);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/event/eventmanager.jsp").forward(request, response);
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
			getServletContext().getRequestDispatcher("event/eventmanager.jsp").forward(request, response);
			break;
		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/event/eventmanager.jsp").forward(request, response);
			break;
		}
	}
}