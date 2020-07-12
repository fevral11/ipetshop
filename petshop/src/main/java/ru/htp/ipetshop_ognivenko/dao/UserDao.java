package ru.htp.ipetshop_ognivenko.dao;

import ru.htp.ipetshop_ognivenko.bean.User;
import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;

public interface UserDao {

	UserRegistrationData authorization(String login, String password) throws DaoException;// �����������

	boolean deleteUser(User user) throws DaoException;// �������� ������ ������������ �� ������

	boolean checkLoginUsed(String login) throws DaoException;// �������� ���������� �� ����� ����� ���

	boolean changeDataUser(User user, String newData) throws DaoException;// �������� ������ � �����

	UserRegistrationData registration(User newUser, String login, String password) throws DaoException;// ����������� ������������

	boolean changePassword(User user, String password) throws DaoException;// ��������� ������

}
