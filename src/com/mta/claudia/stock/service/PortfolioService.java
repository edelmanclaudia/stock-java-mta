package com.mta.claudia.stock.service;

import java.util.Date;

import com.google.appengine.api.modules.ModulesServicePb.StopModuleRequest;
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

	@SuppressWarnings("deprecation")
	public Portfolio getPortfolio(){

		Portfolio myPortfolio = new Portfolio();
		Date date = new java.util.Date ();

		myPortfolio.setBalance(10000); // or anther option to updateBalanvc(10000)

		date.setMonth(11);
		date.setDate(15);
		date.setYear(114);

		//Calendar cal = Calendar.getInstance();
		//cal.set (2014, 11, 15);
		//Date date = cal.getTime();

		Stock stock1 = new Stock ("PIH",10, 8.5f,date);
		Stock stock2 = new Stock ("AAL",30,25.5f,date);
		Stock stock3 = new Stock ("CAAS",20,15.5f,date);


		myPortfolio.addStock(stock1);
		myPortfolio.addStock(stock2);
		myPortfolio.addStock(stock3);

		myPortfolio.buyStock("PIH", 20);
		myPortfolio.buyStock("AAL", 30);
		myPortfolio.buyStock("CAAS",40);

		myPortfolio.sellStock("AAL", -1);
		myPortfolio.removeStock("CAAS");

		//myPortfolio.setTitle("<p><center><div style=background-color:pink><h1> Exercise 8 portfolio</h1></div style=background-color:pink></center></p>");
		myPortfolio.setTitle("Exercise 8 portfolio");

		return myPortfolio;
	}
}
