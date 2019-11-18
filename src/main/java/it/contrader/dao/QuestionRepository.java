package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.contrader.model.Question;

@Repository
@Transactional
public interface QuestionRepository extends CrudRepository<Question, Long>{
}
