package test;
import java.util.List;

import main.src.common.SqlUtils;
import main.src.entity.User;
public class DBtest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sql="select * from user";
		List result=SqlUtils.executeQuery(sql, null, User.class);
		System.out.println(((User)result.get(0)).getLogin_name());
		System.out.println(((User)result.get(0)).getUser_name());
		
	}

}
