package it.contrader.service;

import java.util.List;
import it.contrader.converter.NotificaConverter;
import it.contrader.dao.NotificaDAO;
import it.contrader.dto.NotificaDTO;


public class NotificaService {

	private NotificaDAO notificaDAO;
	private NotificaConverter notificaConverter;
	
	//istanzio DAO e Converter specifici
	
	public NotificaService () { 
		this.notificaDAO = new NotificaDAO();
		this.notificaConverter = new NotificaConverter();
	}

	public List<NotificaDTO> getAll() { 
		//prendo una lista di entità e la converto restituendola in DTO
		return notificaConverter.toDTOList(notificaDAO.getAll());
	}
	
	public NotificaDTO read(int id) {
		return notificaConverter.toDTO(notificaDAO.read(id));
	}
	
	public boolean insert(NotificaDTO dto) {
		return notificaDAO.insert(notificaConverter.toEntity(dto));
	}
	
	public boolean update(NotificaDTO dto) {
		return notificaDAO.update(notificaConverter.toEntity(dto));
		
	}
	
	public boolean delete(int id) {
		return notificaDAO.delete(id);
	}
	
}
