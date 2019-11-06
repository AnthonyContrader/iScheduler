package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.EventDTO;
import it.contrader.dto.NotificationDTO;
import it.contrader.service.NotificationService;

@RestController
@RequestMapping("/notification")
@CrossOrigin(origins = "http://localhost:4200")

public class NotificationController extends AbstractController<NotificationDTO> {

	@Autowired
	private NotificationService notService;
	
	@PostMapping("/getallbyevent")
	public List<NotificationDTO> getAllByEvent(@RequestBody EventDTO eventDTO){
		return notService.findAllByEvent(eventDTO);
	}
}
