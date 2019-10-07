package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.UserDTO;
import it.contrader.model.User;

/**
 * 
 * @author Vittorio, De Santis 
 *
 */
public class UserConverter   {
	
	/**
	 * Crea un oggetto di tipo UserDTO e lo riempie con i campi del parametro user di tipo User.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public UserDTO toDTO(User user) {
		UserDTO userDTO = new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getUsertype());
		return userDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	public User toEntity(UserDTO userDTO) {
		User user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype());
		return user;
	}
	
	/**
	 * Metodo per convertire le liste di User.
	 */
	public List<UserDTO> toDTOList(List<User> userList) {
		//Crea una lista vuota.
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(User user : userList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			userDTOList.add(toDTO(user));
		}
		return userDTOList;
	}

	
	
}
