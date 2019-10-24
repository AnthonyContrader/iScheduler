package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.contrader.dto.UserDTO;
import it.contrader.service.EventHistoryService;

@Controller
@RequestMapping("/history")
public class EventHistoryController {
	
	//DA FARE ANCORA
	@Autowired
	private EventHistoryService eventHistoryService;
	
	
	@GetMapping("/listbyid")
	public String getAllById(HttpServletRequest request) {
		setAllEvent(request);
		return "event/eventhistory";
	}
	
	private void setAllEvent(HttpServletRequest request) {
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
		long id = userDTO.getId();
		request.getSession().setAttribute("historylist", eventHistoryService.findAllByUser_id(id));
	}


}
