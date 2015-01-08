package com.mta.claudia.stock.exception;

/**
 * An exception of stocks that dosent exists.
 * @author Claudia Edelman
 * @since 2015
 * date 8/1/2015
 */

public class StockNotExistException extends Exception {

	public StockNotExistException() {
		super("Stock dosn't exists!");	
	}
}
