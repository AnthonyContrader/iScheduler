package it.contrader.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import it.contrader.dto.EventDTO;
import it.contrader.model.Event;


@Component
public class EventConverter extends AbstractConverter<Event, EventDTO>{

	
	//NotificationConverter notificationConverter;
	
	@Autowired
	private UserConverter userConverter;
	@Autowired
	CompanyConverter companyConverter;
	@Autowired
	private SectorConverter sConverter;
	
	
	@Override
	public Event toEntity(EventDTO eventDTO) {
		Event event = null;
		if(eventDTO != null) {
			event = new Event();
			event.setId(eventDTO.getId());
			if(eventDTO.getUserDTO()!=null) {
				event.setUser(userConverter.toEntity(eventDTO.getUserDTO()));
			}
			if(eventDTO.getCompany()!= null) {
				
				event.setCompany(companyConverter.toEntity(eventDTO.getCompany()));
			}
			event.setDescription(eventDTO.getDescription());		
			event.setCategory(eventDTO.getCategory());
			event.setName(eventDTO.getName());
			event.setStartDate(eventDTO.getStartDate());
			event.setEndDate(eventDTO.getEndDate());
			event.setArguments(eventDTO.getArguments());
			event.setAgentName(eventDTO.getAgentName());
			event.setAgentSurname(eventDTO.getAgentSurname());
			event.setSector(sConverter.toEntity(eventDTO.getSectorDTO()));
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
			if(event.getCompany()!= null) {
				
				eventDTO.setCompany(companyConverter.toDTO(event.getCompany()));
			}
			eventDTO.setDescription(event.getDescription());		
			eventDTO.setName(event.getName());
			eventDTO.setCategory(event.getCategory());
			eventDTO.setStartDate(event.getStartDate());
			eventDTO.setEndDate(event.getEndDate());
			eventDTO.setArguments(event.getArguments());
			eventDTO.setAgentName(event.getAgentName());
			eventDTO.setAgentSurname(event.getAgentSurname());
			eventDTO.setSectorDTO(sConverter.toDTO(event.getSector()));
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
