package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.controller.command.Command;

public class ExitCommand implements Command {

	private static final String REDIRECT_MAIN_PAGE = "Controller?command=go_to_main_page";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession(true).invalidate();
		response.sendRedirect(REDIRECT_MAIN_PAGE);
	}
}
