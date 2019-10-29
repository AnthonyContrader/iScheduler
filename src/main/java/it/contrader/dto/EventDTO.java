package it.contrader.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class EventDTO {
	
	private Long id;
	private String name;
	private String description;
	private String category;
	private String arguments;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private String agentName;
	private String agentSurname;
	private String company;
	private UserDTO userDTO;
	private List<Notification> notificationsDTO;

}
