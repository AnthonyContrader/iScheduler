package it.contrader.service;

import it.contrader.converter.NotificaConverter;
import it.contrader.dao.NotificaDAO;
import it.contrader.dto.NotificaDTO;
import it.contrader.model.Notifica;


public class NotificaService extends AbstractService<Notifica, NotificaDTO> {
//istanziare DAO e converter specifici
	public NotificaService() {
		this.dao =  new NotificaDAO();
		this.converter = new NotificaConverter();
	}
}
