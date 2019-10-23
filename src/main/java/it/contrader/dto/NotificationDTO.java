package it.contrader.dto;

import java.util.List;

import it.contrader.model.Event;
import it.contrader.model.UserNotification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NotificationDTO {

	private Long id;

	private String description;

	private EventDTO eventDTO;
	
	/*private List<UserNotification> userNotificationsDTO;*/

}
