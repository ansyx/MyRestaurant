package main.src.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import main.src.entity.User;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class SqlUtils {
	static MessageUtils messageUtils;
	static String url = null;
	static String Driver = null;
	static String user = null;
	static String password = null;
	static Connection cnn = null;
	static {
		Driver = messageUtils.getMessageFromDbInfo("Driver");
		url = messageUtils.getMessageFromDbInfo("url");
		user = messageUtils.getMessageFromDbInfo("user");
		password = messageUtils.getMessageFromDbInfo("password");
		DbUtils.loadDriver(Driver);
	}

	public Connection getConnection() throws SQLException {

		cnn = DriverManager.getConnection(url, user, password);

		return cnn;
	}
	
	public List<Object> executeQuery(String sql,String[] parameters,Class type){
		

		
		
		
		
		
		return null;
	}
	
	
	
}
