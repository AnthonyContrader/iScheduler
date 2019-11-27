package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.QuestionDTO;
import it.contrader.model.Question;

@Component
public class QuestionConverter extends AbstractConverter<Question, QuestionDTO> {
	
	@Autowired
	private RecruiterConverter rConverter;
	@Autowired
	private CompanyConverter cConverter;
	@Autowired
	private SectorConverter sConverter;
	
	
	public QuestionDTO toDTO (Question question) {
		QuestionDTO questionDTO=null;
		if(question!=null ) {
			questionDTO= new QuestionDTO (question.getId(), question.getQuestion(), question.getTopic(), rConverter.toDTO(question.getRecruiter()), cConverter.toDTO(question.getCompany()),sConverter.toDTO(question.getSector()));
		}
		return questionDTO;
	}
	
	public Question toEntity (QuestionDTO questionDTO) {
		Question question=null;
		if(questionDTO!=null) {
			question= new Question (questionDTO.getId(), questionDTO.getQuestion(), questionDTO.getTopic(), rConverter.toEntity(questionDTO.getRecruiterDTO()), cConverter.toEntity(questionDTO.getCompanyDTO()), sConverter.toEntity(questionDTO.getSectorDTO()));
		}
		return question;
	}
}
