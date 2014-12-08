package com.mta.claudia.stock.model;

import java.util.Date;
import java.util.Date;

import com.google.appengine.api.socket.SocketServicePb.SetSocketOptionsReply;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
* An instance of this class represents a portfoilio of stocks.
* @author Claudia Edelman
* @since 2014
* date 2/12/2014
*/

public class Portfolio {
	private final static int MAX_PORTFOLIO_SIZE = 5;

	private String title;
	private Stock[] stocks;
	private StockStatus[] stocksStatus;
	private int portfolioSize = 0; 
	
	

	public String getTitle() {
		return title;
	}
	
	public int getPortfolioSize(){
		return portfolioSize = 0;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}
	public Portfolio(){
		stocks = new Stock[MAX_PORTFOLIO_SIZE];
		setStocksStatus(new StockStatus[MAX_PORTFOLIO_SIZE]);
	}
	
	/**
	* copy constructor
	* @param portfolio
	*/
	
	public Portfolio(Portfolio portfolio){
		portfolio.getTitle();
		portfolio.getPortfolioSize();
		
		for(int i = 0; i < MAX_PORTFOLIO_SIZE ; i++){
			stocks[i] = portfolio.getStocks()[i];
			stocksStatus[i] = portfolio.getStocksStatus()[i];
		}
	}
	
	public Portfolio(String title1,Stock[] stocks1,StockStatus[] stockStatus1,int portfolioSize1){
		setTitle(title1);
		setStocks(stocks1);
		setStocksStatus(stockStatus1);
		setPortfolioSize(portfolioSize1);
	}
		
	/**
	* Adds stock to the stocks arrays the sum.
	* a limitation of num of stocks of max.
	*
	* @param stock the addStock to add to this stock to the array.
	* portfolioSize count the num of stocks in the array.
	*/
	
	public void addStock(Stock stock){
		if(portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			stocks[portfolioSize] = stock;
			portfolioSize++;
		}
	}
	
	/**
	* Returns the stocks array of this portfoilio.
	*
	* @return the stocks of this portfolio.
	*/
	
	public Stock[] getStocks() {
		return stocks;
	}
	
	/**
	* Returns the description portfolio.
	* 
	*
	* @param runs on the stocks array and print the stock description
	* * @return the getHtmlString.
	*/
	
	public String getHtmlString(){
		String getHtmlString = " <h1>Portfolio: </h1> ";
		
		for(int i = 0; i < portfolioSize; i++)
			getHtmlString += "<b>Stock</b> " + (i+1) + ": " +stocks[i].getHtmlDescription() +"<br><br>";

		return getHtmlString;
	}
	
	public StockStatus[] getStocksStatus() {
		return stocksStatus;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stocksStatus = stocksStatus;
	}

	/**
	* An instance of this class represents the stock status.
	* @author Claudia Edelman
	* @since 2014
	* date 2/12/2014
	*/
	
	public class StockStatus {
		public final static int DO_NOTHING = 0;
		public final static int BUY = 1;
		public final static int SELL = 2;
		
		private String symbol;
		private float currentBid , currentAsk;
		private Date date;
		private int recommendation;
		private int stockQuantity;
		
		public StockStatus(StockStatus stockStatus){
			//this(stockStatus.getSymbol(),stockStatus.getCurrentBid(),stockStatus.getCurrentAsk(),stockStatus.getDate(),stockStatus.getRecommendation(),stockStatus.getStockQuantity());
			symbol = stockStatus.symbol;
			currentAsk = stockStatus.currentAsk;
			currentAsk = stockStatus.currentBid;
			date = stockStatus.date;
			recommendation = stockStatus.recommendation;
			stockQuantity = stockStatus.stockQuantity;
		}
		
		//getters : 
		public String getSymbol() {
			return symbol;
		}
		
		public float getCurrentBid() {
			return currentBid;
		}
		
		public float getCurrentAsk() {
			return currentAsk;
		}
		
		public Date getDate() {
			return date;
		}
		
		public int getRecommendation() {
			return recommendation;
		}
		
		public int getStockQuantity() {
			return stockQuantity;
		}
		
		//setters:
		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}
	
		public void setCurrentBid(float currentBid) {
			this.currentBid = currentBid;
		}
		
		public void setCurrentAsk(float currentAsk) {
			this.currentAsk = currentAsk;
		}
		
		public void setDate(Date date) {
			this.date = date;
		}
		
		public void setRecommendation(int recommendation) {
			this.recommendation = recommendation;
		}
		
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}		
	}
}
