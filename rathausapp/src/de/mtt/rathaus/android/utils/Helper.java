package de.mtt.rathaus.android.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author vpham
 * Helper methods
 */

public class Helper {

	public static String formatDate(Date date){
		/*Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("Germany"));
		cal.setTimeInMillis(date.getTime());
		String format = cal.get(Calendar.HOUR) +":"+cal.get(Calendar.MINUTE)+
				" / " + cal.get(Calendar.DATE)+"."+cal.get(Calendar.MONTH)+"."+cal.get(Calendar.YEAR);*/
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		return sdf.format(date);
	}
}
