package it.contrader.service;

import java.util.List;

import it.contrader.converter.EventConverter;
import it.contrader.dao.EventDAO;
import it.contrader.dto.EventDTO;

public class EventService {
	private EventDAO eventDAO;
	private EventConverter eventConverter;
	
	public EventService() {
		this.eventDAO = new EventDAO();
		this.eventConverter = new EventConverter();
	}
	
	public List<EventDTO> getAll(){
		return eventConverter.toDTOList(eventDAO.getAll());
	}
	
	public boolean insert(EventDTO eventDTO) {
		return eventDAO.insert(eventConverter.toEntity(eventDTO));
	}
	
	public EventDTO read(int id) {
		return eventConverter.toDTO(eventDAO.read(id));
	}
	
	public boolean update(EventDTO eventDTO) {
		return eventDAO.update(eventConverter.toEntity(eventDTO));
	}
	
	public boolean delete(int id) {
		return eventDAO.delete(id);
	}

}
