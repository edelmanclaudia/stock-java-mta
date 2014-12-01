package com.mta.javacourse.model;

import java.util.Date;

public class Stock {
	
	private String stockSymbol;
	private float ask;
	private float bid;
	private Date date;
	
	public String getStockSymbol (){
		return stockSymbol;
	}
	
	public float getAsk (){
		return ask;
	}
	
	public float getBid (){
		return bid;
	}
	
	public Date getDate (){
		return date;
	}
	
	public void setStockSymbol (String symbol){
		stockSymbol = symbol;
	}
	
	public void setAsk (float newAsk){
		ask = newAsk;
	}
	
	public void setBid (float newBid){
		bid = newBid;
	}
	
	public void setDate (Date newDate){
		date = newDate;
	}
	
	public String getHtmlDescription(){
		String stockHtmlDetailsString = "<b>Stock symbol</b>: " +getStockSymbol()+ ",<b>ask</b>: " +getAsk()+ ",<b>bid</b>: "
										+getBid()+ ",<b>date</b>: " +date.getDate()+ "/" +date.getMonth()+ "/" +date.getYear();
		return stockHtmlDetailsString;
	}
	
}
