package main.src.common;

import java.util.ResourceBundle;

public class MessageUtils {

	public static String getMessageFromDbInfo(String key){
		
		ResourceBundle rb=ResourceBundle.getBundle("main.resource.dbinfo");
		
		return rb.getString(key);
	}

}
