package it.contrader.view;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeUserView extends AbstractView{

	private String choice;
	private Request request;
	
	@Override
	public void showResults(Request request) {
		System.out.println("\n CIAO UTENTE\n");

	}

	@Override
	public void showOptions() {
		System.out.println("-------------MENU------------\n");
		System.out.println("[N]otifica [E]sci");
		choice = this.getInput();

	}

	@Override
	public void submit() {
		request = new Request();
		switch (choice) {
		
		case "n":
			this.request.put("mode", "NOTIFICALIST");
			MainDispatcher.getInstance().callAction("Notifica", "doControl", request);
			break;
			
		case "e":
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
			break;

		default:
			MainDispatcher.getInstance().callAction("Login", "doControl", null);
		}
	}

}
