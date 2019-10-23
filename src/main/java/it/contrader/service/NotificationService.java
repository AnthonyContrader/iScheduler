package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.EventConverter;
import it.contrader.converter.NotificationConverter;
import it.contrader.dao.NotificationRepository;
import it.contrader.dto.EventDTO;
import it.contrader.dto.NotificationDTO;

@Service
public class NotificationService {
	@Autowired
	private NotificationConverter notificationConverter;
	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	private EventConverter eventConverter;
	
	public List<NotificationDTO> getNotificationByEvent(EventDTO eventDTO){
		return notificationConverter.toDTOList(notificationRepository.findNotificationByEvent(eventConverter.toEntity(eventDTO)));
	}
	
	public List<NotificationDTO> getNotificationByEvent_Id(long idEvent){
		return notificationConverter.toDTOList(notificationRepository.findByEvent_id(idEvent));
	}
}
