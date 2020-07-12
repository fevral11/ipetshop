package ru.htp.ipetshop_ognivenko.bean.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

	private String groupSearchName;
	private Map<E, Object> criteria = new HashMap<>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	public String getGroupSearchName() {
		return groupSearchName;
	}

	public Map<E, Object> getCriteria() {
		return criteria;
	}

	public void add(E searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}
}
