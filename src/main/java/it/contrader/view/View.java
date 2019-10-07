package it.contrader.view;

import it.contrader.controller.Request;

/**
 * IMPORTANTE: Le View non invocano MAI i metodi dei controller, ma comunicano con questi tramite request 
 * che vengono trasferite attraverso il MainDispatcher.
 */
public interface View {
	/*
	 * metodo showResult
	 * parametro: request : contiene i valori mappati come chiave valore
	 * funzionamento: generalmente il metodo showResult stamperà su schermo i vari dati che la singola view necessità di far
	 * 					vedere come per esempio la lista degli utenti o cose del genere, nel caso non ci sia bisogno di mostrare
	 * 					dati puo essere lasciato vuoto.
	 */
	public void showResults (Request request);
	/*
	 * funzionamento : il metodo showOption mostrerà su schermo di volta in volta le varie opzione ( una sorta di menu )
	 * 				a disposizione dell'utente e recuperera da tastiera i vari input per il menu
	 */
	public void showOptions ();
	/*
	 * funzionamento : il metodo si occupa di immagazzinare i dati nella Request e procedere poi a chiamare, tramite il mainDispatcher
	 * 				il controller che implementa la logica necessaria.
	 */
	public void submit();
}
