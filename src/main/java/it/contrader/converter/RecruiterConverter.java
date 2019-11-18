package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.RecruiterDTO;
import it.contrader.model.Recruiter;

@Component
public class RecruiterConverter extends AbstractConverter<Recruiter,RecruiterDTO> {
	public Recruiter toEntity(RecruiterDTO recruiterDTO) {
		Recruiter recruiter = null;
		if (recruiterDTO != null) {
			recruiter = new Recruiter(recruiterDTO.getId(),recruiterDTO.getName(),recruiterDTO.getCompany());			
		}
		return recruiter;
	}
	public RecruiterDTO toDTO(Recruiter recruiter) {
		RecruiterDTO recruiterDTO = null;
		if (recruiter != null) {
			recruiterDTO = new RecruiterDTO(recruiter.getId(),recruiter.getName(),recruiter.getCompany());
		}
		return recruiterDTO;
	}

}