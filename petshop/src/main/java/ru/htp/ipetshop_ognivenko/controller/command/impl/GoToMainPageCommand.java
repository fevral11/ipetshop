package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.controller.command.Command;

public class GoToMainPageCommand implements Command {
	
	private static final String MAIN_PAGE = "index.jsp";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(MAIN_PAGE);
		dispatcher.forward(request, response);
	}
}
