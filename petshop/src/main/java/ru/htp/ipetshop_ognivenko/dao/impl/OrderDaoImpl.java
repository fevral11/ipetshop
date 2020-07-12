package ru.htp.ipetshop_ognivenko.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ru.htp.ipetshop_ognivenko.bean.Delivery;
import ru.htp.ipetshop_ognivenko.bean.Goods;
import ru.htp.ipetshop_ognivenko.dao.DaoException;
import ru.htp.ipetshop_ognivenko.dao.OrderDao;
import ru.htp.ipetshop_ognivenko.dao.connection_pool.ConnectionPool;

public class OrderDaoImpl implements OrderDao {

	private static final String ADD_GOODS_TO_ORDER_QUERY = "INSERT INTO ipetshop.order_info "
			+ "(goods_idgoods, quantity, order_idorder) VALUES (?,?,?)";
	private static final String CREATE_ORDER_QUERY = "INSERT INTO ipetshop.order "
			+ "(date_order, status, users_idusers)" + "VALUES (?,?,?)";
	private static final String FIRST_STATUS_ORDER = "create";
	private static final String SELECT_FROM_ORDER = "SELECT order_idorder AS orderId,goods_idgoods AS idgoods,title,"
			+ "manufacturer,price,price_special_offer,picture, description,quantity_warehouse,status,ipetshop.subdirectory.type_goods"
			+ " AS type_goods,ipetshop.catalog.type_animal AS type_animal FROM ipetshop.order_info JOIN ipetshop.goods "
			+ "ON ipetshop.order_info.goods_idgoods = ipetshop.goods.idgoods JOIN ipetshop.subdirectory "
			+ "ON ipetshop.goods.subdirectory_idsubdirectory = ipetshop.subdirectory.idsubdirectory "
			+ "JOIN ipetshop.catalog ON ipetshop.subdirectory.catalog_idcatalog = ipetshop.catalog.idcatalog";
	private static final String ID_GOODS_COLUMN = "idgoods";
	private static final String TYPE_ANIMAL_COLUMN = "type_animal";
	private static final String TYPE_GOODS_COLUMN = "type_goods";
	private static final String TITLE_GOODS_COLUMN = "title";
	private static final String PRICE_COLUMN = "price";
	private static final String PRICE_SPECIAL_OFFER_COLUMN = "price_special_offer";
	private static final String DESCRIPTION_COLUMN = "description";
	private static final String PICTURE_COLUMN = "picture";
	private static final String QUANTITY_COLUMN = "quantity_warehouse";
	private static final String STATUS_COLUMN = "status";
	private static final String ID_ORDER_COLUMN = "orderId";

	private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public void addGoodsToOrder(Integer goodsId, Integer orderId, Integer quantityGoods) throws DaoException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connectionPool.takeConnection();

			preparedStatement = connection.prepareStatement(ADD_GOODS_TO_ORDER_QUERY);

			preparedStatement.setInt(1, goodsId);
			preparedStatement.setInt(2, quantityGoods);
			preparedStatement.setInt(3, orderId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
	}

	@Override
	public Integer createOrder(Integer userId) throws DaoException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Integer orderId;
		Timestamp orderDate;

		orderId = null;
		orderDate = new Timestamp(System.currentTimeMillis());

		try {
			connection = connectionPool.takeConnection();

			preparedStatement = connection.prepareStatement(CREATE_ORDER_QUERY, Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setTimestamp(1, orderDate);
			preparedStatement.setString(2, FIRST_STATUS_ORDER);
			preparedStatement.setInt(3, userId);
			preparedStatement.executeUpdate();

			resultSet = preparedStatement.getGeneratedKeys();

			if (resultSet.next()) {
				orderId = resultSet.getInt(1);
			}
			return orderId;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, preparedStatement);
		}
	}

	@Override
	public List<Goods> placeOrder(Integer orderId) throws DaoException {

		List<Goods> userBasket = new ArrayList<Goods>();

		Statement statement = null;
		ResultSet resultSet = null;

		Connection connection = null;

		try {
			connection = connectionPool.takeConnection();

			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_FROM_ORDER);

			while (resultSet.next()) {
				if (orderId == resultSet.getInt(ID_ORDER_COLUMN)) {
					Goods goods = new Goods();
					goods.setGoodsId(resultSet.getInt(ID_GOODS_COLUMN));
					goods.setTypeAnimal(resultSet.getNString(TYPE_ANIMAL_COLUMN));
					goods.setTypeGoods(resultSet.getNString(TYPE_GOODS_COLUMN));
					goods.setTitle(resultSet.getNString(TITLE_GOODS_COLUMN));
					goods.setPrice(resultSet.getDouble(PRICE_COLUMN));
					goods.setPriceSpecialOffer(resultSet.getDouble(PRICE_SPECIAL_OFFER_COLUMN));
					goods.setDescription(resultSet.getString(DESCRIPTION_COLUMN));
					goods.setPicture(resultSet.getString(PICTURE_COLUMN));
					goods.setQuantityOnWarehouse(resultSet.getInt(QUANTITY_COLUMN));
					goods.setStatus(resultSet.getString(STATUS_COLUMN));
					userBasket.add(goods);
				}
			}
			return userBasket;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement, resultSet);
		}
	}

	@Override
	public boolean addDelivery(Integer idOrder, Delivery delivery) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean confirmOrder(OrderDao order) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean paymentOrder(OrderDao order) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deliveryOrder(OrderDao order) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}
}
