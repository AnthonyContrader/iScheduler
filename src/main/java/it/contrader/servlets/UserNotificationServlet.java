package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.UserDTO;
import it.contrader.dto.UserNotificationDTO;
import it.contrader.service.Service;
import it.contrader.service.UserNotificationService;
import it.contrader.service.UserService;

public class UserNotificationServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	public UserNotificationServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<UserNotificationDTO> service = new UserNotificationService();
		List<UserNotificationDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode");
		mode = mode.toUpperCase();
		if (mode.equals("USERNOTIFICATIONLIST")) {
			updateList(request);
			getServletContext().getRequestDispatcher("/user/readusernotification.jsp").forward(request, response);
		}
	}

}
