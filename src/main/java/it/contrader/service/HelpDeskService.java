package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.HelpDeskConverter;
import it.contrader.converter.UserConverter;
import it.contrader.dao.HelpDeskRepository;
import it.contrader.dto.HelpDeskDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.HelpDesk;
@Service
public class HelpDeskService extends AbstractService<HelpDesk,HelpDeskDTO>{

	@Autowired
	private UserConverter userConverter;
	@Autowired
	private HelpDeskConverter hdConverter;
	@Autowired
	private HelpDeskRepository hdRepository;
	
	public List<HelpDeskDTO> getByUser_id(long id){
		return hdConverter.toDTOList(hdRepository.findByUser_id(id));
		
	}
	
	public List<HelpDeskDTO> getAllByUser(UserDTO userDTO){
		return hdConverter.toDTOList(hdRepository.findAllByUser(userConverter.toEntity(userDTO)));
	}
}
