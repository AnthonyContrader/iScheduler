package it.contrader.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {

	public enum Usertype {
		ADMIN, USER
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "username", unique = true)
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "usertype")
	private Usertype usertype;
	
	//Relazione tra utente e i suoi eventi
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<Event> events;
	
	//Relazione tra utenti e le notifiche ricevute.
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	private List<UserNotification> userNotifications;
	

}
