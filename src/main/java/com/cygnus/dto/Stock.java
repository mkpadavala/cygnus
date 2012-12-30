package com.cygnus.dto;

import java.io.Serializable;
import java.util.Date;

public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ticker;
	private double lastTrade;
	private Date tradeDate;
	private Date tradeTimeStamp;
	private double gainOrLoss;
	private double openedAt;
	private double daysHigh;
	private double daysLow;
	private double totalVolume;
	private double marketCap;
	private double previousClose;
	private double percentGainOrLoss;
	private double fiftyTwoWeekLow;
	private double fiftyTwoWeekHigh;
	private double EPS;
	private double PE;
	private String companyName;
	private Date creationDate;

	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public double getLastTrade() {
		return this.lastTrade;
	}

	public void setLastTrade(double lastTrade) {
		this.lastTrade = lastTrade;
	}

	public Date getTradeDate() {
		return this.tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Date getTradeTimeStamp() {
		return this.tradeTimeStamp;
	}

	public void setTradeTimeStamp(Date tradeTimeStamp) {
		this.tradeTimeStamp = tradeTimeStamp;
	}

	public double getGainOrLoss() {
		return this.gainOrLoss;
	}

	public void setGainOrLoss(double gainOrLoss) {
		this.gainOrLoss = gainOrLoss;
	}

	public double getOpenedAt() {
		return this.openedAt;
	}

	public void setOpenedAt(double openedAt) {
		this.openedAt = openedAt;
	}

	public double getDaysHigh() {
		return this.daysHigh;
	}

	public void setDaysHigh(double daysHigh) {
		this.daysHigh = daysHigh;
	}

	public double getDaysLow() {
		return this.daysLow;
	}

	public void setDaysLow(double daysLow) {
		this.daysLow = daysLow;
	}

	public double getTotalVolume() {
		return this.totalVolume;
	}

	public void setTotalVolume(double totalVolume) {
		this.totalVolume = totalVolume;
	}

	public double getMarketCap() {
		return this.marketCap;
	}

	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}

	public double getPreviousClose() {
		return this.previousClose;
	}

	public void setPreviousClose(double previousClose) {
		this.previousClose = previousClose;
	}

	public double getPercentGainOrLoss() {
		return this.percentGainOrLoss;
	}

	public void setPercentGainOrLoss(double percentGainOrLoss) {
		this.percentGainOrLoss = percentGainOrLoss;
	}

	public double getFiftyTwoWeekLow() {
		return this.fiftyTwoWeekLow;
	}

	public void setFiftyTwoWeekLow(double fiftyTwoWeekLow) {
		this.fiftyTwoWeekLow = fiftyTwoWeekLow;
	}

	public double getFiftyTwoWeekHigh() {
		return this.fiftyTwoWeekHigh;
	}

	public void setFiftyTwoWeekHigh(double fiftyTwoWeekHigh) {
		this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
	}

	public double getEPS() {
		return this.EPS;
	}

	public void setEPS(double eps) {
		this.EPS = eps;
	}

	public double getPE() {
		return this.PE;
	}

	public void setPE(double pe) {
		this.PE = pe;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}