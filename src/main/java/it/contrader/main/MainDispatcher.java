package it.contrader.main;


import java.lang.reflect.Method;
import it.contrader.controller.Controller;
import it.contrader.controller.Request;
import it.contrader.view.View;
/*
 * La classe MainDispatcher si occupa di implementare il pattern MVC all'interno di questo progetto Java Console
 * PER ULTERIORI INFORMAZIONI , GUIDA SEZIONE 4
 * PS: nella pratica simula le funzioni di un Web Server instradando le varie richieste che arrivano ad esso.
 * PS: Implementa anche il pattern Singleton
 */
public class MainDispatcher {
	
	/*
	 * Costruttore Vuoto
	 */
	private MainDispatcher() {
	}

	private static MainDispatcher instance;
	
	/*
	 * il metodo getInstance è alla base del pattern Singleton
	 * per ulteriori rimandi vedere la classe Connection Singleton o la guida SEZIONE 10	
	 */
	public static MainDispatcher getInstance() {
		if (instance == null) {
			instance = new MainDispatcher();
		}
		return instance;
	}
	
	/*
	 * metodo CallAction
	 * parametri:  - String controller : è una stringa che rappresenta il nome specifico dell'entità di cui vogliamo chiamare 
	 * 									 il controller. 
	 * 									esempio "UtenteController" verra chiamato tramite "Utente"
     * 			   - String action : è una stringa che indica il metodo che voglio far compiere dal controller prima indicato
     * 									esempio " UtenteController.doControll() " verrà chiamato semplicemente con "doControl"
     * 			   - Request request: contiene una map di valori salvati come ("chiave","valore") che verranno passati al Controller
	 *
	 * output: niente essendo di tipo void.
	 * funzionamento : tramite questa " semplice " funzione riusciamo ad accedere ai vari controller senza doverli instanziare di
	 * 					volta in volta nelle varie view.
	 * 					Essa quando chiamata cerchera di creare un'instanza della classe inserita in controller, controllerà
	 * 					in seguito se essa possiede un metodo con il nome inviato e passati tutti questi controlli 
	 * 					invocherà tale metodo passando ad esso la request contente i vari dati che stiamo facendo viaggiare 
	 * 					all'interno del programma.
	 */
	public void callAction(String controller, String action, Request request) {
		Controller oggettoController = (Controller) ReflectionUtils
				.instantiateClass("it.contrader.controller." + controller + "Controller");
		try {
			Method metodo = oggettoController.getClass().getMethod(action, Request.class);
			metodo.invoke(oggettoController, request);
		} catch (Throwable e) {
	
		}
	}
	
	
	/*
	 * metodo callView
	 * parametri: String view : contiene il nome della classe che implementa la view interessata
	 * 							esempio "UtenteView" verrà chiamato tramite "Utente"
 * 				  Request request : contiene la mappa di dati salvata come ("chiave","valore") che utilizziamo per il trasporto 
 * 									delle informazioni
 * 		output: nessuno in quanto metodo di tipo void
 * 		funzionamento : Instazia una classe view, e chiama di essa in sequenza il metodi showResult() passandogli i vari dati in
 * 						request, poi showOption ed infine submit()
	 */
	public void callView(String view, Request request) {
		View oggettoView = (View) ReflectionUtils.instantiateClass("it.contrader.view." + view + "View");
		oggettoView.showResults(request);
		oggettoView.showOptions();
		oggettoView.submit();
	}
}
