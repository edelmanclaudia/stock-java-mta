package com.mta.javacourse.service;

import java.util.Date;

import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.model.Stock;

public class PortfolioService {
	
	private Portfolio myPortfolio;
	
	public PortfolioService(){
		myPortfolio = new Portfolio();

	}
	
	public Portfolio getPortfolio(){
		
		Stock stock1 = new Stock ();
		Stock stock2 = new Stock ();
		Stock stock3 = new Stock ();
		Date date = new java.util.Date ();
		
		date.setMonth(11);
		date.setDate(15);
		date.setYear(2014);
		
		stock1.setStockSymbol("PIH");
		stock1.setAsk(12.4f);
		stock1.setBid(13.1f);
		stock1.setDate(date);
		myPortfolio.addStock(stock1);
		
		stock2.setStockSymbol("AAL");
		stock2.setAsk(5.5f);
		stock2.setBid(5.78f);
		stock2.setDate(date);
		myPortfolio.addStock(stock2);

		stock3.setStockSymbol("CAAS");
		stock3.setAsk(31.5f);
		stock3.setBid(31.2f);
		stock3.setDate(date);
		myPortfolio.addStock(stock3);
		
		return myPortfolio;
	}
}
