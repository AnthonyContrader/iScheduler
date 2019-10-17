package it.contrader.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.UserNotificationDTO;
import it.contrader.service.UserNotificationService;

public class UserNotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		
		switch (mode.toUpperCase()) {
		case "INSERT":
			int idNotifica = Integer.parseInt(request.getParameter("notifica"));
			int idUser = Integer.parseInt(request.getParameter("user"));
			UserNotificationService uservice = new UserNotificationService();
			UserNotificationDTO uDTO = new UserNotificationDTO();
			uDTO.setIdNotifica(idNotifica);
			uDTO.setIdUser(idUser);
			uservice.insert(uDTO);
			getServletContext().getRequestDispatcher("/homeuser.jsp").forward(request, response);
			break;
		}
	}

}
