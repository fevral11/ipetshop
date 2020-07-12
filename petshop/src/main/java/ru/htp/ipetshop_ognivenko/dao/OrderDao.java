package ru.htp.ipetshop_ognivenko.dao;

import java.util.List;

import ru.htp.ipetshop_ognivenko.bean.Delivery;
import ru.htp.ipetshop_ognivenko.bean.Goods;

public interface OrderDao {

	void addGoodsToOrder(Integer goodsId, Integer orderId, Integer quantityGoods) throws DaoException; // �������� ����� � �������

	Integer createOrder(Integer userId) throws DaoException;// ������� �����

	List<Goods> placeOrder(Integer orderId) throws DaoException;// ������� � ���������� ������

	boolean addDelivery(Integer idOrder, Delivery delivery) throws DaoException;// �������� �������� � ������

	boolean confirmOrder(OrderDao order) throws DaoException;// �������� ������ ������ �� �����������

	boolean paymentOrder(OrderDao order) throws DaoException;// ������ ������ � ��������� ������� �� �������

	boolean deliveryOrder(OrderDao order) throws DaoException;// �������� ������ � ��������� ������� �� ���������

}
