package it.contrader.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.HelpDeskDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.HelpDeskService;
import it.contrader.service.UserService;

@Controller
@RequestMapping("/helpdesk")
public class HelpDeskController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private HelpDeskService hdService;
	
	//ESTRAZIONE DEI TICKET PROPRIETARI (USER)
	@GetMapping("/getallbyid")
	public String getAllByUser(HttpServletRequest request) {
		setAllByUser(request);
		return "helpdesk/userhelps";
	}

	//ESTRAZIONE DI TUTTI I TICKET PRESENTI
	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "helpdesk/helps";
	}
	
	//INSERIMENTO TICKET DA PARTE DELL UTENTE
	@PostMapping("insertbyuser")
	public String insertByUser(HttpServletRequest request, @RequestParam("title") String title, @RequestParam("message") String message) {
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");
		HelpDeskDTO hdDTO = new HelpDeskDTO();
		hdDTO.setTitle(title);
		hdDTO.setReply(false);
		ArrayList<String> chat = new ArrayList<>();
		chat.add(userDTO.getUsername()+": "+message);
		hdDTO.setChatDTO(chat);
		hdDTO.setUserDTO(userDTO);
		hdService.insert(hdDTO);
		setAllByUser(request);
		return "helpdesk/userhelps";
	}
	
	//SALVATAGGIO VALORI TICKET ATTUALE E REINDIRIZZAMENTO SU CHAT PER ULTERIORE REPLY ( UPDATE ) 
	@GetMapping("prereply")
	public String preReply(HttpServletRequest request, @RequestParam("id") String id) {
		request.getSession().setAttribute("hdDTO", hdService.read(Long.parseLong(id)));
		return "helpdesk/updatehelps";
	}
	
	//SETTAGGIO VALORI PER RISPONDERE AD UN TICKET DA PARTE DELL'ADMIN
	@PostMapping("reply")
	public String reply(HttpServletRequest request, @RequestParam("message") String message, @RequestParam("id") String id, @RequestParam("idUser") String idUser, @RequestParam("title") String title) {
		UserDTO gestorDTO = (UserDTO)request.getSession().getAttribute("user");
		HelpDeskDTO hdDTO = new HelpDeskDTO();
		ArrayList<String> chat = hdService.read(Long.parseLong(id)).getChatDTO();
		chat.add(gestorDTO.getUsername()+": "+message);
		hdDTO.setChatDTO(chat);
		hdDTO.setTitle(title);
		hdDTO.setId(Long.parseLong(id));
		hdDTO.setGestorDTO(gestorDTO.getId());
		hdDTO.setReply(true);
		hdDTO.setUserDTO(userService.read(Long.parseLong(idUser)));
		hdService.update(hdDTO);
		request.getSession().setAttribute("hdDTO", hdService.read(Long.parseLong(id)));
		//setAll(request);
		return "helpdesk/updatehelps";
		
	}
	
	//SETTAGGIO VALORI PER RISPONDERE AD UN TICKET DA PARTE DELLO USER.
	@GetMapping("prereplybyuser")
	public String preReplyUser(HttpServletRequest request, @RequestParam("id") String id) {
		request.getSession().setAttribute("hdDTO", hdService.read(Long.parseLong(id)));
		return "helpdesk/updateuserhelps";
	}
	
	@PostMapping("replybyuser")
	public String replyUser(HttpServletRequest request, @RequestParam("message") String message, @RequestParam("id") String id, @RequestParam("idGestor") String idGestor, @RequestParam("title") String title) {
		UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
		HelpDeskDTO hdDTO = new HelpDeskDTO();
		ArrayList<String> chat = hdService.read(Long.parseLong(id)).getChatDTO();
		chat.add(userDTO.getUsername()+": "+message);
		hdDTO.setChatDTO(chat);
		hdDTO.setId(Long.parseLong(id));
		hdDTO.setGestorDTO(Long.parseLong(idGestor));
		hdDTO.setUserDTO(userDTO);
		hdDTO.setTitle(title);
		hdDTO.setReply(false);
		hdService.update(hdDTO);
		request.getSession().setAttribute("hdDTO", hdService.read(Long.parseLong(id)));
		//setAll(request);
		return "helpdesk/updateuserhelps";
	}
	
	//TUTTI I VALORI DI HD
	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("service", userService);
		request.getSession().setAttribute("list", hdService.getAll());
	}
	
	//TUTTI I VALORI DI HD PER UN UTENTE
	private void setAllByUser(HttpServletRequest request){
		request.getSession().setAttribute("service", userService);
		UserDTO userDTO =(UserDTO) request.getSession().getAttribute("user");
		request.getSession().setAttribute("list", hdService.getAllByUser(userDTO));
	}
}
