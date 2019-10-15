package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.contrader.model.UserNotification;
import it.contrader.utils.ConnectionSingleton;

public class UserNotificationDAO implements DAO<UserNotification>{

	private final String QUERY_ALL = "SELECT * FROM usernotification";
	private final String QUERY_JOIN = "SELECT * FROM usernotification un INNER JOIN notifica n ON un.idNotification=n.id AND un.idUser=? ";
	private final String QUERY_CREATE = "INSERT INTO usernotification (id, idUser, idNotification) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM usernotification WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE usernotification SET idUser=?, idNotification=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM usernotification WHERE id=?";

	public UserNotificationDAO() {

	}
	
	public List<UserNotification> getAll(){
		return null;
	}

	public List<UserNotification> getAll(int userId) {
		List<UserNotification> userNotificationList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_JOIN);
			preparedStatement.setInt(1,userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			UserNotification userNotification;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int idUser = resultSet.getInt("idUser");
				int idNotification = resultSet.getInt("idNotification");
				userNotification = new UserNotification(id, idUser, idNotification);
				userNotificationList.add(userNotification);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userNotificationList;
	}
	
	public List<UserNotification> getAllById(int id){
		return null;
		//DA IMPLEMENTARE SE SERVE.
	}

	public boolean insert(UserNotification userNotificationToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, userNotificationToInsert.getId());
			preparedStatement.setInt(2, userNotificationToInsert.getIdUser());
			preparedStatement.setInt(3, userNotificationToInsert.getIdNotification());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public UserNotification read(int userNotificationId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userNotificationId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			int id, idUser, idNotification;

			id = resultSet.getInt("id");
			idUser = resultSet.getInt("idUser");
			idNotification = resultSet.getInt("idNotification");
			UserNotification userNotification = new UserNotification(id, idUser, idNotification);
			userNotification.setId(resultSet.getInt("id"));

			return userNotification;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(UserNotification userNotificationToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userNotificationToUpdate.getId() == 0)
			return false;

		UserNotification userNotificationRead = read(userNotificationToUpdate.getId());
		if (!userNotificationRead.equals(userNotificationToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userNotificationToUpdate.getId() == 0 ) {
					userNotificationToUpdate.setId(userNotificationRead.getId());
				}

				if (userNotificationToUpdate.getIdUser() == 0) {
					userNotificationToUpdate.setIdUser(userNotificationRead.getIdUser());
				}

				if (userNotificationToUpdate.getIdNotification() == 0 ) {
					userNotificationToUpdate.setIdNotification(userNotificationRead.getIdNotification());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, userNotificationToUpdate.getId());
				preparedStatement.setInt(2, userNotificationToUpdate.getIdUser());
				preparedStatement.setInt(3, userNotificationToUpdate.getIdNotification());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
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
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
