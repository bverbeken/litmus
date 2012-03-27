package litmus.util;

import java.text.ParseException;
import java.util.Date;

import static org.apache.commons.lang.time.DateUtils.addHours;
import static play.utils.Utils.AlternativeDateFormat.getDefaultFormatter;

public final class DateUtil {
	
	
	public static Date asDate(String dateAsString){
		try {
			return getDefaultFormatter().parse(dateAsString);
		} catch (ParseException e) {
			throw new RuntimeException("failed to parse date [" + dateAsString + "]", e);
		}
	}

	public static Date dateInFuture() {
		return addHours(now(), 1);
	}

	public static Date dateInPast() {
		return addHours(now(), -1);
	}

	public static Date now() {
		return new Date();
	}
}
