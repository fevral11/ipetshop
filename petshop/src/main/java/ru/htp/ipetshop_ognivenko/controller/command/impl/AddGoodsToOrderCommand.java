package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.bean.UserRegistrationData;
import ru.htp.ipetshop_ognivenko.controller.command.Command;
import ru.htp.ipetshop_ognivenko.service.OrderService;
import ru.htp.ipetshop_ognivenko.service.ServiceException;
import ru.htp.ipetshop_ognivenko.service.ServiceProvider;

public class AddGoodsToOrderCommand implements Command {

	private static final String ID_ORDER_SESSION_ATRIBUTE = "orderId";
	private static final String ID_GOODS_REQUEST_PARAMETER = "goodsId";
	private static final String QUANTITY_GOODS_REQUEST_PARAMETER = "quantityGoods";
	private static final String REDIRECT_MAIN_PAGE = "Controller?command=go_to_main_page";
	private static final String REDIRECT_ERROR_PAGE = "Controller?command=go_to_error_page";
	private static final String MESSAGE_NO_REGISTRATION = "&message=user_no_signin";
	private static final String USER_SESSION_ATTRIBUTE = "userData";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer userId;
		Integer orderId;
		Integer goodsId;
		Integer quantityGoods;

		UserRegistrationData userData;

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		OrderService orderService = serviceProvider.getOrderService();

		userData = (UserRegistrationData) request.getSession(true).getAttribute(USER_SESSION_ATTRIBUTE);

		goodsId = Integer.parseInt(request.getParameter(ID_GOODS_REQUEST_PARAMETER));
		orderId = (Integer) request.getSession(true).getAttribute(ID_ORDER_SESSION_ATRIBUTE);
		quantityGoods = Integer.parseInt(request.getParameter(QUANTITY_GOODS_REQUEST_PARAMETER));
		userId = userData.getUserId();

		try {
			if (userId == null) {
				response.sendRedirect(REDIRECT_MAIN_PAGE + MESSAGE_NO_REGISTRATION);
			} else {
				if (orderId == null) {
					orderId = orderService.createOrder(userId);
					orderService.addGoodsToOrder(goodsId, orderId, quantityGoods);

					request.getSession().setAttribute(ID_ORDER_SESSION_ATRIBUTE, orderId);
					response.sendRedirect(REDIRECT_MAIN_PAGE);
				} else {
					orderService.addGoodsToOrder(goodsId, orderId, quantityGoods);
					response.sendRedirect(REDIRECT_MAIN_PAGE);
				}
			}
		} catch (ServiceException e) {
			response.sendRedirect(REDIRECT_ERROR_PAGE);
		}
	}
}
