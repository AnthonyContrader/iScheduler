package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.NotificationDTO;

import it.contrader.model.Notification;

@Component
public class NotificationConverter extends AbstractConverter<Notification, NotificationDTO> {

	@Autowired
	private EventConverter eventConverter;
	@Autowired
	private UserNotificationConverter userNotificationConverter;
	
	@Override
	public Notification toEntity(NotificationDTO notificationDTO) {
		Notification notification = null;
		if (notificationDTO != null) {
			notification = new Notification(notificationDTO.getId(), notificationDTO.getDescription(),
						   					eventConverter.toEntity(notificationDTO.getEventDTO()),
						   					notificationDTO.getUserNotificationsDTO());
		}
		return notification;
	}

	@Override
	public NotificationDTO toDTO(Notification notification) {
		NotificationDTO notificationDTO = null;
		if (notification != null) {
			notificationDTO = new NotificationDTO(notification.getId(), notification.getDescription(),
												  eventConverter.toDTO(notification.getEvent()),
												  notification.getUserNotifications());
		}
		return notificationDTO;
	}
}