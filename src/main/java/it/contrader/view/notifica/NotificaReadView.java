package it.contrader.view.notifica;

import it.contrader.controller.Request;
import it.contrader.dto.NotificaDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class NotificaReadView extends AbstractView {
	private Request request;
	
	private int id;
	private final String mode = "READ";
	
	public NotificaReadView() {
		
	}

	public void showResults(Request request) {
		if (request != null) {
			NotificaDTO notifica = (NotificaDTO) request.get("notifica");
			System.out.println(notifica);
			MainDispatcher.getInstance().callView("Notifica", null);
		}
	}
	
	public void showOptions() {
		System.out.println("Inserisci id notifica che vuoi leggere");
		id = getInputCheckValueInt(getInput());
	}
	
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Notifica","doControl",request);
	}
	
}
