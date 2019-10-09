package it.contrader.view.event;


import java.sql.Date;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class EventUpdateView extends AbstractView {
	private Request request;

	private int id,idUser;
	private String nome,categoria,descrizione;
	private Date scadenza;
	private float posizioneX, posizioneY;
	private final String mode = "UPDATE";

	public EventUpdateView() {
	}

	/**
	 * Se la request non � nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Event", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dell evento da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci l'id dell'evento:");
			id = Integer.parseInt(getInput());
			System.out.println("Inserisci l'id dell'utente legato all'evento:");
			idUser = Integer.parseInt(getInput());
			System.out.println("Inserisci il nome dell'evento:");
			nome = getInput();
			System.out.println("Inserisci la descrizione dell'evento:");
			descrizione = getInput();
			System.out.println("Inserisci la categoria dell'evento:");
			categoria = getInput();
			System.out.println("Inserisci la scadenza dell'evento:");
			scadenza = getInputDate();
			System.out.println("Inserisci la cordinata X:"); // Dovrebbe essere calcolata automaticamente.
			posizioneX = Float.parseFloat(getInput());
			System.out.println("Inserisci la cordinata Y:");
			posizioneY = Float.parseFloat(getInput());
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("id", id);
		request.put("idUser", idUser);
		request.put("nome", nome);
		request.put("descrizione", descrizione);
		request.put("categoria", categoria);
		request.put("scadenza", scadenza);
		request.put("posizioneX", posizioneX);
		request.put("posizioneY", posizioneY);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Event", "doControl", request);
	}

}
