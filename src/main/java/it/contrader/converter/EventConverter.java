package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.EventDTO;
import it.contrader.model.Event;

public class EventConverter implements Converter<Event,EventDTO> {

	public EventDTO toDTO(Event event) {
		EventDTO eventDTO = new EventDTO(event.getId(),event.getIdUser(), event.getPosizioneX(), event.getPosizioneY(),
				event.getScadenza(), event.getNome(), event.getDescrizione(), event.getCategoria());
		return eventDTO;

	}

	public Event toEntity(EventDTO eventDTO) {
		Event event = new Event(eventDTO.getId(),eventDTO.getIdUser(), eventDTO.getPosizioneX(), eventDTO.getPosizioneY(),
				eventDTO.getScadenza(), eventDTO.getNome(), eventDTO.getDescrizione(), eventDTO.getCategoria());
		return event;

	}

	public List<EventDTO> toDTOList(List<Event> eventList) {
		// Crea una lista vuota.
		List<EventDTO> eventDTOList = new ArrayList<EventDTO>();

		// Cicla tutti gli elementi della lista e li converte uno a uno
		for (Event event : eventList) {
			// Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			// e lo aggiunge adda lista di DTO
			eventDTOList.add(toDTO(event));
		}
		return eventDTOList;
	}

}