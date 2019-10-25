package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.EventConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.EventRepository;
import it.contrader.dto.EventDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Event;
import it.contrader.model.User;

@Service
public class EventService extends AbstractService<Event,EventDTO> {
	@Autowired
	private EventConverter eventConverter;
	@Autowired
	private EventRepository repository;
	@Autowired
	private UserConverter userConverter;
	
	public  List<EventDTO> getByUser_id(long id){
		return eventConverter.toDTOList(repository.findByUser_id(id));
	}
	
	public List<EventDTO> getAllByUser(UserDTO userDTO){
		return eventConverter.toDTOList(repository.findAllByUser(userConverter.toEntity(userDTO)));
	}

}
