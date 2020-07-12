package ru.htp.ipetshop_ognivenko.dao;

import java.util.List;

import ru.htp.ipetshop_ognivenko.bean.Delivery;
import ru.htp.ipetshop_ognivenko.bean.Goods;

public interface OrderDao {

	void addGoodsToOrder(Integer goodsId, Integer orderId, Integer quantityGoods) throws DaoException; // добавить товар в корзину

	Integer createOrder(Integer userId) throws DaoException;// создать заказ

	List<Goods> placeOrder(Integer orderId) throws DaoException;// перейти к оформлению заказа

	boolean addDelivery(Integer idOrder, Delivery delivery) throws DaoException;// добавить доставку к заказу

	boolean confirmOrder(OrderDao order) throws DaoException;// изменить статус заказа на сформирован

	boolean paymentOrder(OrderDao order) throws DaoException;// оплата заказа и изменение статуса на оплачен

	boolean deliveryOrder(OrderDao order) throws DaoException;// доставка товара и изменение статуса на доставлен

}
