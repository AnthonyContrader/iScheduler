package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Notifica {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int id;

	private String notifica_tempo;
	
	private boolean notificato;
	
	private int id_event;
	
	
	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costruire oggetti di tipo User
	 */
	public Notifica() {
		
	}

	public Notifica (int id_event, boolean notificato, String notifica_tempo) {
		this.notifica_tempo = notifica_tempo;
		this.notificato = notificato;
		this.id_event = id_event;
	}

	public Notifica (int id, int id_event, boolean notificato, String notifica_tempo) {
		this.id = id;
		this.notifica_tempo = notifica_tempo;
		this.notificato = notificato;
		
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_event() {
		return this.id_event;
	}
	public void setId_event(int id_event) {
		this.id_event = id_event;
	}

	public String getNotifica_tempo() {
		return this.notifica_tempo;
	}

	public void setNotifica_tempo(String notifica_tempo) {
		this.notifica_tempo = notifica_tempo;
	}


	public boolean getNotificato() {
		return this.notificato;
	}

	public void setNotificato(boolean notificato) {
		this.notificato = notificato;
	}


	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  id + "\t"  + notifica_tempo +"\t\t" +   notificato;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notifica other = (Notifica) obj;
		if (id != other.id)
			return false;
		if (id_event != other.id_event)
			return false;
		if (notifica_tempo == null) {
			if (other.notifica_tempo != null)
				return false;
		} else if (!notifica_tempo.equals(other.notifica_tempo))
			return false;
		if (notificato != other.notificato)
			return false;
		return true;
	}

	
	}
