package it.contrader.dto;

import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventHistoryDTO {

	private Long id;
	private String category;
	private String agentName;
	private String agentSurname;
	private String company;
	private Boolean result;
	private UserDTO userDTO;

}
