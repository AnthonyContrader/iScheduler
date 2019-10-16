package it.contrader.model;

public class UserNotification {
	

	/**
	 * 
	 *
	 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
	 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
	 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
	 *Per la descrizione della classe far riferimento al Model "UserNotification".
	 */
	
		private int id;
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((notifica_tempo == null) ? 0 : notifica_tempo.hashCode());
		result = prime * result + (notificato ? 1231 : 1237);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserNotification other = (UserNotification) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
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



		private String nome,notifica_tempo;
		private boolean notificato;

	
		
		public UserNotification() {
			
		}



		public UserNotification(int id, String nome, String notifica_tempo, boolean notificato) {
			super();
			this.id = id;
			this.nome = nome;
			this.notifica_tempo = notifica_tempo;
			this.notificato = notificato;
		}



		public int getId() {
			return id;
		}



		public void setId(int id) {
			this.id = id;
		}



		public String getNome() {
			return nome;
		}



		public void setNome(String nome) {
			this.nome = nome;
		}



		public String getNotifica_tempo() {
			return notifica_tempo;
		}



		public void setNotifica_tempo(String notifica_tempo) {
			this.notifica_tempo = notifica_tempo;
		}



		public boolean isNotificato() {
			return notificato;
		}



		public void setNotificato(boolean notificato) {
			this.notificato = notificato;
		}



		@Override
		public String toString() {
			return "UserNotificationDTO [id=" + id + ", nome=" + nome + ", notifica_tempo=" + notifica_tempo
					+ ", notificato=" + notificato + "]";
		}



	}


