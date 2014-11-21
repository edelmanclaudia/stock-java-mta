package com.mta.javacourse;

public class My_Stock {
	
	private String StockSymbol;
	private float Ask;
	private float Bid;
	private java.util.Date date;
	
	public String getStockSymbol (){
		return StockSymbol;
	}
	
	public float getAsk (){
		return Ask;
	}
	
	public float getBid (){
		return Bid;
	}
	
	public java.util.Date getDate (){
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
	
	public void setDate (java.util.Date myDate){
		date = myDate;
	}
	
	public String getHtmlDescription(){
		String stockHtmlDetailsString = "<b> Stock symbol </b>:" +getStockSymbol()+ ",<b> ask </b>: " +getAsk()+ ", <b> bid </b>:" +getBid()+ ",<b> date </b>:" +date.getMonth()+ "/" +date.getDate()+ "/" +date.getYear();
		return stockHtmlDetailsString;
	}
	
}
