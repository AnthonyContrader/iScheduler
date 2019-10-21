package it.contrader.dto;

import java.util.List;

import it.contrader.model.User.Usertype;
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
	
	private List<EventDTO> events;
	
	private List<UserNotificationDTO> userNotifications;

}
