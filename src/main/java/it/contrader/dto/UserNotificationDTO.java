package it.contrader.dto;

public class UserNotificationDTO {
	

	/**
	 * 
	 *
	 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
	 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
	 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
	 *Per la descrizione della classe far riferimento al Model "UserNotification".
	 */
	
		private int id;
		private String nome,notifica_tempo;
		private boolean notificato;
		private int idUser,idNotifica;

	
		
		public int getIdUser() {
			return idUser;
		}


		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}


		public int getIdNotifica() {
			return idNotifica;
		}


		public void setIdNotifica(int idNotifica) {
			this.idNotifica = idNotifica;
		}


		public UserNotificationDTO() {
			
		}


		public UserNotificationDTO(int id, String nome, String notifica_tempo, boolean notificato,int idUser, int idNotifica) {
			super();
			this.id = id;
			this.nome = nome;
			this.notifica_tempo = notifica_tempo;
			this.notificato = notificato;
			this.idUser = idUser;
			this.idNotifica = idNotifica;
		}
		
		
		public UserNotificationDTO(int id, String nome, String notifica_tempo, boolean notificato) {
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


