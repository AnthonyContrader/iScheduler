package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Event;
import it.contrader.model.User;

@Repository
@Transactional
public interface EventRepository extends CrudRepository<Event,Long> {
	
	public List<Event> findByUser_id(long id);
	public List<Event> findAllByUser(User user);
	

}
