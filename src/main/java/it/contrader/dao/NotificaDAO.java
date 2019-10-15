package it.contrader.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Event;
import it.contrader.model.Notifica;

//Qui ci scrivi cosa deve uscire scritto in MySQL
public class NotificaDAO implements DAO<Notifica>{
	
private final String QUERY_ALL = "select * from notifica";
private final String QUERY_CREATE = "insert into notifica(id_event,notificato,notifica_tempo) values (?,?,?)";
private final String QUERY_READ = "select * from notifica where id=?";
private final String QUERY_READEVENT = "select * from notifica where id_event=?";
private final String QUERY_UPDATE = "update notifica set id_event=?, notificato=?,notifica_tempo=? where id=? ";
private final String QUERY_DELETE = "Delete from notifica where id=?";

public NotificaDAO() {
	}

public List<Notifica> getAll() {
	List<Notifica> notificheList = new ArrayList<>();
	Connection connection = ConnectionSingleton.getInstance();
	try {
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(QUERY_ALL);
		Notifica notifica;
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			int id_event = resultSet.getInt("id_event");
			boolean notificato = resultSet.getBoolean("notificato");
			String notifica_tempo = resultSet.getString("notifica_tempo");
			notifica = new Notifica(id_event, notificato, notifica_tempo);
			notifica.setId(id);
			notificheList.add(notifica);
	}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	return notificheList;
}

public List<Notifica> getAllById(int id_event){
	List<Notifica> notificaList = new ArrayList<>();
	Connection connection = ConnectionSingleton.getInstance(); //Crea un unica connessione (Singleton ) affinche altri non possano modificare l'oggetto. Mutua Esclusione.
	try {
		PreparedStatement prepareStatement = connection.prepareStatement(QUERY_READEVENT);
		prepareStatement.setInt(1,id_event);
		
		ResultSet resultSet = prepareStatement.executeQuery();
		Notifica notifica;
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			id_event = resultSet.getInt("id_event");
			Boolean notificato = resultSet.getBoolean("notificato");
			String notifica_tempo = resultSet.getString("notifica_tempo");
			notifica = new Notifica(id_event, notificato, notifica_tempo);
			notifica.setId(id);
			notificaList.add(notifica);
		}
		
	}catch(SQLException ex) {
		ex.printStackTrace();
	}
	return notificaList;
}

public boolean insert(Notifica notificaToInsert) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
		preparedStatement.setInt(1,notificaToInsert.getId_event());
		preparedStatement.setBoolean(2,notificaToInsert.getNotificato());
		preparedStatement.setString(3, notificaToInsert.getNotifica_tempo());
		preparedStatement.execute();
		return true;
	} catch (SQLException e) {
		return false;
	}
	
}

public Notifica read(int notificaId) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
		preparedStatement.setInt(1, notificaId);
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		int id_event;
		boolean notificato;
		String notifica_tempo;
		id_event = resultSet.getInt("id_event");
		notificato = resultSet.getBoolean("notificato");
		notifica_tempo = resultSet.getString("notifica_tempo");
		Notifica notifica = new Notifica(id_event, notificato, notifica_tempo);
		notifica.setId(resultSet.getInt("id"));
		return notifica;
	} catch (SQLException e) {
		return null;
	}
	}
	

public boolean update(Notifica notificaToUpdate) {
Connection connection = ConnectionSingleton.getInstance();
//vediamo se è presente un id
	if(notificaToUpdate.getId() == 0)
	return false;
	
	Notifica notificaRead = read(notificaToUpdate.getId());
	if(!notificaRead.equals(notificaToUpdate)) {
		try {
			if (notificaToUpdate.getId_event() == 0) {
				notificaToUpdate.setId_event(notificaRead.getId_event());
			}
		
		
			if(notificaToUpdate.getNotifica_tempo() == null || notificaToUpdate.getNotifica_tempo().contentEquals("")) {
				notificaToUpdate.setNotifica_tempo(notificaRead.getNotifica_tempo());
			}
//aggiorno la notifica
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1,notificaToUpdate.getId_event());
			preparedStatement.setBoolean(2, notificaToUpdate.getNotificato());
			preparedStatement.setString(3, notificaToUpdate.getNotifica_tempo());
			preparedStatement.setInt(4, notificaToUpdate.getId());
			int a = preparedStatement.executeUpdate();
			if(a > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			return false;
		}
	}
	return false;

}

public boolean delete(int id) {
	Connection connection = ConnectionSingleton.getInstance();
	try {
		PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
		preparedStatement.setInt(1, id);
		int n = preparedStatement.executeUpdate();
		if(n != 0)
			return true;
	} catch (SQLException e) {
		return false;
	}
return false;
}



}


