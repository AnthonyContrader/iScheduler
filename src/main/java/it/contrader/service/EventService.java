package it.contrader.service;


import java.util.List;

import it.contrader.converter.EventConverter;
import it.contrader.dao.EventDAO;
import it.contrader.dto.EventDTO;
import it.contrader.model.Event;

public class EventService extends AbstractService<Event, EventDTO> {
	
	public EventService() {
		this.dao = new EventDAO();
		this.converter = new EventConverter();
	}

	

}
