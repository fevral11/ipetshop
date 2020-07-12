package ru.htp.ipetshop_ognivenko.service.impl;

import ru.htp.ipetshop_ognivenko.bean.User;
import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;
import ru.htp.ipetshop_ognivenko.dao.DaoException;
import ru.htp.ipetshop_ognivenko.dao.DaoProvider;
import ru.htp.ipetshop_ognivenko.dao.UserDao;
import ru.htp.ipetshop_ognivenko.service.ServiceException;
import ru.htp.ipetshop_ognivenko.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public UserRegistrationData authorization(String login, String password) throws ServiceException {

		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			throw new ServiceException("Invalid data was transmitted");
		}

		UserRegistrationData userData;

		DaoProvider daoProvider = DaoProvider.getInstance();
		UserDao userDao = daoProvider.getUserDao();

		try {
			userData = userDao.authorization(login, password);
			return userData;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public UserRegistrationData registration(User newUser, String login, String password) throws ServiceException {

		boolean isLoginUsed;
		UserRegistrationData userData;

		isLoginUsed = true;
		userData = new UserRegistrationData();

		DaoProvider daoProvider = DaoProvider.getInstance();
		UserDao userDao = daoProvider.getUserDao();

		if (login == null || password == null || login.isEmpty() || password.isEmpty()) {
			throw new ServiceException("Invalid data was transmitted");
		}

		try {
			isLoginUsed = userDao.checkLoginUsed(login);
			if (!isLoginUsed) {
				userData = userDao.registration(newUser, login, password);
			}
			return userData;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}
