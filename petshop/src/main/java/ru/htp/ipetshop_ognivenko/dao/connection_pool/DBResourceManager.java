package ru.htp.ipetshop_ognivenko.dao.connection_pool;

import java.util.ResourceBundle;

public class DBResourceManager {

	private final static DBResourceManager instance = new DBResourceManager();

	private ResourceBundle bundle = ResourceBundle.getBundle("db");

	public static DBResourceManager getInstance() {
		return instance;
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}
}