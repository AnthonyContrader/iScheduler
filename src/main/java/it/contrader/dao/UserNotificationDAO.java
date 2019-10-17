package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import it.contrader.model.UserNotification;
import it.contrader.utils.ConnectionSingleton;

public class UserNotificationDAO implements DAO<UserNotification> {
	
	private final String QUERY_ALL = "SELECT * FROM usernotification";
	private final String QUERY_CREATE = "INSERT INTO usernotification (idUser, idNotification) VALUES (?,?)";
	private final String QUERY_READ = "SELECT * FROM usernotification WHERE id=?";
	private final String QUERY_UPDATE = "UPDATE usernotification SET idUser=?, idNotification=? WHERE id=?";
	private final String QUERY_DELETE = "DELETE FROM usernotification WHERE id=?";

	@Override
	public List<UserNotification> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserNotification> getAllById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserNotification> getAllByUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserNotification read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(UserNotification dto) {
		Connection connection = ConnectionSingleton.getInstance();
		try {	
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setInt(1, dto.getIdUser());
			preparedStatement.setInt(2, dto.getIdNotifica());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(UserNotification dto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
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
