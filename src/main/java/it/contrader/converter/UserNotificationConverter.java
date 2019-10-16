package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.UserNotificationDTO;
import it.contrader.model.UserNotification;

public class UserNotificationConverter implements Converter<UserNotification, UserNotificationDTO>  {
	
	public UserNotificationDTO toDTO(UserNotification userNotification) {
		UserNotificationDTO userNotificationDTO = new UserNotificationDTO(userNotification.getId(), userNotification.getNome(), userNotification.getNotifica_tempo(), userNotification.isNotificato());
		return userNotificationDTO;
		}
	
	
	public UserNotification toEntity(UserNotificationDTO userNotificationDTO) {
		UserNotification userNotification = new UserNotification(userNotificationDTO.getId(), userNotificationDTO.getNome(), userNotificationDTO.getNotifica_tempo(), userNotificationDTO.isNotificato());
		return userNotification;
	}
	
	
	public List<UserNotificationDTO> toDTOList(List<UserNotification> userNotificationList) {
		//Crea una lista vuota.
		List<UserNotificationDTO> userNotificationDTOList = new ArrayList<UserNotificationDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(UserNotification userNotification : userNotificationList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			userNotificationDTOList.add(toDTO(userNotification));
		}
		return userNotificationDTOList;
	}

}
