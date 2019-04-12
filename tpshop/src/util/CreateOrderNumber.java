package util;

import java.util.Date;

public class CreateOrderNumber {
	public static String CreateOrderNumber(int user_id) {
		Date date = new Date();
		String user=String.valueOf(user_id);
		int length=user.length();
		for(int i=0;i<6-length;i++) {
			user="0"+user;
		}
		String OrderNumber="S"+user+date.getTime();
		return OrderNumber;
	}
}
