package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.bean.Goods;
import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;
import ru.htp.ipetshop_ognivenko.controller.command.Command;
import ru.htp.ipetshop_ognivenko.service.OrderService;
import ru.htp.ipetshop_ognivenko.service.ServiceException;
import ru.htp.ipetshop_ognivenko.service.ServiceProvider;

public class PlaceOrderCommand implements Command {

	private static final String LIST_GOODS_IN_ORDER_REQUEST_PARAMETER = "userBasket";
	private static final String ID_ORDER_SESSION_ATTRIBUTE = "orderId";
	private static final String USER_BASKET_PAGE = "jsp/userBasket.jsp";
	private static final String USER_SESSION_ATTRIBUTE = "userData";
	private static final String REDIRECT_ERROR_PAGE = "Controller?command=go_to_error_page";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Goods> userBasket;
		Integer orderId;
		UserRegistrationData userData;
		Integer userId;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		OrderService orderService = serviceProvider.getOrderService();

		orderId = (Integer) request.getSession(true).getAttribute(ID_ORDER_SESSION_ATTRIBUTE);
		userData = (UserRegistrationData) request.getSession(true).getAttribute(USER_SESSION_ATTRIBUTE);
		userId = userData.getUserId();
		userBasket = new ArrayList<Goods>();

		try {
			RequestDispatcher dispatcher = request.getRequestDispatcher(USER_BASKET_PAGE);
			if (orderId == null) {
				orderId = orderService.createOrder(userId);
			} else {
				userBasket = orderService.placeOrder(orderId);

				request.setAttribute(LIST_GOODS_IN_ORDER_REQUEST_PARAMETER, userBasket);
			}
			dispatcher.forward(request, response);
		} catch (

		ServiceException e) {
			response.sendRedirect(REDIRECT_ERROR_PAGE);
		}
	}
}
