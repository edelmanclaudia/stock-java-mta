package com.mta.claudia.stock.model;

import java.util.Date;

import com.mta.claudia.stock.model.Portfolio.ALGO_RECOMMENDATION;

/**
 * An instance of this class represents a Stock with all of its characters.
 * @author Claudia Edelman
 * @since 2014
 * date 27/12/2014
 */

public class StockStatus extends Stock {

	private ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;

	//getters
	public ALGO_RECOMMENDATION getRecommendation() {
		return recommendation;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	//setters
	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}	

	/**
	 * constructor
	 * @param StockStatus
	 */

	public StockStatus(Stock stock){
		super(stock);
		this.recommendation = ALGO_RECOMMENDATION.DO_NOTHING;
		this.stockQuantity = 0;
	}

	/**
	 * constructor
	 * @param StockStatus
	 */

	public StockStatus(String symbol, float bid, float ask, Date date, ALGO_RECOMMENDATION recom, int stockQuantity){
		this.stockSymbol = symbol;
		this.bid = bid;
		this.ask = ask;
		this.date = date;
		this.recommendation = recom;
		this.stockQuantity = stockQuantity;
	}

	/**
	 * copy constructor
	 * @param StockStatus
	 */

	public StockStatus(StockStatus stockStatus){
		this.stockSymbol = stockStatus.stockSymbol;
		this.ask = stockStatus.ask;
		this.bid = stockStatus.bid;
		this.date = new Date(stockStatus.date.getTime());
		this.recommendation = stockStatus.recommendation;
		this.stockQuantity = stockStatus.stockQuantity;
	}
}
