package it.contrader.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.HelpDesk;
import it.contrader.model.User;

public interface HelpDeskRepository  extends CrudRepository<HelpDesk,Long> {

	public List<HelpDesk> findByUser_id(long id);
	public List<HelpDesk> findAllByUser(User user);
	
}
