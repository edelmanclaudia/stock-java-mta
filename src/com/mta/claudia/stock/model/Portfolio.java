package com.mta.claudia.stock.model;

import com.mta.claudia.stock.exception.BalanceException;
import com.mta.claudia.stock.exception.PortfolioFullException;
import com.mta.claudia.stock.exception.StockAlreadyExistsException;
import com.mta.claudia.stock.exception.StockNotExistException;

/**
 * An instance of this class represents a portfoilio of stocks.
 * @author Claudia Edelman
 * @since 2014
 * date 2/12/2014
 */

public class Portfolio {
	private final static int MAX_PORTFOLIO_SIZE = 5;
	public static enum ALGO_RECOMMENDATION{DO_NOTHING,BUY,SELL};

	private String title;
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
		setStocksStatus(new StockStatus[MAX_PORTFOLIO_SIZE]);
	}

	/**
	 * constructor
	 * @param portfolio
	 */

	public Portfolio(String title,StockStatus[] stockStatus,int portfolioSize,float balance){
		setTitle(title);
		setStocksStatus(stockStatus);
		setPortfolioSize(portfolioSize);
		setBalance(balance);
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
			stocksStatus[i] = new StockStatus(portfolio.getStocksStatus()[i]);
		}
	}

	/**
	 * Adds stock to the stocks arrays the sum.
	 * a limitation of num of stocks of max.
	 *
	 * @param stock the addStock to add to this stock to the array.
	 * portfolioSize count the num of stocks in the array.
	 * 
	 */

	public void addStock(Stock stock) throws Exception {

		for(int i = 0; i < portfolioSize; i++)
		{
			if(stock.getStockSymbol().equals(stocksStatus[i].getStockSymbol()) )
			{
				System.out.println("You own this kind of stock , therefor no need to add the stock!");
				throw new StockAlreadyExistsException(stock.getStockSymbol());
			}
		}

		if(portfolioSize < MAX_PORTFOLIO_SIZE )
		{
			stocksStatus[portfolioSize] = new StockStatus(stock.getStockSymbol(),stock.getBid(),stock.getAsk(),stock.getDate(),ALGO_RECOMMENDATION.DO_NOTHING,0);
			portfolioSize++;
		}
		else
		{
			System.out.println("Cant add new stock, portfolio can have only " + portfolioSize + " stocks");
			throw new PortfolioFullException(getPortfolioSize());
		}
	}

	/**
	 * Remove stock to from stocks array.
	 * reduce the portfolio size.
	 *
	 * @param stock the removeStock from this stocks array.
	 * delete the stock by the index place and moves the other stock to the left 
	 * @throws StockNotExistException 
	 */

	public void removeStock(String stockSymbol) throws StockNotExistException{
		for(int index = 0; index < portfolioSize; index++)
		{
			if(stockSymbol.equals(this.stocksStatus[index].getStockSymbol()))
			{
				sellStock(this.stocksStatus[index].getStockSymbol(),this.stocksStatus[index].getStockQuantity());

				this.stocksStatus[index] = null;

				if(index == portfolioSize)
					this.portfolioSize--;

				else 
				{
					this.portfolioSize--;
					for(int i = index; i <= portfolioSize-1; i++)
					{
						this.stocksStatus[i] = this.stocksStatus[i+1];
					}
				}

				System.out.println("The stock " +stockSymbol+ " was removed sucessfully");
			}
		}
		System.out.println("The stock " +stockSymbol+ " dosent exist in the portfolio");
		throw new StockNotExistException(stockSymbol);
	}	

	/**
	 * Buy stock to from bool val if stock was found true else false.
	 * reduce the portfolio size.
	 *
	 * @param stock the buyStock from this stocks array.
	 * only buy the stock 
	 * @throws BalanceException 
	 */

	public void buyStock(String symbol,int quantity) throws BalanceException{
		for(int i = 0; i < portfolioSize; i++)
		{
			if(this.stocksStatus[i].getStockSymbol().equals(symbol))
			{
				if(quantity == -1)
				{
					quantity = (int)(getBalance() /(stocksStatus[i].getAsk()));
					this.stocksStatus[i].setStockQuantity(stocksStatus[i].getStockQuantity()+quantity);
					updateBalance(-(quantity * this.stocksStatus[i].getAsk()));
					System.out.println(this.stocksStatus[i].getStockQuantity() + " Stocks of " +symbol+ " were bought"); 
				}

				else if(quantity > 0)
				{
					if(quantity * this.stocksStatus[i].getAsk() <= getBalance())
					{	
						this.stocksStatus[i].setStockQuantity(this.stocksStatus[i].getStockQuantity() + quantity);
						updateBalance(-(quantity * this.stocksStatus[i].getAsk()));
						System.out.println(this.stocksStatus[i].getStockQuantity() + " Stocks of " +symbol+ " were bought"); 
					}

					else
					{
						System.out.println("Not enough balance to complete purchase");
						throw new BalanceException(getBalance());
					}

				}
				else //lower then -1 
				{
					System.out.println("Cant delete a negative number of quantity");
				}
			}
		}
	}

	/**
	 * Sell stock to from bool val if stock was found true else false.
	 * reduce the portfolio size.
	 *
	 * @param stock the sellStock from this stocks array.
	 * only sell the stock ,dosent remove! 
	 */

	public void sellStock(String symbol,int quantity){
		for(int i = 0; i < portfolioSize; i++)
		{
			if(this.stocksStatus[i].getStockSymbol().equals(symbol))
			{
				if(quantity == -1)
				{
					updateBalance(stocksStatus[i].getStockQuantity() * this.stocksStatus[i].getBid());
					System.out.println(stocksStatus[i].getStockQuantity() + " Stocks of " +symbol+ " were sold"); 
					this.stocksStatus[i].setStockQuantity(0);
				}

				else if(quantity > stocksStatus[i].getStockQuantity())
					System.out.println("Not enough stocks to sell");

				else if(quantity > 0)
				{
					this.stocksStatus[i].setStockQuantity(this.stocksStatus[i].getStockQuantity() - quantity);
					updateBalance(quantity * this.stocksStatus[i].getBid());
					System.out.println(quantity + " Stocks of " +symbol+ " were sold"); 
				}

				else //lower then -1 
				{
					System.out.println("Cant delete a negative number of quantity");
				}
			}
		}
	}

	/**
	 * Returns the total value of stocks in portfolio.	
	 * @param runs on the stocks array and add the value to the total 
	 * * @return total value stock.
	 */

	public float getStocksValue(Stock stocks[]){
		float totalValueStocks = 0;

		for(int i = 0; i < portfolioSize; i++){
			totalValueStocks += stocksStatus[i].getBid() * stocksStatus[i].getStockQuantity();
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
	 * @param runs on the stocks array and print the stock description
	 * * @return the getHtmlString.
	 */

	public String getHtmlString(){
		String getHtmlString = "<p><center><div style=background-color:FFCCFF><h1>";
		getHtmlString += getTitle() + "<br>";
		getHtmlString += "</div style=background-color:FFCCFF></center></p>";

		getHtmlString += "<b> Total Portfolio Value: </b>" + getTotalValue(stocksStatus) + "$  , <b> Total Stocks value: </b>" + getStocksValue(stocksStatus) +"$  , <b> Balance: </b>" + getBalance() + "$ <br><br>";

		getHtmlString += "<br><font color=9900CC><b>Stock Details:</b></font color=9900CC>";
		getHtmlString += "<br><font color=9900CC><b>______________</b></font color=9900CC><br><br>";


		for(int i = 0; i < portfolioSize; i++)

			getHtmlString += "<b>Stock</b> " + (i+1) + ": " +stocksStatus[i].getHtmlDescription() + " , <b>quantity</b>: " +stocksStatus[i].getStockQuantity()+ "<br><br>";

		return getHtmlString;
	}
}
