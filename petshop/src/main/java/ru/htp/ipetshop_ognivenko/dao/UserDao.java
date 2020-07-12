package ru.htp.ipetshop_ognivenko.dao;

import ru.htp.ipetshop_ognivenko.bean.User;
import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;

public interface UserDao {

	UserRegistrationData authorization(String login, String password) throws DaoException;// регистрация

	boolean deleteUser(User user) throws DaoException;// изменить статус пользователя на удален

	boolean checkLoginUsed(String login) throws DaoException;// проверка существует ли такой логин уже

	boolean changeDataUser(User user, String newData) throws DaoException;// изменить данные о юзере

	UserRegistrationData registration(User newUser, String login, String password) throws DaoException;// регистрация пользователя

	boolean changePassword(User user, String password) throws DaoException;// изменение пароля

}
