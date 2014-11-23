package com.mta.javacourse;

import java.util.Date;

public class My_Stock {
	
	private String StockSymbol;
	private float Ask;
	private float Bid;
	private Date date;
	
	
	public String getStockSymbol (){
		return StockSymbol;
	}
	
	public float getAsk (){
		return Ask;
	}
	
	public float getBid (){
		return Bid;
	}
	
	public Date getDate (){
		return date;
	}
	
	public void setStockSymbol (String mySymbol){
		StockSymbol = mySymbol;
	}
	
	public void setAsk (float myAsk){
		Ask = myAsk;
	}
	
	public void setBid (float myBid){
		Bid = myBid;
	}
	
	public void setDate (Date myDate){
		date = myDate;
	}
	
	public String getHtmlDescription(){
		String stockHtmlDetailsString = "<b>Stock symbol</b>: " +getStockSymbol()+ ",<b>ask</b>: " +getAsk()+ ",<b>bid</b>: "
										+getBid()+ ",<b>date</b>: " +date.getDate()+ "/" +date.getMonth()+ "/" +date.getYear();
		return stockHtmlDetailsString;
	}
	
}
