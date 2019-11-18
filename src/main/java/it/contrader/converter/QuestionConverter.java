package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.QuestionDTO;
import it.contrader.model.Question;

@Component
public class QuestionConverter extends AbstractConverter<Question, QuestionDTO> {
	public QuestionDTO toDTO (Question question) {
		QuestionDTO questionDTO=null;
		if(question!=null ) {
			questionDTO= new QuestionDTO (question.getId(), question.getQuestion(), question.getTopic(), question.getSector(), question.getRecruiter(), question.getCompany());
		}
		return questionDTO;
	}
	
	public Question toEntity (QuestionDTO questionDTO) {
		Question question=null;
		if(questionDTO!=null) {
			return new Question (questionDTO.getId(), questionDTO.getQuestion(), questionDTO.getTopic(), questionDTO.getSector(), questionDTO.getRecruiter(), questionDTO.getCompany());
		}
		return question;
	}
}
