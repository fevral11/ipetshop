package ru.htp.ipetshop_ognivenko.dao.impl;

import ru.htp.ipetshop_ognivenko.bean.Goods;
import ru.htp.ipetshop_ognivenko.bean.Supply;
import ru.htp.ipetshop_ognivenko.dao.DaoException;
import ru.htp.ipetshop_ognivenko.dao.GoodsDao;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public boolean addGoods(Goods good) throws DaoException {
		return false;
	}

	@Override
	public boolean deleteGoods(Goods good) throws DaoException {
		return false;
	}

	@Override
	public boolean addQuantity(Integer idGoods, Supply supply) throws DaoException {
		return false;
	}

	@Override
	public boolean changePriceGoods(Goods good, Double newPrice) throws DaoException {
		return false;
	}

	@Override
	public boolean changeDescriptionGoods(Goods good, String newDescription) throws DaoException {
		return false;
	}

	@Override
	public boolean changePictureGoods(Goods good, String newPicture) throws DaoException {
		return false;
	}

	@Override
	public boolean supplyGoods(Goods good, Supply supply) throws DaoException {
		return false;
	}

}
