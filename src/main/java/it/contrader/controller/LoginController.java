package it.contrader.controller;

import it.contrader.main.MainDispatcher;

public class LoginController implements Controller {
	public LoginController() {
	}

	public void doControl (Request request) {
		/**
		 * Attraverso il Dispatcher va alla pagina di autenticazione
		 */
		MainDispatcher.getInstance().callView("Login", request);
	}

}
