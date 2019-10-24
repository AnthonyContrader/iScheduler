package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.EventDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Event;
import it.contrader.model.User;


@Component
public class EventConverter extends AbstractConverter<Event, EventDTO>{

	@Autowired
	NotificationConverter notificationConverter;
	@Autowired
	UserConverter userConverter;
	
	
	@Override
	public Event toEntity(EventDTO eventDTO) {
		Event event = null;
		if(eventDTO != null) {
			event = new Event();
			event.setId(eventDTO.getId());
			if(eventDTO.getUserDTO()!=null) {
				event.setUser(userConverter.toEntity(eventDTO.getUserDTO()));
			}
			event.setDescription(eventDTO.getDescription());
			if(eventDTO.getNotificationsDTO()!=null) {
				event.setNotifications(eventDTO.getNotificationsDTO());
			}
			
			
			event.setCategory(eventDTO.getCategory());
			event.setName(eventDTO.getName());
			event.setStartDate(eventDTO.getStartDate());
			event.setEndDate(eventDTO.getEndDate());
			event.setArguments(eventDTO.getArguments());
			event.setAgentName(eventDTO.getAgentName());
			event.setAgentSurname(eventDTO.getAgentSurname());
			event.setCompany(eventDTO.getCompany());
		}
		return event;
	}

	@Override
	public EventDTO toDTO(Event event) {
		EventDTO eventDTO = null;
		if(event!= null) {
			eventDTO = new EventDTO();
			eventDTO.setId(event.getId());
			if(event.getUser()!=null) {
				eventDTO.setUserDTO(userConverter.toDTO(event.getUser()));
			}
			eventDTO.setDescription(event.getDescription());
			if(event.getNotifications()!=null) {
				eventDTO.setNotificationsDTO(event.getNotifications());
			}
			
			eventDTO.setName(event.getName());
			eventDTO.setCategory(event.getCategory());
			eventDTO.setStartDate(event.getStartDate());
			eventDTO.setEndDate(event.getEndDate());
			eventDTO.setArguments(event.getArguments());
			eventDTO.setAgentName(event.getAgentName());
			eventDTO.setAgentSurname(event.getAgentSurname());
			eventDTO.setCompany(event.getCompany());
		}
		return eventDTO;
	}
	
	
	/*public static List<EventDTO> toListDTO(List<Event> list){
		List<EventDTO> listEventDTO = new ArrayList<>();
		if(!list.isEmpty()) {
			EventConverter eventConverter = new EventConverter();
			for(Event event : list) {
				listEventDTO.add(eventConverter.toDTO(event));
			}
		}
		return listEventDTO;
	}
	*/
	

}
