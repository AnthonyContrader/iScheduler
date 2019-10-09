package it.contrader.dao;

import java.sql.*;
import java.util.*;
import java.sql.Date;

import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Event;

public class EventDAO {

	private final String QUERY_ALL = "SELECT * FROM event";
	private final String QUERY_INSERT = "INSERT INTO event (nome, categoria, descrizione, posizione_X, posizione_Y, scadenza, idUser) VALUES"
										+ "(?,?,?,?,?,?,?)";
	private final String QUERY_READ = "SELECT * FROM event WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE event SET nome=?, categoria=?, descrizione=?, posizione_X=?, posizione_Y=?, scadenza=?, idUser=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM event WHERE id=?";
	
	public EventDAO() {
		
	}
	
	public List<Event> getAll(){
		List<Event> eventList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance(); //Crea un unica connessione (Singleton ) affinche altri non possano modificare l'oggetto. Mutua Esclusione.
		try {
			Statement statement = connection.createStatement(); //stat e la variabile per eseguire la query.
			ResultSet resultSet = statement.executeQuery(QUERY_ALL); //esecuzione query e ritorno valori
			Event event;
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int idUser = resultSet.getInt("idUser");
				String nome = resultSet.getString("nome");
				String descrizione = resultSet.getString("descrizione");
				String categoria = resultSet.getString("categoria");
				float posizioneX = resultSet.getFloat("posizione_X");
				float posizioneY = resultSet.getFloat("posizione_Y");
				Date scadenza = resultSet.getDate("scadenza");
				event = new Event(posizioneX, posizioneY, scadenza, nome, descrizione,categoria);
				event.setId(id);
				event.setIdUser(idUser);
				eventList.add(event);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return eventList;
	}
	
	public boolean insert(Event eventToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY_INSERT);
			prepareStatement.setString(1, eventToInsert.getNome());
			prepareStatement.setString(2, eventToInsert.getCategoria());
			prepareStatement.setString(3, eventToInsert.getDescrizione());
			prepareStatement.setFloat(4, eventToInsert.getPosizioneX());
			prepareStatement.setFloat(5, eventToInsert.getPosizioneY());
			prepareStatement.setDate(6, eventToInsert.getScadenza());
			prepareStatement.setInt(7, eventToInsert.getIdUser());
			prepareStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	public Event read(int eventId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY_READ);
			prepareStatement.setInt(1, eventId);
			ResultSet resultSet = prepareStatement.executeQuery();
			resultSet.next();
			int id = resultSet.getInt("id");
			int idUser = resultSet.getInt("idUser");
			String nome = resultSet.getString("nome");
			String descrizione = resultSet.getString("descrizione");
			String categoria = resultSet.getString("categoria");
			float posizioneX = resultSet.getFloat("posizione_X");
			float posizioneY = resultSet.getFloat("posizione_Y");
			Date scadenza = resultSet.getDate("scadenza");
			Event event = new Event(posizioneX, posizioneY, scadenza, nome, descrizione, categoria);
			event.setIdUser(idUser);
			event.setId(id);
			
			return event;
		} catch (SQLException e) {
			return null;
		}
	}


	public boolean update(Event eventToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if(eventToUpdate.getId() == 0) return false;
		Event eventRead = read(eventToUpdate.getId());
		if(!eventRead.equals(eventToUpdate)) {
			try {
				if(eventToUpdate.getNome() == null || eventToUpdate.getNome().equals("")) {
					eventToUpdate.setNome(eventRead.getNome());
				}
				if(eventToUpdate.getDescrizione() == null || eventToUpdate.getDescrizione().equals("")) {
					eventToUpdate.setDescrizione(eventRead.getDescrizione());
				}
				if(eventToUpdate.getCategoria() == null || eventToUpdate.getCategoria().equals("")) {
					eventToUpdate.setCategoria(eventRead.getCategoria());
				}
				if(eventToUpdate.getPosizioneX() == 0) {
					eventToUpdate.setPosizioneX(eventRead.getPosizioneX());
				}
				if(eventToUpdate.getPosizioneY() == 0) {
					eventToUpdate.setPosizioneY(eventRead.getPosizioneY());
				}
				if(eventToUpdate.getScadenza() == null) {
					eventToUpdate.setScadenza(eventRead.getScadenza());
				}
				if(eventToUpdate.getIdUser() == 0) {
					eventToUpdate.setIdUser(eventRead.getIdUser());
				}
				//Non verificato chiave esterna idUser.
				
				PreparedStatement prepareStatement = connection.prepareStatement(QUERY_UPDATE);
				prepareStatement.setString(1, eventToUpdate.getNome());
				prepareStatement.setString(2, eventToUpdate.getCategoria());
				prepareStatement.setString(3, eventToUpdate.getDescrizione());
				prepareStatement.setFloat(4, eventToUpdate.getPosizioneX());
				prepareStatement.setFloat(5, eventToUpdate.getPosizioneY());
				prepareStatement.setDate(6, eventToUpdate.getScadenza());
				prepareStatement.setInt(7, eventToUpdate.getIdUser());
				prepareStatement.setInt(8, eventToUpdate.getId());
				int check = prepareStatement.executeUpdate();
				if(check > 0) return true;
				else return false;
			} catch (SQLException e) {
				return false;
			}
		}
		return false;
	}
	
	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(QUERY_DELETE);
			prepareStatement.setInt(1, id);
			int n = prepareStatement.executeUpdate();
			if(n != 0) return true;
		} catch (SQLException e) {
			return false;
		}
		return false;
	}
}
