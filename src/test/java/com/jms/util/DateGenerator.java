package com.jms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateGenerator {
	
	private static DateGenerator dg = null;
	
	private Calendar cal = null;
	private SimpleDateFormat format = null;
	
	private DateGenerator() {
		cal = new GregorianCalendar();
		format = new SimpleDateFormat("MM/dd/YYYY");
	}
	
	public static DateGenerator getInstance() {
		if (dg == null)
			return new DateGenerator();
		else
			return dg;
	}
	
	public String currentDate() {		
		return format.format(cal.getTime());
	}

	public String modifiedDate(int addY, int addM, int addD) {
		cal.add(Calendar.YEAR, addY);
		cal.add(Calendar.MONTH, addM);
		cal.add(Calendar.DAY_OF_YEAR, addD);
		return format.format(cal.getTime());
	}
	
	public String particularDate(int y, int m, int d) {
		cal.set(y, m, d);
		return format.format(cal.getTime());
	}
	
	public String modifyParticularDate(Calendar cal, int addY, int addM, int addD) {
		cal.add(Calendar.YEAR, addY);
		cal.add(Calendar.MONTH, addM);
		cal.add(Calendar.DAY_OF_YEAR, addD);
		return format.format(cal.getTime());
	}

}
