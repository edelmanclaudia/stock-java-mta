package com.mta.javacourse.model;

import java.util.Date;
import java.util.Date;

import com.mta.javacourse.Stock;

public class Portfolio {
	private final static int MAX_PORTFOLIO_SIZE = 5;

	private Stock[] stocks;
	private int portfolioSize = 0; 
	
	
	public Portfolio(){
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
	}
	
	public void addStock(Stock stock){
		if(portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}

	}
	
	public Stock[] getStocks() {
		return stocks;
	}
	

	public class StockStatus {
		public final static int DO_NOTHING = 0;
		public final static int BUY = 1;
		public final static int SELL = 2;
		
		private String symbol;
		private float currentBid , currentAsk;
		private Date date;
		private int recommendation;
		private int stockQuantity;
		private StockStatus[] stocksStatus;
	
	}
	
	public int i = 0;

	public String getHtmlPortfolioDescription(){
		String getHtmlPortfolioDescription = " <h1>Portfolio: </h1> ";
		
		for(i = 0; i < portfolioSize; i++)
			getHtmlPortfolioDescription += "<b>Stock</b> " +(i+1)+ ": " +stocks[i].getHtmlDescription() +"<br>";

		return getHtmlPortfolioDescription;
	}
}
