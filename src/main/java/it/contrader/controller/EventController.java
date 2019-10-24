
package it.contrader.controller;

import java.time.LocalDateTime;

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
		private EventService eventService;
		@Autowired
		private UserService userService;
		
		@GetMapping("/getallbyid")
		public String getAllByUser(HttpServletRequest request) {
			setAllByUser(request);
			setCountNotification(request);
			return "event/userevents";
		} 
		
		/*@PostMapping("/insert")
		public String insert(HttpServletRequest request, @RequestParam("name") String name, @RequestParam("description") String description,
						  	@RequestParam("category") String category, @RequestParam("xPosition") String xPosition, @RequestParam("yPosition") String yPosition,
						  	@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
			
			boolean check = insertEvent(name, description, category, xPosition, yPosition, startDate, endDate,request.getSession().getAttribute("user"));
			setAllByUser(request);
			return "event/events";
			
		}*/


		@GetMapping("/getall")
		public String getAll(HttpServletRequest request) {
			setAllEvent(request);
			setAllUser(request);
			setCountNotification(request);
			return "event/events";
		}

		@GetMapping("/delete")
		public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
			eventService.delete(id);
			setAllEvent(request);
			return "event/events";
		}

		@GetMapping("/preupdate")
		public String preupdate(HttpServletRequest request, @RequestParam("id") Long id) {
			request.getSession().setAttribute("dto", eventService.read(id));
			return "event/updateevent";
		}

		@PostMapping("/update")
		public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
				@RequestParam("category") String category, @RequestParam("description") String description,
				@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
				@RequestParam("arguments") String arguments, @RequestParam("userid") String userId,
				@RequestParam("agentName") String agentName,@RequestParam("agentSurname") String agentSurname,
				@RequestParam("company") String company) {
			
			EventDTO dto = new EventDTO();
			
			dto.setName(name);
			dto.setCategory(category);
			dto.setDescription(description);
			dto.setStartDate(LocalDateTime.parse(startDate));
			dto.setEndDate(LocalDateTime.parse(endDate));
			dto.setArguments(arguments);
			dto.setAgentName(agentName);
			dto.setAgentSurname(agentSurname);
			dto.setCompany(company);
			dto.setUserDTO(userService.read(Long.parseLong(userId)));
			eventService.update(dto);
			setAllEvent(request);
			return "event/events";
			}
			
			@PostMapping("/insert")
			public String insert(HttpServletRequest request, @RequestParam("name") String name,
				@RequestParam("category") String category, @RequestParam("description") String description,
				@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
				@RequestParam("arguments") String arguments, @RequestParam("userid") String userId,
				@RequestParam("agentName") String agentName,@RequestParam("agentSurname") String agentSurname,
				@RequestParam("company") String company) {
			
				EventDTO dto=new EventDTO();
				dto.setName(name);
				dto.setCategory(category);
				dto.setDescription(description);
				dto.setStartDate(LocalDateTime.parse(startDate));
				dto.setEndDate(LocalDateTime.parse(endDate));
				dto.setArguments(arguments);
				dto.setAgentName(agentName);
				dto.setAgentSurname(agentSurname);
				dto.setCompany(company);
				dto.setUserDTO(userService.read(Long.parseLong(userId)));
				eventService.insert(dto);
				setAllEvent(request);
				return "event/events";
			}
			
			@GetMapping("/read")
			public String read (HttpServletRequest request, @RequestParam("id") Long id) {
				request.getSession().setAttribute("dto", eventService.read(id));
				return "event/readevent";
			}
			
			@GetMapping("/logout")
			public String logout (HttpServletRequest request) {
				request.getSession().invalidate();
				return "index";
			}



		
		/*private boolean insertEvent(String name, String description, String category, String xPosition, String yPosition, String startDate, String endDate, Object userDTO) {
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
			EventDTO ans = eventService.insert(dto);
			if(ans != null) return true;
			else return false;
		
		}
		 */

		private void setAllUser(HttpServletRequest request) {
			request.getSession().setAttribute("userlist", userService.getAll());
		}
		private void setAllEvent(HttpServletRequest request) {
			request.getSession().setAttribute("eventlist", eventService.getAll());
		}
		
		private void setAllByUser(HttpServletRequest request) {
			UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user"); 
			//long idUser = userDTO.getId();
			request.getSession().setAttribute("list", eventService.getAllByUser(userDTO));
		  //request.getSession().setAttribute("list", eventService.getByUser_id(idUser));
			
		}
		
		private void setCountNotification(HttpServletRequest request) {
			
		}
		
		
}