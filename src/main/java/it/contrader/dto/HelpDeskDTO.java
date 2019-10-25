package it.contrader.dto;

import java.util.ArrayList;
import java.util.List;
import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelpDeskDTO {
	
	private Long id;
	private String title;
	private ArrayList<String> chatDTO;
	private Long gestorDTO;
	private Boolean reply; //0 quando l'utente risponde/inserisce, 1 quando l
	private UserDTO userDTO;
}
