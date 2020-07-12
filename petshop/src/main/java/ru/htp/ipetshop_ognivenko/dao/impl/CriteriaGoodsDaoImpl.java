package ru.htp.ipetshop_ognivenko.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import ru.htp.ipetshop_ognivenko.bean.Goods;
import ru.htp.ipetshop_ognivenko.bean.criteria.Criteria;
import ru.htp.ipetshop_ognivenko.dao.CriteriaDao;
import ru.htp.ipetshop_ognivenko.dao.DaoException;
import ru.htp.ipetshop_ognivenko.dao.connection_pool.ConnectionPool;

public class CriteriaGoodsDaoImpl<E> implements CriteriaDao<Object> {

	private static final String REQUEST_CRITERIA_GOODS = "SELECT idgoods,title,manufacturer,price,price_special_offer,picture,"
			+ "description,quantity_warehouse,status,ipetshop.subdirectory.type_goods AS type_goods,"
			+ "ipetshop.catalog.type_animal AS type_animal FROM ipetshop.goods JOIN ipetshop.subdirectory "
			+ "ON ipetshop.goods.subdirectory_idsubdirectory = ipetshop.subdirectory.idsubdirectory "
			+ "JOIN ipetshop.catalog ON ipetshop.subdirectory.catalog_idcatalog = ipetshop.catalog.idcatalog";

	private static final String IDGOODS_COLUMN = "idgoods";
	private static final String TYPE_ANIMAL_COLUMN = "type_animal";
	private static final String TYPE_GOODS_COLUMN = "type_goods";
	private static final String TITLE_GOODS_COLUMN = "title";
	private static final String PRICE_COLUMN = "price";
	private static final String PRICE_SPECIAL_OFFER_COLUMN = "price_special_offer";
	private static final String DESCRIPTION_COLUMN = "description";
	private static final String PICTURE_COLUMN = "picture";
	private static final String QUANTITY_COLUMN = "quantity_warehouse";
	private static final String STATUS_COLUMN = "status";
	private static final String STATUS_GOODS_ACTIVE = "active";

	private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

	public List<?> create(Criteria<Object> criteria) throws DaoException {

		List<?> listGoods = new ArrayList<>();
		String groupSearchName;

		groupSearchName = criteria.getGroupSearchName().toUpperCase();

		switch (groupSearchName) {

		case "GOODS":
			return findGoods(criteria);
		case "USERS":
			return findUsers(criteria);
		}
		return listGoods;
	}

	private List<Goods> findGoods(Criteria<Object> criteria) throws DaoException {

		List<Goods> listGoods = new ArrayList<>();

		String column;
		String valueSearch;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		valueSearch = null;
		column = null;

		try {
			connection = connectionPool.takeConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(REQUEST_CRITERIA_GOODS);

			Set<Object> keys = criteria.getCriteria().keySet();

			for (Object key : keys) {
				valueSearch = criteria.getCriteria().get(key).toString();
				column = key.toString();
			}

			while (resultSet.next()) {

				int columnSeach = resultSet.findColumn(column);
				String c = resultSet.getString(columnSeach);

				if (c.equals(valueSearch)) {
					if (resultSet.getString(STATUS_COLUMN).equals(STATUS_GOODS_ACTIVE)
							&& resultSet.getInt(QUANTITY_COLUMN) > 0) {
						Goods goods = new Goods();
						goods.setGoodsId(resultSet.getInt(IDGOODS_COLUMN));
						goods.setTypeAnimal(resultSet.getNString(TYPE_ANIMAL_COLUMN));
						goods.setTypeGoods(resultSet.getNString(TYPE_GOODS_COLUMN));
						goods.setTitle(resultSet.getNString(TITLE_GOODS_COLUMN));
						goods.setPrice(resultSet.getDouble(PRICE_COLUMN));
						goods.setPriceSpecialOffer(resultSet.getDouble(PRICE_SPECIAL_OFFER_COLUMN));
						goods.setDescription(resultSet.getString(DESCRIPTION_COLUMN));
						goods.setPicture(resultSet.getString(PICTURE_COLUMN));
						goods.setQuantityOnWarehouse(resultSet.getInt(QUANTITY_COLUMN));
						goods.setStatus(resultSet.getString(STATUS_COLUMN));
						listGoods.add(goods);
					}
				}
			}
			return listGoods;
		} catch (SQLException e) {
			throw new DaoException(e);
		} finally {
			connectionPool.closeConnection(connection, statement, resultSet);
		}
	}

	private List<Goods> findUsers(Criteria<Object> criteria) throws DaoException {
		return null;
	}
}
