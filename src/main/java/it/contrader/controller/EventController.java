package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.EventDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.EventService;
import it.contrader.service.UserService;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "http://localhost:4200")
public class EventController extends AbstractController<EventDTO> {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	//POST angular a EventDTO
	@PostMapping(value = "/getallbyuser")
	public List<EventDTO> getAllByUser(@RequestBody UserDTO userDTO){
		return eventService.getAllByUser(userDTO);
		
	}
	
	

}
