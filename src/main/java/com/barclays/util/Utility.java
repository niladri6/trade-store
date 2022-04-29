package com.barclays.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.barclays.Exception.CustomException;

public class Utility {
	private static final String DATE_FORMAT = "dd/MM/YYYY";

	public static Date toDate(String date) {
		DateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		Date convertedCurrentDate = null;
		try {
			convertedCurrentDate = sdf.parse(date);
			String d = sdf.format(convertedCurrentDate);
			System.out.println(d);
		} catch (ParseException e) {
			throw new CustomException(e);
		}
		return convertedCurrentDate;
	}

	public static String toDate(Date date) {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(date);
	}

	public static boolean isTradeExpired(String maturityDate) {
		return toDate(maturityDate).before(new Date());
	}

}
