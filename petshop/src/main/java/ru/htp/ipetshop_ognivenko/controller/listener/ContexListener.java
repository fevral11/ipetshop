package ru.htp.ipetshop_ognivenko.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ru.htp.ipetshop_ognivenko.dao.connection_pool.ConnectionPool;

public class ContexListener implements ServletContextListener {

	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		connectionPool.initPoolData();
		ServletContextListener.super.contextInitialized(sce);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		connectionPool.destroy();
		ServletContextListener.super.contextDestroyed(sce);
	}

}
