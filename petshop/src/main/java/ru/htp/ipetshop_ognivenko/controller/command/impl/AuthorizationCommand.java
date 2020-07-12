package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;
import ru.htp.ipetshop_ognivenko.controller.command.*;
import ru.htp.ipetshop_ognivenko.service.ServiceException;
import ru.htp.ipetshop_ognivenko.service.ServiceProvider;
import ru.htp.ipetshop_ognivenko.service.UserService;

public class AuthorizationCommand implements Command {

	private static final String REDIRECT_MAIN_PAGE = "Controller?command=go_to_main_page";
	private static final String REDIRECT_ERROR_PAGE = "Controller?command=go_to_error_page";
	private static final String USER_SESSION_ATTRIBUTE = "userData";
	private static final String LOGIN_PARAMETER_REQUEST = "login";
	private static final String PASSWORD_PARAMETER_REQUEST = "password";
	private static final String ID_ORDER_SESSION_ATTRIBUTE = "orderId";
	private static final String USER_NOT_FOUND = "uncorrect";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserRegistrationData userData = new UserRegistrationData();

		String login;
		String password;
		Integer orderId;
		Integer userId;

		login = request.getParameter(LOGIN_PARAMETER_REQUEST);
		password = request.getParameter(PASSWORD_PARAMETER_REQUEST);
		orderId = null;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		UserService userService = serviceProvider.getUserService();

		try {
			userData = userService.authorization(login, password);
			userId = userData.getUserId();

			if (userId == null) {
				userData.setUserName(USER_NOT_FOUND);
				request.getSession(true).setAttribute(USER_SESSION_ATTRIBUTE, userData);
				response.sendRedirect(REDIRECT_MAIN_PAGE);
			} else {
				request.getSession(true).setAttribute(USER_SESSION_ATTRIBUTE, userData);
				request.getSession(true).setAttribute(ID_ORDER_SESSION_ATTRIBUTE, orderId);
				response.sendRedirect(REDIRECT_MAIN_PAGE);
			}
		} catch (ServiceException e) {
			response.sendRedirect(REDIRECT_ERROR_PAGE);
		}
	}
}
