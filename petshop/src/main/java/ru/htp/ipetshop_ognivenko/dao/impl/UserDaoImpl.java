package ru.htp.ipetshop_ognivenko.dao.impl;

import java.sql.*;

import ru.htp.ipetshop_ognivenko.bean.User;
import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;
import ru.htp.ipetshop_ognivenko.dao.DaoException;
import ru.htp.ipetshop_ognivenko.dao.UserDao;
import ru.htp.ipetshop_ognivenko.dao.connection_pool.ConnectionPool;
import ru.htp.ipetshop_ognivenko.dao.connection_pool.ConnectionPoolException;

public class UserDaoImpl implements UserDao {

	private static final String SELECT_FROM_USER_QUERY = "SELECT * FROM ipetshop.users";
	private static final String REGISTRATION_QUERY = "INSERT INTO ipetshop.users "
			+ "(name, surname, email, telephone, login, password, status, role) " + "VALUES (?,?,?,?,?,?,?,?)";
	private static final String LOGIN_COLUMN = "login";
	private static final String PASSWORD_COLUMN = "password";
	private static final String ID_USER_COLUMN = "idusers";
	private static final String NAME_USER_COLUMN = "name";

	public UserRegistrationData authorization(String login, String password) throws DaoException {

		String userName = null;
		Integer userId = null;
		UserRegistrationData userData = new UserRegistrationData();

		Statement statement = null;
		ResultSet resultSet = null;

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;

		try {
			connection = connectionPool.takeConnection();

			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_FROM_USER_QUERY);

			while (resultSet.next()) {
				if (login.equals(resultSet.getString(LOGIN_COLUMN)) && password.equals(resultSet.getString(PASSWORD_COLUMN))) {

					userId = resultSet.getInt(ID_USER_COLUMN);
					userName = resultSet.getString(NAME_USER_COLUMN);

					userData.setUserId(userId);
					userData.setUserName(userName);
				}
			}
			return userData;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement, resultSet);
		}
	}

	@Override
	public UserRegistrationData registration(User newUser, String login, String password) throws DaoException {

		String userName;
		String userSurname;
		String userEmail;
		String userTelephone;
		String userStatus;
		String userRole;
		Integer userId;
		UserRegistrationData userData;

		userName = newUser.getName();
		userSurname = newUser.getSurname();
		userEmail = newUser.getEmail();
		userTelephone = newUser.getTelephone();
		userStatus = newUser.getStatusUser();
		userRole = newUser.getRole();

		userId = null;
		userData = new UserRegistrationData();

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = connectionPool.takeConnection();
			preparedStatement = connection.prepareStatement(REGISTRATION_QUERY, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, userSurname);
			preparedStatement.setString(3, userEmail);
			preparedStatement.setString(4, userTelephone);
			preparedStatement.setString(5, login);
			preparedStatement.setString(6, password);
			preparedStatement.setString(7, userStatus);
			preparedStatement.setString(8, userRole);

			if (preparedStatement.executeUpdate() == 0) {
				userData = null;
			} else {
				resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					userId = resultSet.getInt(1);

					userData.setUserId(userId);
					userData.setUserName(userName);
				}
			}
			return userData;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
	}

	@Override
	public boolean checkLoginUsed(String login) throws DaoException {

		boolean isLoginUsed;

		isLoginUsed = false;

		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();

			resultSet = statement.executeQuery(SELECT_FROM_USER_QUERY);

			while (resultSet.next()) {
				if (login.equals(resultSet.getString(LOGIN_COLUMN))) {
					isLoginUsed = true;
				}
			}
			return isLoginUsed;
		} catch (ConnectionPoolException | SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement, resultSet);
		}
	}

	@Override
	public boolean deleteUser(User user) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeDataUser(User user, String newData) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(User user, String password) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

}
