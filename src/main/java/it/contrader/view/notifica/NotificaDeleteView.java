package it.contrader.view.notifica;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class NotificaDeleteView extends AbstractView {
	private Request request;
	private int id;
	private final String mode = "DELETE";
	
	public NotificaDeleteView() {
		
	}
	
	public void showResults(Request request) {
		if(request != null) {
			System.out.println("La notifica è stata cancellata. \n");
		MainDispatcher.getInstance().callView("Notifica",null);
	}
}
	
	public void showOptions() {
		System.out.println("Inserisci id notifica:");
		id = Integer.parseInt(getInput());
	}

	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Notifica","doControl", request);
		
	}
}
