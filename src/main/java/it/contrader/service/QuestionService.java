package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.CompanyConverter;
import it.contrader.converter.QuestionConverter;
import it.contrader.dao.QuestionRepository;
import it.contrader.dto.CompanyDTO;
import it.contrader.dto.QuestionDTO;
import it.contrader.model.Question;

@Service
public class QuestionService extends AbstractService<Question,QuestionDTO> {

	@Autowired
	private QuestionRepository repository;
	@Autowired
	private QuestionConverter qconverter;
	@Autowired
	private CompanyConverter compConverter;
	
	public List<QuestionDTO> getAllByCompany(CompanyDTO companyDTO){
		return qconverter.toDTOList(repository.findAllByCompany(compConverter.toEntity(companyDTO)));
	}
	
}