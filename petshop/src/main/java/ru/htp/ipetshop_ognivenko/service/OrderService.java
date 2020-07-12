package ru.htp.ipetshop_ognivenko.service;

import java.util.List;

import ru.htp.ipetshop_ognivenko.bean.Goods;

public interface OrderService {

	Integer createOrder(Integer userId) throws ServiceException;

	void addGoodsToOrder(Integer goodsId, Integer orderId, Integer quantityGoods) throws ServiceException;

	List <Goods> placeOrder(Integer orderId) throws ServiceException;

}
