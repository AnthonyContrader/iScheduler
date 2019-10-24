package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.NotificationDTO;
import it.contrader.service.EventService;
import it.contrader.service.NotificationService;

@Controller
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private EventService eventService;
	
	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("listusers") String[] users, @RequestParam("description") String description ) {
		for(String user: users) {
			long id = Long.parseLong(user);
			NotificationDTO notificationDTO = new NotificationDTO();
			notificationDTO.setDescription(description);
			notificationDTO.setEventDTO(eventService.read(id));
			notificationService.insert(notificationDTO);
			
		}
			return "event/events";
	}
	
	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") long id) {
		request.getSession().setAttribute("notificationlist", notificationService.getNotificationByEvent_Id(id));
		return "notification/notifications";
	}
}
