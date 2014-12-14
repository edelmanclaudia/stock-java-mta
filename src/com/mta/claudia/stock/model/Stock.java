package com.mta.claudia.stock.model;

import java.util.Date;

/**
* An instance of this class represents a Stock with all of its characters.
* @author Claudia Edelman
* @since 2014
* date 21/11/2014
*/

public class Stock {
	
	private String stockSymbol;
	private float ask;
	private float bid;
	private Date date;
	
	/**
	* copy constructor
	* @param stocks 
	*/
	
	public Stock(Stock stock){
		this(stock.getStockSymbol(),stock.getAsk(),stock.getBid(),new Date(stock.getDate().getTime()));
	}
	
	/**
	* constructor
	* @param stocks 
	*/
	
	public Stock(String stockSymbol1, float ask1, float bid1, Date date1) {
		if(stockSymbol1 != null)
		{
			setStockSymbol(stockSymbol1);
			setAsk(ask1);
			setBid(bid1);
			setDate(date1);
		}
		//else
			//System.out.print
	}
	
	//getters:
	
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
	
	//setters:
	
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
	
	/**
	* Returns the description stocks.
	* 
	*
	* @param present the stock and print the stock description
	* * @return the getHtmlDescription.
	*/
	
	public String getHtmlDescription(){
		String stockHtmlDetailsString = "<b>Stock symbol</b>: " +getStockSymbol()+ ",<b>ask</b>: " +getAsk()+ ",<b>bid</b>: "
										+getBid()+ ",<b>date</b>: " +date.getDate()+ "/" +date.getMonth()+ "/" +date.getYear();
		return stockHtmlDetailsString;
	}
}
