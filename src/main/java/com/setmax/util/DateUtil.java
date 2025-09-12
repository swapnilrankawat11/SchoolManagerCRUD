package com.setmax.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat(DATETIME_FORMAT);

	public static Date parseToDate(String dateString) {
		Date date = null;
		try {
			date = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static java.sql.Date parseToSqlDate(String sqlDate) {
		java.sql.Date date = new java.sql.Date(parseToDate(sqlDate).getTime());
		return date;
	}
	
	public static java.sql.Date parseToSqlDate(Date javaDate){
		java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
		return sqlDate;
	}

	public static Date parseToDate(java.sql.Date sqlDate) {
		java.util.Date javaDate = new java.util.Date(sqlDate.getTime());
		return javaDate;
	}

	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}

	public static String getCurrentDateTime() {
		Date date = new Date();
		return dateTimeFormat.format(date);
	}

	public static String formatSqlDate(java.sql.Date date) {
		Date javaDate = parseToDate(date);
		return formatDate(javaDate);
	}

	public static int getYearFromDate(Date date) {
		int year;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		year = calendar.get(Calendar.YEAR);
		return year;
	}
}
