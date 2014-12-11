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
		
		myPortfolio.addStock(stock1);
		myPortfolio.addStock(stock2);
		myPortfolio.addStock(stock3);
		
		myPortfolio.setTitle("<h1>Portfolio 1#</h1>");
		
		return myPortfolio;
	}
}
