package com.mta.claudia.stock.exception;

/**
 * An exception of trying to add a stock that already exists.
 * @author Claudia Edelman
 * @since 2015
 * date 8/1/2015
 */

public class StockAlreadyExistsException extends Exception {
	
	public StockAlreadyExistsException() {
		super("Sorry,stock already exist in portfolio");
		
	}
}
