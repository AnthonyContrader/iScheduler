package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Sector;

@Repository
@Transactional

public interface SectorRepository extends CrudRepository<Sector,Long> {

}
