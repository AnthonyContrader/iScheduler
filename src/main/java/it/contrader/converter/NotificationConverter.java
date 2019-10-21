package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.NotificationDTO;

import it.contrader.model.Notification;

@Component
public class NotificationConverter extends AbstractConverter<Notification, NotificationDTO> {

	@Override
	public Notification toEntity(NotificationDTO notificationDTO) {
		Notification notification = null;
		if (notificationDTO != null) {
			notification = new Notification(notificationDTO.getId(), notificationDTO.getDescription(), notificationDTO.getIdEvent());
		}
		return notification;
	}

	@Override
	public NotificationDTO toDTO(Notification notification) {
		NotificationDTO notificationDTO = null;
		if (notification != null) {
			notificationDTO = new NotificationDTO(notification.getId(), notification.getDescription(), notification.getIdEvent());

		}
		return notificationDTO;
	}
}