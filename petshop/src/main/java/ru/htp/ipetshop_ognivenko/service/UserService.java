package ru.htp.ipetshop_ognivenko.service;

import ru.htp.ipetshop_ognivenko.bean.User;
import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;

public interface UserService {

	UserRegistrationData authorization(String login, String password) throws ServiceException;//�����������

	UserRegistrationData registration(User newUser, String login, String password) throws ServiceException;//�����������
}
