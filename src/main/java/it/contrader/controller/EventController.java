package it.contrader.controller;

import java.sql.Date;
import java.util.List;

import it.contrader.dto.EventDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.EventService;

public class EventController implements Controller {
	private static String sub_package = "event."; //Definisco un sotto pacchetto.
	
	private EventService eventService; // Creo il servizio.
	
	public EventController() {
		this.eventService = new EventService();
	}
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode"); // Estrapola la modalita da eseguire
		String choice = (String) request.get("choice");//Estrapola la scelta fatta.
		
		int id,idUser;
		String nome,categoria,descrizione;
		Date scadenza;
		float posizioneX, posizioneY;
		
		switch(mode) {
			case "READ":
				id = Integer.parseInt(request.get("id").toString());// Converte l'id preso dall'esterno come stringa in intero.
				EventDTO eventDTO = eventService.read(id); //Legge l'effettivo valore dal DB passando per DTO.
				request.put("event", eventDTO); //Inserisce i valori estrapolati in una mappa 
				MainDispatcher.getInstance().callView(sub_package + "EventRead", request);
				break;
			case "INSERT":
				idUser = Integer.parseInt(request.get("idUser").toString());
				nome = request.get("nome").toString();
				categoria = request.get("categoria").toString();
				descrizione = request.get("descrizione").toString();
				scadenza = (Date)request.get("scadenza");
				posizioneX = Float.parseFloat(request.get("posizioneX").toString());
				posizioneY = Float.parseFloat(request.get("posizioneY").toString());
								
				EventDTO eventToInsert = new EventDTO(idUser, posizioneX, posizioneY, scadenza, nome, descrizione, categoria);
			
				eventService.insert(eventToInsert);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "EventInsert", request);
				break;
			case "DELETE":
				id = Integer.parseInt(request.get("id").toString());
				eventService.delete(id);
				request = new Request();
				request.put("mode","mode");
				MainDispatcher.getInstance().callView("sub_package" + "EventDelete", request);
				break;
			case "UPDATE":
				id = Integer.parseInt(request.get("id").toString());
				idUser = Integer.parseInt(request.get("idUser").toString());
				nome = request.get("nome").toString();
				categoria = request.get("categoria").toString();
				descrizione = request.get("descrizione").toString();
				scadenza = (Date)request.get("scadenza");
				posizioneX = Float.parseFloat(request.get("posizioneX").toString());
				posizioneY = Float.parseFloat(request.get("posizioneY").toString());
				
				EventDTO eventToUpdate = new EventDTO(posizioneX, posizioneY, scadenza, nome, descrizione, categoria);
				eventToUpdate.setId(id);
				eventToUpdate.setIdUser(idUser);
				eventService.update(eventToUpdate);
				request = new Request();
				request.put("mode", "mode");
				MainDispatcher.getInstance().callView(sub_package + "EventUpdate", request);
				break;
			case "EVENTLIST":
				List<EventDTO> eventsDTO = eventService.getAll();
				//Impacchetta la request con la lista degli eventi
				request.put("events", eventsDTO);
				MainDispatcher.getInstance().callView("Event", request);
				break;
			case "GETCHOICE":
				
						//toUpperCase() mette in maiuscolo la scelta
				switch (choice.toUpperCase()) {
				
				case "L":
					MainDispatcher.getInstance().callView(sub_package + "EventRead", null);
					break;
					
				case "I":
					MainDispatcher.getInstance().callView(sub_package + "EventInsert", null);
					break;
					
				case "M":
					MainDispatcher.getInstance().callView(sub_package + "EventUpdate", null);
					break;
					
				case "C":
					MainDispatcher.getInstance().callView(sub_package + "EventDelete", null);
					break;
					
				case "E":
					MainDispatcher.getInstance().callView("Login", null);
					break;
			
				case "B":
					MainDispatcher.getInstance().callView("HomeAdmin", null);
					break;
				default:
					MainDispatcher.getInstance().callView("Event", null);

				}
			default:
				MainDispatcher.getInstance().callView("Event", null);
	
		}
	}

}
