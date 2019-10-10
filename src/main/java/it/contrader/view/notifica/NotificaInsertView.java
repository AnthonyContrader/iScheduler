package it.contrader.view.notifica;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class NotificaInsertView extends AbstractView{
	private Request request;

	private boolean notificato;
	private String notifica_tempo;
	private int id_event;
	private final String mode = "INSERT";

	public NotificaInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Notifica", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi della notifica da inserire
	 */
	@Override
	public void showOptions() {
			int choose;
			System.out.println("Inserisci notificato della notifica( si = 1, no = 2):");
			choose = getInputCheckValueIntLimit(getInput().toString());
			if(choose == 1 ) {
				notificato = true;
			}else {
				notificato = false;
			}
			System.out.println("Inserisci notifica_tempo della notifica:");
			notifica_tempo = getInput();
			System.out.println("Inserisci id_event della notifica:");
			id_event = getInputCheckValueInt(getInput());
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("notificato", notificato);
		request.put("notifica_tempo", notifica_tempo);
		request.put("id_event", id_event);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Notifica", "doControl", request);
	}


}
