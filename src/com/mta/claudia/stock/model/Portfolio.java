package com.mta.claudia.stock.model;

import java.util.Date;

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
	private float balance;
	
	//getters
	public String getTitle() {
		return title;
	}
	
	public int getPortfolioSize(){
		return portfolioSize = 0;
	}

	public Stock[] getStocks() {
		return stocks;
	}
		
	public StockStatus[] getStocksStatus() {
		return stocksStatus;
	}
	
	public float getBalance() {
		return balance;
	}
	
	//setters
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public void setStocksStatus(StockStatus[] stocksStatus) {
		this.stocksStatus = stocksStatus;
	}
	
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public void updateBalance(float amount){
		this.balance += amount;
	}
	

	/**
	* constructor
	* @param portfolio allocates instances
	*/
	
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
		this.balance = portfolio.balance;
		
		for(int i = 0; i < portfolio.portfolioSize ; i++){
			stocks[i] = new Stock(portfolio.getStocks()[i]);
			stocksStatus[i] = new StockStatus(portfolio.getStocksStatus()[i]);
		}
	}
	
	/**
	* constructor
	* @param portfolio
	*/
	
	public Portfolio(String title1,Stock[] stocks1,StockStatus[] stockStatus1,int portfolioSize1,float balance1){
		setTitle(title1);
		setStocks(stocks1);
		setStocksStatus(stockStatus1);
		setPortfolioSize(portfolioSize1);
		setBalance(balance1);
	}
	
	//public void updateStockStatus(Stock stock,StockStatus stockStatus){
	//	stockStatus.setCurrentAsk(stock.getAsk());
	//	stockStatus.setCurrentBid(stock.getBid());
	//	stockStatus.setDate(stock.getDate());
	//	stockStatus.setStockQuantity(0);
	//	stockStatus.setSymbol(stock.getStockSymbol());
		//stockStatus.setRecommendation(ALGO_RECOMMENDATION.DO_NOTHING);
	//}
	
		
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
			//updateStockStatus(stock,stockStatus);
			stocksStatus[portfolioSize] = new StockStatus(stock.getStockSymbol(),stock.getBid(),stock.getAsk(),stock.getDate(),ALGO_RECOMMENDATION.DO_NOTHING, 0);
			portfolioSize++;
		}
		else
		{
			System.out.println("Cant add new stock, portfolio can have only " + portfolioSize + " stocks");
		}
	}
	
	/**
	* Remove stock to from stocks array.
	* reduce the portfolio size.
	*
	* @param stock the removeStock from this stocks array.
	* delete the stock by the index place and moves the other stock to the left 
	*/
	/*
	public boolean removeStock(int index){
		this.stocks[index] = null;

		if(index == portfolioSize)
			this.portfolioSize--;
		else 
		{
			this.portfolioSize--;
			for(int i = index; i <= portfolioSize-1; i++)
			{
				this.stocks[i] = this.stocks[i+1];
				//add remove stock status
				this.stocksStatus[i] = this.stocksStatus[i+1];
			}
		}
		
		return false;
	}	
	
	public boolean sellStock(String symbol,int quantity){
		if(quantity == -1)
		{
			if(this.stocks)
			updateBalance()
		}
		else if(quantity > 0)
		{
			
		}
		else //lower then -1 
	}
	
	public bool buyStock(String symbol,int quantity){
		
	}
	
	*/
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

	/**
	* An instance of this class represents the stock status.
	* @author Claudia Edelman
	* @since 2014
	* date 2/12/2014
	*/
	
	private static enum ALGO_RECOMMENDATION{DO_NOTHING,BUY,SELL};

	public class StockStatus {
		
		private String symbol;
		private float currentBid , currentAsk;
		private Date date;
		private ALGO_RECOMMENDATION recommendation;
		private int stockQuantity;
		
		/**
		* constructor
		* @param StockStatus
		*/
		
		public StockStatus(String string, float cBid, float cAsk, Date date1, ALGO_RECOMMENDATION recom, int stockQ){
			symbol = string;
			currentBid = cBid;
			currentAsk = cAsk;
			date = date1;
			recommendation = recom;
			stockQuantity = stockQ;
		}
		
		/**
		* copy constructor
		* @param StockStatus
		*/
			
		public StockStatus(StockStatus stockStatus){
				this.symbol = stockStatus.symbol;
				this.currentAsk = stockStatus.currentAsk;
				this.currentAsk = stockStatus.currentBid;
				this.date = new Date(stockStatus.date.getTime());
				this.recommendation = stockStatus.recommendation;
				this.stockQuantity = stockStatus.stockQuantity;
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
		
		public ALGO_RECOMMENDATION getRecommendation() {
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
		
		public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
			this.recommendation = recommendation;
		}
		
		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity = stockQuantity;
		}		
	}
}
