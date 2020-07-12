package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.controller.command.Command;

public class GoToBasketCommand implements Command {

	private static final String USER_BASKET_PAGE = "jsp/userBasket.jsp";
	private static final String REDIRECT_ERROR_PAGE = "Controller?command=go_to_error_page";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(USER_BASKET_PAGE);
		if (dispatcher == null) {
			response.sendRedirect(REDIRECT_ERROR_PAGE);
		} else {
			dispatcher.forward(request, response);
		}
	}
}
