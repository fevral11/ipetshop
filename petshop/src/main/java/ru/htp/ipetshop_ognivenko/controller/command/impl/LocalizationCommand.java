package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.controller.command.Command;

public class LocalizationCommand implements Command {

	private static final String MAIN_PAGE = "index.jsp";
	private static final String LOCAL_PARAMETER_REQUEST = "local";
	private static final String LAST_REQUEST = "lastRequest";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String newLocal;
		String lastRequest;

		newLocal = request.getParameter(LOCAL_PARAMETER_REQUEST);
		lastRequest = (String) request.getSession().getAttribute(LAST_REQUEST);

		request.getSession().setAttribute(LOCAL_PARAMETER_REQUEST, newLocal);

		if (lastRequest == null) {
			response.sendRedirect(MAIN_PAGE);
		} else {
			response.sendRedirect(lastRequest);
		}
	}
}
