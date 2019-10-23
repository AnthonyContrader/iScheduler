package it.contrader.dto;

import java.time.LocalDateTime;
import java.util.List;

import it.contrader.model.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * 
 * @Author Federico.
 * 
 * 
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
	
	private Long id;
	private String name;
	private String description;
	private String category;
	private String arguments;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private UserDTO userDTO;
	private List<Notification> notificationsDTO;

}
