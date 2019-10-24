package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;

@Repository
// Transactionl è la connessione Singleton al database
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);

}
