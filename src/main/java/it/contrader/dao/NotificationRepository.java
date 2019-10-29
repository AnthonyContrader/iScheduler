package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Event;
import it.contrader.model.Notification;
import java.util.List;

@Repository
@Transactional
public interface NotificationRepository extends CrudRepository<Notification, Long> {

	public List<Notification> findNotificationByEvent(Event event);  
	public List<Notification> findByEvent_id(long id);

}