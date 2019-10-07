package it.contrader.controller;

import java.util.HashMap;
import java.util.Map;

/*
 * la classe Request è un implementazione di una HashMap
 * mappa esattamente ogni metodo in un metodo della suddetta classe
 * a livello pratico rappresenta un insieme di dati salvati secondo il concetto che ad ogni chiave corrisponde un valore
 */
public class Request {
	
	/*
	 * tramite i generici dichiaro i tipi di variabili che la variabile accetterà in questo caso String per la chiave
	 * e Object per il valore associato
	 */
	private Map<String, Object> parameters;

	public Request(){
		this.parameters = new HashMap<String, Object>();
	}
	/*
	 * metodo put:
	 * paramentri: String key : stringa che rapprenseterà la chiave di ricerca per il valore
	 * 							PS: se la chiave gia esiste il valore verrà sovrascritto
	 * 			   Object value : rapprenseta il valore associato alla chiave
	 * 							dichiarato come Object in quando più che un valore vero e proprio rappresenta una parte di memoria
	 * 							quindi potrei inserire come value un oggetto di tipo String , un Integer o volendo anche un 
	 * 							Oggetto più complesso come tutto un user
	 * output : void quindi niente
	 */
	public void put(String key, Object value){
		this.parameters.put(key, value);
	}
	/*
	 * metodo get
	 * parametri: String key : la chiave di cui voglio recuperare i valore associato
	 * output: Object : l'output sarà l'oggetto associato alal chiave dovrò quindi eseguire in fase di richiamo il giusto cast in 
	 * 					modo da non perdere informazioni
	 */
	public Object get(String key){
		return this.parameters.get(key);
	}
	/*
	 * metodo getString
	 * paramentro : String key: la chiave di cui voglio recuperare il valore
	 * output: Object : l'output sarà il corrispettivo String del valore associato
	 * funzionamento: il metodo toString viene ereditato in maniera standard da tutti gli oggetti non primitivi di java
	 * 				quindi questo metodo non fa altro che chiamare il metodo to string dell' Object valore
	 * 				PS: chiamare dall'esterno request.get(x).toString è la medesima cosa
	 */
	public Object getString(String key){
		Object returnObject = get(key);
		if(returnObject != null)
			return returnObject.toString();
		return null;
	}
}
