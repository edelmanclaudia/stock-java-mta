package com.mta.claudia.stock.service;

import java.util.Date;

import com.mta.claudia.stock.model.Portfolio;
import com.mta.claudia.stock.model.Stock;

/**
* An instance of this class represents a portfoilio service.
* @author Claudia Edelman
* @since 2014
* date 2/12/2014
*/

public class PortfolioService {
	
	/**
	* Returns a portfolio.
	* 
	*
	* @param set values to the stocks variables by using stock class 
	* * @return myportfolio with an array of stocks.
	*/
	
	public Portfolio getPortfolio(){
		
		Portfolio myPortfolio = new Portfolio();
		Date date = new java.util.Date ();
		
		date.setMonth(11);
		date.setDate(15);
		date.setYear(2014);
		
		Stock stock1 = new Stock ("PIH", 12.4f, 13.1f, date);
		Stock stock2 = new Stock ("AAL",5.5f,5.78f,date);
		Stock stock3 = new Stock ("CAAS",31.5f,31.2f,date);
		
		//stock1.setStockSymbol("PIH");
		//stock1.setAsk(12.4f);
		//stock1.setBid(13.1f);
		//stock1.setDate(date);
		myPortfolio.addStock(stock1);
		
		//stock2.setStockSymbol("AAL");
		//stock2.setAsk(5.5f);
		//stock2.setBid(5.78f);
		//stock2.setDate(date);
		myPortfolio.addStock(stock2);

		//stock3.setStockSymbol("CAAS");
		//stock3.setAsk(31.5f);
		//stock3.setBid(31.2f);
		//stock3.setDate(date);
		myPortfolio.addStock(stock3);
		
		return myPortfolio;
	}
}
