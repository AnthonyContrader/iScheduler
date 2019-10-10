package it.contrader.view.notifica;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class NotificaUpdateView extends AbstractView {
	
	private Request request;
	private int id;
	private String notifica_tempo;
	private int id_event;
	private boolean notificato;
	
	private final String mode = "UPDATE";
	
	public NotificaUpdateView() {
		
	}

	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica della notifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Notifica", null);
		}
		
	}

	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id della notifica:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci id_event");
			id_event = Integer.parseInt(getInput());
			System.out.println("inserisci testo di prova");
			notifica_tempo = getInput();
			System.out.println("Inserisci notificato o true o false");
			notificato = Boolean.parseBoolean(getInput());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("notificato", notificato);
		request.put("id_event", id_event);
		request.put("notifica_tempo", notifica_tempo);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Notifica", "doControl", request);
		
	}

}
