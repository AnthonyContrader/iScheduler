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
	
		private int id,idUser,idNotification;

	
		
		public UserNotificationDTO() {
			
		}

		public UserNotificationDTO (int idUser, int idNotification) {
			this.idUser= idUser;
			this.idNotification= idNotification;
			
		}

		public UserNotificationDTO (int id, int idUser, int idNotification) {
			this.id = id;
			this.idUser= idUser;
			this.idNotification= idNotification;
		}

		public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public int getIdUser() {
			return this.idUser;
		}
		public void setIdUser(int idUser) {
			this.idUser = idUser;
		}
		public int getIdNotification() {
			return this.idNotification;
		}
		public void setIdNotification(int idNotification) {
			this.idNotification = idNotification;
		}

		@Override
		public String toString() {
			return  id + "\t"  + idUser +"\t" +   idNotification ;
		}
	}


