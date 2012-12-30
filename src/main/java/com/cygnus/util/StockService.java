package com.cygnus.util;

import java.util.Date;
import java.util.List;

import com.cygnus.dao.StockDetailsDao;
import com.cygnus.dto.Stock;

public class StockService{
	
	private static long marketCap = 1000000000; // 1000M
	private static long totalvolume = 1000000; // 1M
	private static String orderByColumn = "percentgainorloss";
	private static int howManyRows = 20;

	public static List<Stock> getMarketGainers(Date date) {
		
		System.out.println("In ServiceImpl Date: " + date);
		try{
			return StockDetailsDao.getMaketGainers(date, marketCap, totalvolume, orderByColumn, "desc", howManyRows);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Stock> getMarketLoosers(Date date) {
		
		System.out.println("In ServiceImpl Date: " + date);
		try{
			return StockDetailsDao.getMarketLoosers(date, marketCap, totalvolume, orderByColumn, "asc", howManyRows);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] ar){
		List<Stock> gainers = getMarketGainers(new Date());
		System.out.println(gainers);
		
	}
	
}
