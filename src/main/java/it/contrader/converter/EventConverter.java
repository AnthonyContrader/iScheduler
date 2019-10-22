package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.EventDTO;
import it.contrader.model.Event;


@Component
public class EventConverter extends AbstractConverter<Event, EventDTO>{

	@Autowired
	private NotificationConverter notificationConverter;
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public Event toEntity(EventDTO eventDTO) {
		Event event = null;
		if(eventDTO != null) {
			event = new Event(eventDTO.getId(), eventDTO.getName(), eventDTO.getDescription(),
							  eventDTO.getCategory(), eventDTO.getXPosition(), eventDTO.getYPosition(), 
							  eventDTO.getStartDate(), eventDTO.getEndDate(),userConverter.toEntity(eventDTO.getUserDTO()),
							  notificationConverter.toEntityList(eventDTO.getNotificationsDTO()));
		}
		return event;
	}

	@Override
	public EventDTO toDTO(Event event) {
		EventDTO eventDTO = null;
		if(event!= null) {
			eventDTO = new EventDTO(event.getId(), event.getName(), event.getDescription(),
					event.getCategory(), event.getXPosition(), event.getYPosition(),
					event.getStartDate(), event.getEndDate(), userConverter.toDTO(event.getUser()),
					notificationConverter.toDTOList(event.getNotifications()));
		}
		return eventDTO;
	}
	
	
	

}
