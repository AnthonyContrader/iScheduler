package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.EventDTO;
import it.contrader.main.MainDispatcher;

public class EventView extends AbstractView {
	
	private Request request;
	private String choice;
	
	public EventView() {
		
	}
	
	@Override
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("\n------------------- Gestione eventi ----------------\n");
			System.out.println("ID\t\tNome\t\tCategoria\tDescrizione\tScadenza\tCordinate\tIDUtente");
			System.out.println("----------------------------------------------------\n");

			@SuppressWarnings("unchecked")
			List<EventDTO> events = (List<EventDTO>) request.get("events");
			for (EventDTO ev: events)
				System.out.println(ev);
			System.out.println();
		}
	}
	
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Event", "doControl", this.request);
	}

}
