package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.NotificaDTO;
import it.contrader.model.Notifica;

public class NotificaConverter {
	public NotificaDTO toDTO(Notifica notifica) {
		NotificaDTO notificaDTO = new NotificaDTO(notifica.getId(), notifica.getId_event(), notifica.getNotificato(), notifica.getNotifica_tempo());
		return notificaDTO;
					
	}
	
public Notifica toEntity(NotificaDTO notificaDTO) {
		Notifica notifica = new Notifica(notificaDTO.getId(), notificaDTO.getId_event(), notificaDTO.getNotificato(), notificaDTO.getNotifica_tempo());
		return notifica;
	}

/**
 * Metodo per convertire le liste di Notifica.
 */
public List<NotificaDTO> toDTOList(List<Notifica> notificaList) {
	//Crea una lista vuota.
	List<NotificaDTO> notificaDTOList = new ArrayList<NotificaDTO>();
	
	//Cicla tutti gli elementi della lista e li converte uno a uno
	for(Notifica notifica : notificaList) {
		//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
		//e lo aggiunge adda lista di DTO
		notificaDTOList.add(toDTO(notifica));
	}
	return notificaDTOList;
}

}
