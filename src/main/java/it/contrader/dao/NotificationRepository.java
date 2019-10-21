package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Notification;

@Repository
@Transactional
public interface NotificationRepository extends CrudRepository<Notification, Long> {

	Notification findByDescriptionAndIdEvent(String description, int idEvent);

}