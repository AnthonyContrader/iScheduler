package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *Project Lombok is a small library that can be used to reduce the amount of boilerplate
 * Java code that is commonly written for Java classes. Project Lombok does this via
 * annotations that can be added to the Java class for which common methods are desired.
 */

/**
 * Equivalent to @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
 * Technically we could use the annotations above, one by one, instead of @Data
 * @author gabriele
 *
 */

@AllArgsConstructor
@NoArgsConstructor
@Data

/** 
 * The following generate the constructors, one empty constructor and one with all the arguments 
 * @Entity 
 *
 */



//Denotes the class ad an entity class
@Entity
@Table(name="usernotification")
public class UserNotification {
	
	//This is useful to declare which is the primary key for the tab.
	@Id
	@Column(name = "id")
	//GeneratedValue specified the type of generation for the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName ="id")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "idNotification", referencedColumnName = "Name")
	Notification notification;
	

}
