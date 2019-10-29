package it.contrader.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class HelpDeskDTO {
	
	private Long id;
	private String title;
	private ArrayList<String> chatDTO;
	private Long gestorDTO;
	private Boolean reply; //0 quando l'utente risponde/inserisce, 1 quando l
	private UserDTO userDTO;
}
