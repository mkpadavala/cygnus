package com.padavala.loom.financialcalculator;

import java.text.DecimalFormat;

public class FutureValue {

	private static DecimalFormat df = new DecimalFormat("##.##");
	
	public double futureValueOfAnnuity(double amountPerMonth, double interestRate, int numberOfYears, Frequency frequency) throws Exception{
		
		/**
		 * Formula is : annuityPerMonth * ((1+interestRateYearly)^NumberOfYears)-1)/interestRateYearly
		 */
		
		if(amountPerMonth < 0){
			 throw new Exception("Invalid Amount: Amount should be positive");
		}
		interestRate = interestRate/(100*frequency.getValue());
		return amountPerMonth * (Math.pow(1+interestRate, numberOfYears*frequency.getValue())-1)/interestRate;

	}
	
	public double futureValueOfSingleAmount(double amount, double interestRate, int numberOfMonths) throws Exception{
		
		/**
		 * Formula is : amount * ((1+interestRateYearly)^NumberOfYears)
		 */
		
		if(amount < 0){
			 throw new Exception("Invalid Amount: Amount should be positive");
		}
		interestRate = interestRate/100;
		double years = (numberOfMonths*1.0)/12;
		return amount * Math.pow(1+interestRate, years);
		
	}
	
	
	
	public static void main(String[] a){
		FutureValue fv = new FutureValue();
		
		try {
			System.out.println(df.format(fv.futureValueOfSingleAmount(100, 8, 96)));
			
			System.out.println(df.format(fv.futureValueOfAnnuity(100, 10, 2, Frequency.MONTHLY)));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
