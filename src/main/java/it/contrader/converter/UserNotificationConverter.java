package it.contrader.converter;

import javax.ws.rs.BeanParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.UserNotificationDTO;
import it.contrader.model.UserNotification;

@Component
public class UserNotificationConverter extends AbstractConverter<UserNotification, UserNotificationDTO> {
	
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private NotificationConverter notificationConverter;
	@Override
	public UserNotification toEntity(UserNotificationDTO unDTO) {
		UserNotification userNotification = null;
		if(unDTO != null) {
			userNotification = new UserNotification(unDTO.getId(), userConverter.toEntity(unDTO.getUserDTO()),
													notificationConverter.toEntity(unDTO.getNotificationDTO()));
		}
		return userNotification;
	}
	@Override
	public UserNotificationDTO toDTO(UserNotification unEntity) {
		UserNotificationDTO userNotificationDTO = null;
		if(unEntity != null) {
			userNotificationDTO = new UserNotificationDTO(unEntity.getId(), userConverter.toDTO(unEntity.getUser()),
														  notificationConverter.toDTO(unEntity.getNotification()));
		}
		return userNotificationDTO;
	}
}
