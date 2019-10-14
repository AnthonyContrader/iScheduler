package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.NotificaDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Notifica;
import it.contrader.model.User;

public class NotificaConverter implements Converter<Notifica, NotificaDTO> {
	
	public NotificaDTO toDTO(Notifica notifica) {
		NotificaDTO notificaDTO = new NotificaDTO(notifica.getId(), notifica.getId_event(), notifica.getNotificato(), notifica.getNotifica_tempo());
		return notificaDTO;
	}

	public Notifica toEntity(NotificaDTO notificaDTO) {
		Notifica notifica = new Notifica(notificaDTO.getId(), notificaDTO.getId_event(), notificaDTO.getNotificato(), notificaDTO.getNotifica_tempo());
		return notifica;
	}
	
	public List<NotificaDTO> toDTOList(List<Notifica> notificaList){
		List<NotificaDTO> notificaDTOList = new ArrayList<NotificaDTO>();
		
		for(Notifica notifica : notificaList) {
			notificaDTOList.add(toDTO(notifica));
	}
		return notificaDTOList;
	}
	
}
