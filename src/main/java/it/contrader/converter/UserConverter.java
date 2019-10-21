package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.UserDTO;

import it.contrader.model.User;
import java.util.List;

@Component
public class UserConverter extends AbstractConverter<User, UserDTO> {

	@Override
	public User toEntity(UserDTO userDTO) {
		User user = null;
		if (userDTO != null) {
			EventConverter eventConverter = new EventConverter();
			UserNotificationConverter userNotificationConverter = new UserNotificationConverter();
			user = new User(userDTO.getId(), userDTO.getUsername(), userDTO.getPassword(), userDTO.getUsertype(),eventConverter.toEntityList(userDTO.getEvents()), userNotificationConverter.toEntityList(userDTO.getUserNotifications()));
		}
		return user;
	}

	@Override
	public UserDTO toDTO(User user) {
		UserDTO userDTO = null;
		if (user != null) {
			EventConverter eventConverter = new EventConverter();
			UserNotificationConverter userNotificationConverter = new UserNotificationConverter();
			userDTO = new UserDTO(user.getId(), user.getUsername(), user.getPassword(), user.getUsertype(),eventConverter.toDTOList(user.getEvents()), userNotificationConverter.toDTOList(user.getUserNotifications()));

		}
		return userDTO;
	}
}