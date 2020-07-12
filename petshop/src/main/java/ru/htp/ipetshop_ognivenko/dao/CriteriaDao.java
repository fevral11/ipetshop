package ru.htp.ipetshop_ognivenko.dao;

import java.util.List;

import ru.htp.ipetshop_ognivenko.bean.criteria.Criteria;

public interface CriteriaDao<E> {

	public List<?> create(Criteria<E> criteria) throws DaoException;


}
