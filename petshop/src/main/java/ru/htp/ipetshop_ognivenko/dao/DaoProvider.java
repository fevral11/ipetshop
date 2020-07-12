package ru.htp.ipetshop_ognivenko.dao;

import ru.htp.ipetshop_ognivenko.dao.impl.CriteriaGoodsDaoImpl;
import ru.htp.ipetshop_ognivenko.dao.impl.GoodsDaoImpl;
import ru.htp.ipetshop_ognivenko.dao.impl.OrderDaoImpl;
import ru.htp.ipetshop_ognivenko.dao.impl.UserDaoImpl;

public class DaoProvider {

	private static final DaoProvider instance = new DaoProvider();
	private UserDao userDao = new UserDaoImpl();
	private GoodsDao goodDao = new GoodsDaoImpl();
	private OrderDao orderDao = new OrderDaoImpl();
	private CriteriaDao<Object> criteriaGoodsDao = new CriteriaGoodsDaoImpl<Object>();

	private DaoProvider() {
	}

	public static DaoProvider getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public GoodsDao getGoodsDao() {
		return goodDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public CriteriaDao<Object> geCriteriaDao() {
		return criteriaGoodsDao;
	}
}
