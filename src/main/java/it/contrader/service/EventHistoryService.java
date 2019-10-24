package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.dao.EventHistoryRepository;
import it.contrader.dto.EventHistoryDTO;
import it.contrader.model.EventHistory;

@Service
public class EventHistoryService extends AbstractService<EventHistory, EventHistoryDTO>{
	@Autowired
	private EventHistoryRepository repository;
	
	
	public List<EventHistoryDTO> findAllByUser_id(long id){
		return converter.toDTOList(repository.findAllByUser_id(id));
	}
}
