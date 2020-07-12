package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.bean.User;
import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;
import ru.htp.ipetshop_ognivenko.controller.command.Command;
import ru.htp.ipetshop_ognivenko.service.ServiceException;
import ru.htp.ipetshop_ognivenko.service.ServiceProvider;
import ru.htp.ipetshop_ognivenko.service.UserService;

public class RegistrationCommand implements Command {

	private static final String REDIRECT_MAIN_PAGE = "Controller?command=go_to_main_page";
	private static final String REDIRECT_ERROR_PAGE = "Controller?command=go_to_error_page";
	private static final String USER_SESSION_ATTRIBUTE = "userData";
	private static final String LOGIN_PARAMETER_REQUEST = "login";
	private static final String PASSWORD_PARAMETER_REQUEST = "password";
	private static final String NAME_PARAMETER_REQUEST = "name";
	private static final String SURNAME_PARAMETER_REQUEST = "surname";
	private static final String EMAIL_PARAMETER_REQUEST = "email";
	private static final String TELEPHONE_PARAMETER_REQUEST = "telephone";
	private static final String STATUS_USER_ACTIVE = "active";
	private static final String ROLE_USER = "userRole";
	private static final String ID_ORDER_SESSION_ATTRIBUTE = "orderId";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName;
		String userSurname;
		String userEmail;
		String userTelephone;
		String userLogin;
		String userPassword;
		String userRole;
		String userStatus;
		Integer orderId;

		userLogin = request.getParameter(LOGIN_PARAMETER_REQUEST);
		userPassword = request.getParameter(PASSWORD_PARAMETER_REQUEST);
		userName = request.getParameter(NAME_PARAMETER_REQUEST);
		userSurname = request.getParameter(SURNAME_PARAMETER_REQUEST);
		userEmail = request.getParameter(EMAIL_PARAMETER_REQUEST);
		userTelephone = request.getParameter(TELEPHONE_PARAMETER_REQUEST);
		userRole = ROLE_USER;
		userStatus = STATUS_USER_ACTIVE;
		orderId = null;

		User user = new User(userName, userSurname, userEmail, userTelephone, userStatus, userRole);

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		UserService userService = serviceProvider.getUserService();

		UserRegistrationData userData;

		try {
			
			userData = userService.registration(user, userLogin, userPassword);
			request.getSession(true).setAttribute(USER_SESSION_ATTRIBUTE, userData);
			request.getSession(true).setAttribute(ID_ORDER_SESSION_ATTRIBUTE, orderId);
			response.sendRedirect(REDIRECT_MAIN_PAGE);

		} catch (

		ServiceException e) {
			response.sendRedirect(REDIRECT_ERROR_PAGE);
		}
	}
}
