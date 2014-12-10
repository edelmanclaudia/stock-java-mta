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
		this();
		this.title = portfolio.getTitle();
		this.portfolioSize = portfolio.portfolioSize;
		
		for(int i = 0; i < portfolio.portfolioSize ; i++){
			stocks[i] = new Stock(portfolio.getStocks()[i]);
			stocksStatus[i] = new StockStatus(portfolio.getStocksStatus()[i]);
		}
	}
	
	public Portfolio(String title1,Stock[] stocks1,StockStatus[] stockStatus1,int portfolioSize1){
		setTitle(title1);
		setStocks(stocks1);
		if(stockStatus1 != null)
		{
			setStocksStatus(stockStatus1);
		}
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
	
	public void removeStock(int index){
		if(index == portfolioSize)
			this.portfolioSize--;
		else 
		{
			this.portfolioSize--;
			for(int i = index; i <= portfolioSize-1; i++)
			{
				this.stocks[i] = this.stocks[i+1];
			}
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
		String getHtmlString = getTitle() + "<br>";
		
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

		public StockStatus(){
			
		}
			
		public StockStatus(StockStatus stockStatus){
			//this(stockStatus.getSymbol(),stockStatus.getCurrentBid(),stockStatus.getCurrentAsk(),stockStatus.getDate(),stockStatus.getRecommendation(),stockStatus.getStockQuantity());
			if(this.symbol != null)
			{
				this.symbol = stockStatus.symbol;
				this.currentAsk = stockStatus.currentAsk;
				this.currentAsk = stockStatus.currentBid;
				this.date = stockStatus.date;
				this.recommendation = stockStatus.recommendation;
				this.stockQuantity = stockStatus.stockQuantity;
			}
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
