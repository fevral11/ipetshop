package ru.htp.ipetshop_ognivenko.service;

import ru.htp.ipetshop_ognivenko.service.impl.CriteriaGoodsServiceImpl;
import ru.htp.ipetshop_ognivenko.service.impl.OrderServiceImpl;
import ru.htp.ipetshop_ognivenko.service.impl.UserServiceImpl;

public class ServiceProvider {

	private final static ServiceProvider instance = new ServiceProvider();

	private UserService userService = new UserServiceImpl();
	private OrderService orderService = new OrderServiceImpl();
	private CriteriaService<Object> criteriaService = new CriteriaGoodsServiceImpl<Object>();

	private ServiceProvider() {
	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public CriteriaService<Object> getCriteriaService() {
		return criteriaService;
	}

}
