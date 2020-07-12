package ru.htp.ipetshop_ognivenko.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.controller.command.Command;
import ru.htp.ipetshop_ognivenko.controller.command.CommandProvider;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final CommandProvider commandProvider = new CommandProvider();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Command command;
		String commandName;
		String responsePrevios;

		commandName = request.getParameter("command");

		command = commandProvider.getCommand(commandName.toUpperCase());
		command.execute(request, response);

		responsePrevios = request.getRequestURI() + "?" + request.getQueryString();
		request.getSession(true).setAttribute("lastRequest", responsePrevios);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Command command;
		String commandName;

		commandName = request.getParameter("command");
		command = commandProvider.getCommand(commandName.toUpperCase());

		command.execute(request, response);

	}
}
