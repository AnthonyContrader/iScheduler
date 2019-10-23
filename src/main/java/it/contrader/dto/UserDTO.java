package it.contrader.dto;

import java.util.List;

import it.contrader.model.Event;
import it.contrader.model.User.Usertype;
import it.contrader.model.UserNotification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

	private Long id;

	private String username;

	private String password;

	private Usertype usertype;
	
	private List<Event> events;
	
	private List<UserNotification> userNotifications;

}
