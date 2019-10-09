package it.contrader.dto;

public class NotificaDTO {

		private int id;

		private String notifica_tempo;
		
		private boolean notificato;
		
		private int id_event;
				
		
		/**
		 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costruire oggetti di tipo Notifica
		 */
		public NotificaDTO() {
			
		}

		public NotificaDTO (int id_event, boolean notificato, String notifica_tempo) {
			this.notifica_tempo = notifica_tempo;
			this.notificato = notificato;
		}

		public NotificaDTO (int id, int id_event, boolean notificato, String notifica_tempo) {
			this.id = id;
			this.notifica_tempo = notifica_tempo;
			this.notificato = notificato;
			this.id_event = id_event;
			
		}

		/**
		 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di Notifica
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


}
