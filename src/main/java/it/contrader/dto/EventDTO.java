package it.contrader.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EventDTO {
	
	private Long id;
	private String name;
	private String description;
	private String category;
	private float xPosition;
	private float yPosition;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private UserDTO userDTO;

}
