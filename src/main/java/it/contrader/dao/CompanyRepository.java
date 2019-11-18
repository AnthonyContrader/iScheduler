package it.contrader.dao;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Company;

@Repository
@Transactional
public interface CompanyRepository extends CrudRepository<Company, Long>{
}
