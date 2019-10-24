package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.EventHistory;
import it.contrader.model.User;

@Repository
@Transactional
public interface EventHistoryRepository extends CrudRepository<EventHistory,Long>{
	public List<EventHistory> findAllByUser_id(long idUser);
}
 