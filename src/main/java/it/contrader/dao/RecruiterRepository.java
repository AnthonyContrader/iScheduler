package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Recruiter;

@Repository
@Transactional
public interface RecruiterRepository extends CrudRepository<Recruiter, Long>{
	
}