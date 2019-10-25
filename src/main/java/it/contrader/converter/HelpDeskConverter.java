package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.HelpDeskDTO;
import it.contrader.model.HelpDesk;

@Component
public class HelpDeskConverter extends AbstractConverter<HelpDesk, HelpDeskDTO> {

	@Autowired
	UserConverter userConverter;
	
	@Override
	public HelpDesk toEntity(HelpDeskDTO hdDTO) {
		HelpDesk hd = null;
		if(hdDTO != null) {
			hd = new HelpDesk();
			hd.setId(hdDTO.getId());
			hd.setTitle(hdDTO.getTitle());
			hd.setReply(hdDTO.getReply());
			if(hdDTO.getChatDTO() != null) {
				hd.setChat(hdDTO.getChatDTO());
			}
			if(hdDTO.getUserDTO()!= null) {
				hd.setUser(userConverter.toEntity(hdDTO.getUserDTO()));
			}
			hd.setGestor(hdDTO.getGestorDTO());
		}
		return hd;
	}

	@Override
	public HelpDeskDTO toDTO(HelpDesk hd) {
		HelpDeskDTO hdDTO = null;
		if(hd != null) {
			hdDTO = new HelpDeskDTO();
			hdDTO.setId(hd.getId());
			hdDTO.setTitle(hd.getTitle());
			hdDTO.setReply(hd.getReply());
			if(hd.getChat() != null) {
				hdDTO.setChatDTO(hd.getChat());
			}
			if(hd.getUser()!= null) {
				hdDTO.setUserDTO(userConverter.toDTO(hd.getUser()));
			}
				hdDTO.setGestorDTO(hd.getGestor());
		}
		return hdDTO;
	}
	
	
	
	
}
