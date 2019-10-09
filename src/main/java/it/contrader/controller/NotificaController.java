package it.contrader.controller;

import java.util.List;

import it.contrader.dto.NotificaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.NotificaService;

public class NotificaController implements Controller {
	private static String sub_package = "notifica.";
	
	private NotificaService notificaService;
	public NotificaController() {
		this.notificaService = new NotificaService();
		
		
	}
	
	@Override
	public void doControl(Request request) {
		// TODO Auto-generated method stub
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choise");
		
		int id;
		int id_event;
		boolean notificato;
		String notifica_tempo;
		
		switch (mode) {
		case "READ":
			id = Integer.parseInt(request.get("id").toString());
			NotificaDTO notificaDTO = notificaService.read(id);
			request.put("notifica", notificaDTO);
			MainDispatcher.getInstance().callView(sub_package + "NotificaRead", request);
			
		break;
		
		case "INSERT":
			id_event = Integer.parseInt(request.get("id_event").toString());
			notificato = Boolean.parseBoolean(request.get("notificato").toString());
			notifica_tempo = request.get("notifica_tempo").toString();
			
			NotificaDTO notificatoinsert = new NotificaDTO(id_event, notificato, notifica_tempo);
			notificaService.insert(notificatoinsert);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "NotificaInsert", request);
			break;
			
		case "DELETE":
			id = Integer.parseInt(request.get("id").toString());
			notificaService.delete(id);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "NotificaDelete", request);
			break;
			
		case "UPDATE":
			id = Integer.parseInt(request.get("id").toString());
			id_event = Integer.parseInt(request.get("id_event").toString());
			notificato = Boolean.parseBoolean(request.get("notificato").toString());
			notifica_tempo = request.get("notifica_tempo").toString();
			NotificaDTO notificaToUpdate = new NotificaDTO(id_event, notificato, notifica_tempo);
			notificaToUpdate.setId(id);
			notificaService.update(notificaToUpdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "NotificaUpdate", request);
			break;
			
		case "NOTIFICALIST":
			List<NotificaDTO> notificasDTO = notificaService.getAll();
			request.put("notifica", notificasDTO);
			MainDispatcher.getInstance().callView("Notifica", request);
			break;
			
		case "GETCHOICE":
			
			//toUpperCase() mette in maiuscolo la scelta
	switch (choice.toUpperCase()) {
	
	case "L":
		MainDispatcher.getInstance().callView(sub_package + "NotificaRead", null);
		break;
		
	case "I":
		MainDispatcher.getInstance().callView(sub_package + "NotificaInsert", null);
		break;
		
	case "M":
		MainDispatcher.getInstance().callView(sub_package + "NotificaUpdate", null);
		break;
		
	case "C":
		MainDispatcher.getInstance().callView(sub_package + "NotificaDelete", null);
		break;
		
	case "E":
		MainDispatcher.getInstance().callView("Login", null);
		break;

	case "B":
		MainDispatcher.getInstance().callView("HomeAdmin", null);
		break;
		
	default:
		MainDispatcher.getInstance().callView("Login", null);
	}
	
default:
	MainDispatcher.getInstance().callView("Login", null);
}
		
}

			
			
		
		
		
		}
		
	


