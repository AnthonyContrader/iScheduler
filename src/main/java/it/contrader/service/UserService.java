package it.contrader.service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

/**
 * 
 * @author Vittorio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class UserService extends AbstractService<User, UserDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public UserService(){
		this.dao = new UserDAO();
		this.converter = new UserConverter();
	}
	

}
