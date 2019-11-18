package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;

@Component
public class UserConverter extends AbstractConverter<User, UserDTO> {
	
	@Autowired
	EventConverter eventConverter;
	
	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			user = new User();
			user.setId(userDTO.getId());
			user.setUsername(userDTO.getUsername());
			user.setPassword(userDTO.getPassword());
			user.setUsertype(userDTO.getUsertype());
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setUsername(user.getUsername());
			userDTO.setPassword(user.getPassword());
			userDTO.setUsertype(user.getUsertype());
		}	
		return userDTO;
	}
}


/*public class UserConverter{
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if(user != null) {
			userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setPassword(user.getPassword());
			userDTO.setUsername(user.getUsername());
			userDTO.setUsertype(user.getUsertype());
			userDTO.setEvents(ConverterEvent);
		}
	}
	
	
}*/