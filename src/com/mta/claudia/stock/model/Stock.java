package com.mta.claudia.stock.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * An instance of this class represents a Stock with all of its characters.
 * @author Claudia Edelman
 * @since 2014
 * date 21/11/2014
 */

public class Stock {

	protected String stockSymbol;
	protected float ask;
	protected float bid;
	protected Date date;

	/**
	 * constructor
	 * @param stocks 
	 */

	public Stock(){

	}
	
	/**
	 * constructor
	 * @param stocks 
	 */

	public Stock(String stockSymbol, float ask, float bid, Date date) {
		if(stockSymbol != null)
		{
			setStockSymbol(stockSymbol);
			setAsk(ask);
			setBid(bid);
			setDate(date);
		}

		else
			System.out.println("there arent stocks to copy");
	}
	
	/**
	 * copy constructor
	 * @param stocks 
	 */

	public Stock(Stock stock){
		this(stock.getStockSymbol(),stock.getAsk(),stock.getBid(),new Date(stock.getDate().getTime()));
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
	 * @param present the stock and print the stock description
	 * * @return the getHtmlDescription.
	 */

	public String getHtmlDescription(){
		String stockHtmlDetailsString = "<b>Stock symbol</b>: " +getStockSymbol()+ " , <b>ask</b>: " +getAsk()+ " , <b>bid</b>: "
				+getBid()+ " , <b>date</b>: " +new SimpleDateFormat("dd-MM-yyyy").format(date);
		return stockHtmlDetailsString;
	}
}