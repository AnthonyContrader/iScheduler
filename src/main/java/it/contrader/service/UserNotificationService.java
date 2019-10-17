package it.contrader.service;

import it.contrader.converter.UserNotificationConverter;
import it.contrader.dao.UserNotificationDAO;
import it.contrader.dto.UserNotificationDTO;
import it.contrader.model.UserNotification;

public class UserNotificationService extends AbstractService<UserNotification, UserNotificationDTO>{
	
	//Istanzio DAO  e Converter specifici.
	public UserNotificationService(){
		this.dao = new UserNotificationDAO();
		this.converter = new UserNotificationConverter();
	}
	
}
