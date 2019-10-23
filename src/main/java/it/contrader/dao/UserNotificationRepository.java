package it.contrader.dao;
import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.UserNotification;

@Repository
@Transactional
public interface UserNotificationRepository extends CrudRepository<UserNotification,Long>{

}
