
package it.contrader.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.EventDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.*;
@Controller
@RequestMapping("/event")
public class EventController {

		@Autowired
		private EventService service;
		
		@GetMapping("/getallbyid")
		public String getAllByUser(HttpServletRequest request) {
			setAllByUser(request);
			return "event/events";
		}
		
		@PostMapping("/insert")
		public String insert(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("description") String description,
						  	@RequestParam("category") String category, @RequestParam("xPosition") String xPosition, @RequestParam("yPosition") String yPosition,
						  	@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
			
			boolean check = insertEvent(name, description, category, xPosition, yPosition, startDate, endDate,request.getSession().getAttribute("user"));
			setAllByUser(request);
			return "event/events";
			
		}

		
		
		private boolean insertEvent(String name, String description, String category, String xPosition, String yPosition, String startDate, String endDate, Object userDTO) {
			EventDTO dto = new EventDTO();
			LocalDateTime startD,endD;
			dto.setName(name);
			dto.setDescription(description);
			dto.setCategory(category);
			dto.setXPosition(Float.parseFloat(xPosition));
			dto.setYPosition(Float.parseFloat(yPosition));
			startD = LocalDateTime.parse(startDate, DateTimeFormatter.ISO_DATE_TIME);
			endD = LocalDateTime.parse(endDate, DateTimeFormatter.ISO_DATE_TIME);
			dto.setStartDate(startD);
			dto.setEndDate(endD);
			dto.setUserDTO((UserDTO)userDTO);
			EventDTO ans = service.insert(dto);
			if(ans != null) return true;
			else return false;
		
		}
		
		private void setAllByUser(HttpServletRequest request) {
			UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user"); 
			//long idUser = userDTO.getId();
			request.getSession().setAttribute("list", service.getAllByUser(userDTO));
		  //request.getSession().setAttribute("list", service.getByUser_id(idUser));
			
		}
		
		
}