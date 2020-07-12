package ru.htp.ipetshop_ognivenko.service.impl;

import java.util.ArrayList;
import java.util.List;

import ru.htp.ipetshop_ognivenko.bean.Goods;
import ru.htp.ipetshop_ognivenko.bean.criteria.Criteria;
import ru.htp.ipetshop_ognivenko.dao.CriteriaDao;
import ru.htp.ipetshop_ognivenko.dao.DaoException;
import ru.htp.ipetshop_ognivenko.dao.DaoProvider;
import ru.htp.ipetshop_ognivenko.service.CriteriaService;
import ru.htp.ipetshop_ognivenko.service.ServiceException;

public class CriteriaGoodsServiceImpl<E> implements CriteriaService<Object> {

	@Override
	public List<?> create(Criteria<Object> criteria) throws ServiceException {

		List<?> listGoods = new ArrayList<Goods>();

		DaoProvider daoProvider = DaoProvider.getInstance();
		CriteriaDao<Object> criteriaDao = daoProvider.geCriteriaDao();

		try {
			listGoods = criteriaDao.create(criteria);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return listGoods;
	}
}
