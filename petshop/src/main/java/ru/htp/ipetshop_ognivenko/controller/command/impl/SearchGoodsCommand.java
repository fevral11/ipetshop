package ru.htp.ipetshop_ognivenko.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.htp.ipetshop_ognivenko.bean.criteria.Criteria;
import ru.htp.ipetshop_ognivenko.controller.command.Command;
import ru.htp.ipetshop_ognivenko.service.CriteriaService;
import ru.htp.ipetshop_ognivenko.service.ServiceException;
import ru.htp.ipetshop_ognivenko.service.ServiceProvider;

public class SearchGoodsCommand implements Command {

	private static final String REDIRECT_MAIN_PAGE = "Controller?command=go_to_main_page";
	private static final String REDIRECT_ERROR_PAGE = "Controller?command=go_to_error_page";
	private static final String LIST_GOODS_ATTRIBUTE_SESSION = "listGoods";
	private static final String GROUP_SEARCH_NAME_PARAMETER_REQUEST = "groupSearchName";
	private static final String SEARCH_CRITERIA_PARAMETER_REQUEST = "searchCriteria";
	private static final String SPLIT_REGEX_EXPRESSION = "=";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Criteria<Object> criteria;

		String groupSearchName;
		Object searchCriteria;
		Object value;

		groupSearchName = request.getParameter(GROUP_SEARCH_NAME_PARAMETER_REQUEST);

		searchCriteria = request.getParameter(SEARCH_CRITERIA_PARAMETER_REQUEST).split(SPLIT_REGEX_EXPRESSION)[0];
		value = request.getParameter(SEARCH_CRITERIA_PARAMETER_REQUEST).split(SPLIT_REGEX_EXPRESSION)[1];
		
		criteria = new Criteria<Object>(groupSearchName);
		criteria.add(searchCriteria, value);

		ServiceProvider serviceProvider = ServiceProvider.getInstance();
		CriteriaService<Object> criteriaService = serviceProvider.getCriteriaService();
		try {
			List<?> listGoods = criteriaService.create(criteria);

			request.getSession().setAttribute(LIST_GOODS_ATTRIBUTE_SESSION, listGoods);
			response.sendRedirect(REDIRECT_MAIN_PAGE);

		} catch (ServiceException e) {
			response.sendRedirect(REDIRECT_ERROR_PAGE);
		}
	}
}
