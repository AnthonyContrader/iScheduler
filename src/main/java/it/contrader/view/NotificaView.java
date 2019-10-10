package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.NotificaDTO;
import it.contrader.main.MainDispatcher;

public class NotificaView extends AbstractView {
	private Request request;
	private String choice;


public NotificaView() {
	
}

//mostra la lista notifiche
@Override

public void showResults(Request request) {
	if(request != null) {
		System.out.println(" \n -----Gestione notifiche----- \n ");
		System.out.println("ID \t IDEVENT \t testo notifica \t notificato?");
		System.out.println("-------------------------------");
		
		@SuppressWarnings("unchecked")
		List<NotificaDTO> notificas = (List<NotificaDTO>) request.get("notificas");
		for(NotificaDTO n : notificas)
			System.out.println(n);
		System.out.println();
	}
}

@Override
public void showOptions() {
	System.out.println("Cosa vuoi fare di questa notifica?");
	System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");
	this.choice = getInput();
}

public void submit() {
	request = new Request();
	request.put("choice", choice);
	request.put("mode", "GETCHOICE");
	MainDispatcher.getInstance().callAction("Notifica","doControl",this.request);
}
	}


