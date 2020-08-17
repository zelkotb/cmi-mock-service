package effyis.rdv.payment.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author EL KOTB ZAKARIA
 *
 */
public class DateUtil {

	public static String formatDate(String format, Date date) {
		DateFormat formatter = new SimpleDateFormat(format);
		Date unformattedDate = date;
		return formatter.format(unformattedDate);
	}
}
