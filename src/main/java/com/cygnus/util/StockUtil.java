package com.cygnus.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class StockUtil {

	private static final String SINGLE_QUOTE = "'";
	private static final String DOUBLE_QUOTE = "\"";
	private static final String EMPTY_STRING = "";
	private static final String NA = "N/A";
	private static final String NA_NA = "N/A - N/A";
	private static final String M = "M";
	private static final String B = "B";
	private static final String K = "K";
	private static final String PERCENTAGE = "%";
	private static final String HYPHEN = "-";
	private static final int THOUSAND = 1000;
	private static final int MILLION = 1000000;
	private static final int BILLION = 	1000000000;
	private static DateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
	private static DateFormat timeFormatter = new SimpleDateFormat("MM/dd/yyyyh:mma");
	
	
	
	public static DateFormat getTimeFormatter() {
		return timeFormatter;
	}
	public static DateFormat getDateFormatter() {
		return dateFormatter;
	}
	/**
	 * As of now  below characters are defined as Special Characters
	 * 	1. Single Quotes 
	 *  2. Double Quotes
	 */

	
	public static String removeSpecialCharacters(String line){
		line = line.replace(DOUBLE_QUOTE, EMPTY_STRING);
		line = line.replace(SINGLE_QUOTE, EMPTY_STRING);
		return line;
	}
	/**
	 * replace N/A  with 0 (Zero) else return the double value of String
	 * @param str
	 * @return
	 */
	public static double stringToDouble_NA(String str){

		double value = 0;
		try {
			if(str.equalsIgnoreCase(NA)){
				return value;
			}
			return Double.valueOf(str);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return value;
		} 
	}
	
	public static double stringToDouble_NA_KMB(String str){
		
		double value = 0;
		try {
			if(str.equalsIgnoreCase(NA)){
				return value;
			}
			if(str.endsWith(K)){
				str = str.replaceAll(K, EMPTY_STRING);
				value = Double.valueOf(str) * THOUSAND;
			}
			if(str.endsWith(M)){
				str = str.replaceAll(M, EMPTY_STRING);
				value = Double.valueOf(str) * MILLION;
			}
			else if(str.endsWith(B)){
				str = str.replaceAll(B, EMPTY_STRING);
				value = Double.valueOf(str) * BILLION;
			}
			else{
				value = Double.valueOf(str);
			}
			return value;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return value;
		} 
	}
	
	
	
	public static double stringToDouble_NA_NA(String str, int index){
		
		double value = 0;
		String firstToken = null;
		String secondToken = null;
		try {
			if(str.equalsIgnoreCase(NA_NA)){
				return value;
			}
			StringTokenizer st = new StringTokenizer(str, HYPHEN);
			firstToken = st.nextToken();
			secondToken = st.nextToken();
			if(index == 1){
				value = Double.valueOf(firstToken);
			}
			else{
				value = Double.valueOf(secondToken);
			}
			return value;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return value;
		} 
	}
	
	
	public static double stringToDouble_PER(String str){
		
		double value = 0;
		try {
			if(str.equalsIgnoreCase(NA)){
				return value;
			}
			if(str.endsWith(PERCENTAGE)){
				str = str.replaceAll(PERCENTAGE, EMPTY_STRING);
				value = Double.valueOf(str);
			}
			return value;
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return value;
		} 
	}
	
	public static Date StringToDate(String str){

		Date date = null;
		
		if (str != null && str.equalsIgnoreCase(NA)) {
			return date;
		}
		try {
			date = dateFormatter.parse(str);	
		} catch (Exception e) {
			e.printStackTrace();
			return date;
		}
		return date;
	}
	
	
	
	
	public static Date getTradeTimeStamp(String str, String time){
		
		Date date = null;
		if (str != null && str.equalsIgnoreCase(NA)) {
			return null;
		}
		try {
			if(time != null){
				if(time.equalsIgnoreCase(NA)){
					return null;
				}
				else{
					date = timeFormatter.parse(str+time);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return date;
		}
		
		return date;
	}
	
}
