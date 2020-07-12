package ru.htp.ipetshop_ognivenko.service.impl;

import java.util.ArrayList;
import java.util.List;

import ru.htp.ipetshop_ognivenko.bean.Goods;
import ru.htp.ipetshop_ognivenko.dao.DaoException;
import ru.htp.ipetshop_ognivenko.dao.DaoProvider;
import ru.htp.ipetshop_ognivenko.dao.OrderDao;
import ru.htp.ipetshop_ognivenko.service.OrderService;
import ru.htp.ipetshop_ognivenko.service.ServiceException;

public class OrderServiceImpl implements OrderService {

	@Override
	public Integer createOrder(Integer userId) throws ServiceException {

		Integer orderId;

		DaoProvider daoProvider = DaoProvider.getInstance();
		OrderDao orderDao = daoProvider.getOrderDao();

		try {
			orderId = orderDao.createOrder(userId);
			return orderId;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addGoodsToOrder(Integer goodsId, Integer orderId, Integer quantityGoods) throws ServiceException {

		DaoProvider daoProvider = DaoProvider.getInstance();
		OrderDao orderDao = daoProvider.getOrderDao();

		try {
			orderDao.addGoodsToOrder(goodsId, orderId, quantityGoods);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List <Goods> placeOrder(Integer orderId) throws ServiceException {
		
		List<Goods> userBasket=new ArrayList<Goods>();

		DaoProvider daoProvider = DaoProvider.getInstance();
		OrderDao orderDao = daoProvider.getOrderDao();

		try {
			userBasket=orderDao.placeOrder(orderId);
			return userBasket;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

}
