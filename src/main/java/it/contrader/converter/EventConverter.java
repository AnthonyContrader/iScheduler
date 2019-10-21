package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.contrader.dto.EventDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Event;
import it.contrader.model.User;


@Component
public class EventConverter extends AbstractConverter<Event, EventDTO>{

	@Override
	public Event toEntity(EventDTO eventDTO) {
		Event event = null;
		if(eventDTO != null) {
			UserConverter userConverter = new UserConverter();
			event = new Event(eventDTO.getId(), eventDTO.getName(), eventDTO.getDescription(), eventDTO.getCategory(), eventDTO.getXPosition(), eventDTO.getYPosition(), eventDTO.getStartDate(), eventDTO.getEndDate(),userConverter.toEntity(eventDTO.getUserDTO()));
		}
		return event;
	}

	@Override
	public EventDTO toDTO(Event event) {
		EventDTO eventDTO = null;
		if(event!= null) {
			UserConverter userConverter = new UserConverter();
			eventDTO = new EventDTO(event.getId(), event.getName(), event.getDescription(), event.getCategory(), event.getXPosition(), event.getYPosition(), event.getStartDate(), event.getEndDate(), userConverter.toDTO(event.getUser()));
		}
		return eventDTO;
	}
	
	
	

}
