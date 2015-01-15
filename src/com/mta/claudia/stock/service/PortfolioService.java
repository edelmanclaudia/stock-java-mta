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
	 * @param set values to the stocks variables by using stock class 
	 * * @return myportfolio with an array of stocks.
	 */

	@SuppressWarnings("deprecation")
	public Portfolio getPortfolio() throws Exception {
		Portfolio myPortfolio = new Portfolio();
		Date date = new java.util.Date ();

		myPortfolio.setBalance(10000); // or anther option to updateBalanvc(10000)

		date.setMonth(11);
		date.setDate(15);
		date.setYear(114);

		Stock stock1 = new Stock ("PIH",10, 8.5f,date);
		Stock stock2 = new Stock ("AAL",30,25.5f,date);
		Stock stock3 = new Stock ("CAAS",20,15.5f,date);

		myPortfolio.addStock(stock1);
		myPortfolio.addStock(stock2);
		myPortfolio.addStock(stock3);

		myPortfolio.addStock(stock3);

		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS",40);

		myPortfolio.sellStock("AAL", -1);

		myPortfolio.setTitle("Exercise 9 portfolio");

		return myPortfolio;
	}
}