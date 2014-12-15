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
	private float balance = 0;

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

	/**
	 * update the current balance
	 * @param get an amount to add to the balance 
	 */

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

	public Portfolio(String title,Stock[] stocks,StockStatus[] stockStatus,int portfolioSize,float balance){
		setTitle(title);
		setStocks(stocks);
		setStocksStatus(stockStatus);
		setPortfolioSize(portfolioSize);
		setBalance(balance);
	}

	/**
	 * Adds stock to the stocks arrays the sum.
	 * a limitation of num of stocks of max.
	 *
	 * @param stock the addStock to add to this stock to the array.
	 * portfolioSize count the num of stocks in the array.
	 * 
	 */

	public void addStock(Stock stock,int quantity){
		if(portfolioSize < MAX_PORTFOLIO_SIZE)
		{
			stocks[portfolioSize] = stock;
			stocksStatus[portfolioSize] = new StockStatus(stock.getStockSymbol(),stock.getBid(),stock.getAsk(),stock.getDate(),ALGO_RECOMMENDATION.DO_NOTHING, quantity);
			portfolioSize++;
		}
		else
			System.out.println("Cant add new stock, portfolio can have only " + portfolioSize + " stocks");
	}

	/**
	 * Remove stock to from stocks array.
	 * reduce the portfolio size.
	 *
	 * @param stock the removeStock from this stocks array.
	 * delete the stock by the index place and moves the other stock to the left 
	 */

	public boolean removeStock(String stockSymbol){
		for(int index = 0; index < portfolioSize; index++)
		{
			if(stockSymbol.equals(this.stocks[index].getStockSymbol()))
			{
				sellStock(this.stocks[index].getStockSymbol(),this.stocksStatus[index].getStockQuantity());

				this.stocks[index] = null;

				if(index == portfolioSize)
					this.portfolioSize--;

				else 
				{
					this.portfolioSize--;
					for(int i = index; i <= portfolioSize-1; i++)
					{
						this.stocks[i] = this.stocks[i+1];
						this.stocksStatus[i] = this.stocksStatus[i+1];
					}
				}

				System.out.println("The stock " +stockSymbol+ "was removed sucessfully");
				return true;
			}
		}
		System.out.println("The stock " +stockSymbol+ " dosent exist in the portfolio");

		return false;
	}	

	/**
	 * Sell stock to from bool val if stock was found true else false.
	 * reduce the portfolio size.
	 *
	 * @param stock the sellStock from this stocks array.
	 * only sell the stock ,dosent remove! 
	 */

	public boolean sellStock(String symbol,int quantity){
		for(int i = 0; i < portfolioSize; i++)
		{
			if(this.stocks[i].getStockSymbol().equals(symbol))
			{
				if(quantity == -1 || quantity > stocksStatus[i].getStockQuantity())
				{
					updateBalance(stocksStatus[i].getStockQuantity() * this.stocksStatus[i].getCurrentBid());
					this.stocksStatus[i].setStockQuantity(0);
					System.out.println(stocksStatus[i].getStockQuantity() + " Stocks of " +symbol+ " were sold"); 
				}

				else if(quantity > 0)
				{
					this.stocksStatus[i].setStockQuantity(this.stocksStatus[i].getStockQuantity() - quantity);
					updateBalance(quantity * this.stocksStatus[i].getCurrentBid());
					System.out.println(quantity + " Stocks of " +symbol+ " were sold"); 
				}

				else //lower then -1 
				{
					System.out.println("Cant delete a negative number of quantity");
					return false;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Buy stock to from bool val if stock was found true else false.
	 * reduce the portfolio size.
	 *
	 * @param stock the buyStock from this stocks array.
	 * only buy the stock 
	 */

	public boolean buyStock(String symbol,int quantity){
		for(int i = 0; i < portfolioSize; i++)
		{
			if(this.stocks[i].getStockSymbol().equals(symbol))
			{
				if(quantity == -1)
				{
					//float res = getBalance() /(stocksStatus[i].getCurrentAsk());
					quantity = (int)(getBalance() /(stocksStatus[i].getCurrentAsk()))
							;
					this.stocksStatus[i].stockQuantity +=  quantity;
					updateBalance(-(quantity * this.stocksStatus[i].getCurrentAsk()));
					System.out.println(this.stocksStatus[i].getStockQuantity() + " Stocks of " +symbol+ " were bought"); 
				}

				else if(quantity > 0)
				{
					if(quantity * this.stocksStatus[i].getCurrentAsk() <= getBalance())
					{	
						this.stocksStatus[i].setStockQuantity(this.stocksStatus[i].getStockQuantity() + quantity);
						updateBalance(-(quantity * this.stocksStatus[i].getCurrentAsk()));
						System.out.println(this.stocksStatus[i].getStockQuantity() + " Stocks of " +symbol+ " were bought"); 
					}
					
					else
						System.out.println("You do not have enough money to buy Stocks of " +symbol+ " were bought"); 

				}
				else //lower then -1 
				{
					System.out.println("Cant delete a negative number of quantity");
					return false;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns the total value of stocks in portfolio.
	 * 
	 *
	 * @param runs on the stocks array and add the value to the total 
	 * * @return total value stock.
	 */

	public float getStocksValue(Stock stocks[]){
		float totalValueStocks = 0;

		for(int i = 0; i < portfolioSize; i++){
			totalValueStocks += stocksStatus[i].getCurrentBid() * stocksStatus[i].stockQuantity;
		}
		return totalValueStocks;
	}

	/**
	 * Returns sum of  total value of stocks & balance in portfolio.
	 * 
	 *
	 * @param runs on the stocks array and add the value to the total and add the portfolio balance
	 * * @return the get total value.
	 */

	public float getTotalValue(Stock stocks[]){
		float sumTotalValueStock =	getStocksValue(stocks) + getBalance();

		return sumTotalValueStock;
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

		getHtmlString += "<b> Total Portfolio Value: </b>" + getStocksValue(stocks) + "$  , <b> Total Stocks value: </b>" + getTotalValue(stocks)+"$  , <b> Balance: </b>" + getBalance() + "$ <br><br>";

		getHtmlString += "<br> <b>Stock Details</b> <br>";
		getHtmlString += "---------------------------------- <br>";
		for(int i = 0; i < portfolioSize; i++)

			getHtmlString += "<b>Stock</b> " + (i+1) + ": " +stocks[i].getHtmlDescription() + " , " +stocksStatus[i].getStockQuantity()+ "<br><br>";

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

		public StockStatus(String symbol, float bid, float ask, Date date, ALGO_RECOMMENDATION recom, int stockQuantity){
			this.symbol = symbol;
			this.currentBid = bid;
			this.currentAsk = ask;
			this.date = date;
			this.recommendation = recom;
			this.stockQuantity = stockQuantity;
		}

		/**
		 * copy constructor
		 * @param StockStatus
		 */

		public StockStatus(StockStatus stockStatus){
			this.symbol = stockStatus.symbol;
			this.currentAsk = stockStatus.currentAsk;
			this.currentBid = stockStatus.currentBid;
			this.date = new Date(stockStatus.date.getDate());
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
