package it.contrader.model;

public class UserNotification {

	private int id, idUser, idNotification;

	public UserNotification() {

	}

	public UserNotification(int idUser, int idNotification) {
		this.idUser = idUser;
		this.idNotification = idNotification;

	}

	public UserNotification(int id, int idUser, int idNotification) {
		this.id = id;
		this.idUser = idUser;
		this.idNotification = idNotification;
	}

	
	//Generate the getter and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdNotification() {
		return idNotification;
	}

	public void setIdNotification(int idNotification) {
		this.idNotification = idNotification;
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
		if (idUser != other.idUser)
			return false;
		if (idNotification != other.idNotification)
			return false;
		return true;
	}
	
	

}
