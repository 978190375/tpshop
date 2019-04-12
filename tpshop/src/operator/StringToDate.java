package operator;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	public static Date StringToDate(String time) throws ParseException {

		SimpleDateFormat st=new SimpleDateFormat("yy-MM-dd");
		ParsePosition pos=new ParsePosition(0);
		Date date=st.parse(time);
		return date;
	}
}
