package it.contrader.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Company;
import it.contrader.model.Question;

@Repository
@Transactional
public interface QuestionRepository extends CrudRepository<Question, Long>{
	
	List<Question> findAllByCompany (Company company);
}

