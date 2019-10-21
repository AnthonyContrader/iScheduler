package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.NotificationDTO;

import it.contrader.model.Notification;

@Component
public class NotificationConverter extends AbstractConverter<Notification, NotificationDTO> {

	private EventConverter eventConverter = new EventConverter();
	private UserNotificationConverter userNotificationConverter = new UserNotificationConverter();
	
	@Override
	public Notification toEntity(NotificationDTO notificationDTO) {
		Notification notification = null;
		if (notificationDTO != null) {
			notification = new Notification(notificationDTO.getId(), notificationDTO.getDescription(),
						   					eventConverter.toEntity(notificationDTO.getEventDTO()),
						   					userNotificationConverter.toEntity(notificationDTO.getUserNotificationsDTO()));
		}
		return notification;
	}

	@Override
	public NotificationDTO toDTO(Notification notification) {
		NotificationDTO notificationDTO = null;
		if (notification != null) {
			notificationDTO = new NotificationDTO(notification.getId(), notification.getDescription(),
												  eventConverter.toDTO(notification.getEvent()),
												  userNotificationConverter.toDTO(notification.getUserNotifications()));
		}
		return notificationDTO;
	}
}