package shiti;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

import operator.GoodOperator;
import operator.UserOperator;

public class test {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUsername("test");
		u.setPassword("test");
		u.setEmail("978190375@qq.com");
		u.setPhone("17640683350");
		u.setVip(0);
		UserOperator uo=new UserOperator();
		uo.saveUser(u);
	}
	public static Date stringToDate(String time) throws ParseException {
		
		SimpleDateFormat st=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		ParsePosition pos=new ParsePosition(0);
		Date date=st.parse(time);
		return date;
		
	}
}
