package ru.htp.ipetshop_ognivenko.service;

import java.util.List;

import ru.htp.ipetshop_ognivenko.bean.criteria.Criteria;


public interface CriteriaService<E> {

	List<?> create(Criteria<E> criteria) throws ServiceException;
	

}
