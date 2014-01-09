package main.src.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class SqlUtils {
	static String url = null;
	static String Driver = null;
	static String user = null;
	static String password = null;
	static Connection cnn = null;
	static {
		Driver = MessageUtils.getMessageFromDbInfo("Driver");
		url = MessageUtils.getMessageFromDbInfo("url");
		user = MessageUtils.getMessageFromDbInfo("user");
		password = MessageUtils.getMessageFromDbInfo("password");
		DbUtils.loadDriver(Driver);
	}

	public static Connection getConnection() throws SQLException {

		cnn = DriverManager.getConnection(url, user, password);

		return cnn;
	}
	
	public static List<Object> executeQuery(String sql,Object[] params,Class entity){
		List<Map<String,Object>> result=null;
		QueryRunner qr=new QueryRunner();
		try {
			if(null!=cnn){
			cnn=getConnection();
			}
			result=qr.query(cnn, sql, new MapListHandler(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return MaptoBean(result,entity);
	}
	public  static List<Object> MaptoBean(List<Map<String,Object>> resultSet,Class entity){
		Object obj=null;
		Object xx=entity.getClass().getName();
		try {
			
			obj=ConstructorUtils.invokeExactConstructor(entity, null);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//存放返回对象
		List beans=new ArrayList();
		
		for(Map<String,Object> result:resultSet)
		{
			for (Map.Entry<String, Object> entry :result.entrySet()) {
				
				String key=entry.getKey();
				Object value=entry.getValue();
				try {
					BeanUtils.setProperty(obj, key.toLowerCase(),value);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			beans.add(obj);
		}
		return beans;
	}
	public static List<Map<String,Object>> executeQuery(String sql,Object[] params){
		List<Map<String,Object>> result=null;
		try {
			if(null!=cnn){
				cnn=getConnection();
				}
			QueryRunner qr=new QueryRunner();
			result=qr.query(sql, new MapListHandler(), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public static int executeUpdate(String sql,Object[] params){
		int count=0;
		try {
			if(null!=cnn){
				cnn=getConnection();
				}
			QueryRunner qr=new QueryRunner();
			count=qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
}
