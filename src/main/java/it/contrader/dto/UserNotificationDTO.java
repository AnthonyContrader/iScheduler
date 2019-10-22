package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserNotificationDTO {
	
	private Long id;
	
	private UserDTO userDTO;
	
	private NotificationDTO notificationDTO;

}
