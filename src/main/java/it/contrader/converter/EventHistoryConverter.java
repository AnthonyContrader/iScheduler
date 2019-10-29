package it.contrader.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.EventHistoryDTO;
import it.contrader.model.EventHistory;

@Component
public class EventHistoryConverter extends AbstractConverter<EventHistory, EventHistoryDTO> {

	
	@Autowired
	UserConverter userConverter;

	@Override
	public EventHistory toEntity(EventHistoryDTO eventHistoryDTO) {
		EventHistory eventHistory = null;
		if (eventHistoryDTO != null) {
			eventHistory = new EventHistory();
			eventHistory.setId(eventHistoryDTO.getId());
			eventHistory.setCategory(eventHistoryDTO.getCategory());
			eventHistory.setAgentName(eventHistoryDTO.getAgentName());
			eventHistory.setAgentSurname(eventHistoryDTO.getAgentSurname());
			eventHistory.setCompany(eventHistoryDTO.getCompany());
			eventHistory.setResult(eventHistoryDTO.getResult());
			if (eventHistoryDTO.getUserDTO() != null) {
				eventHistory.setUser(userConverter.toEntity(eventHistoryDTO.getUserDTO()));
			}
		}
		return eventHistory;
	}

	@Override
	public EventHistoryDTO toDTO(EventHistory eventHistory) {
		EventHistoryDTO eventHistoryDTO = null;
		if (eventHistory != null) {
			eventHistoryDTO = new EventHistoryDTO();
			eventHistoryDTO.setId(eventHistory.getId());
			eventHistoryDTO.setCategory(eventHistory.getCategory());
			eventHistoryDTO.setAgentName(eventHistory.getAgentName());
			eventHistoryDTO.setAgentSurname(eventHistory.getAgentSurname());
			eventHistoryDTO.setCompany(eventHistory.getCompany());
			eventHistoryDTO.setResult(eventHistory.getResult());
			if (eventHistory.getUser() != null) {
				eventHistoryDTO.setUserDTO(userConverter.toDTO(eventHistory.getUser()));
				}
		}
		return eventHistoryDTO;
	}
	
}
