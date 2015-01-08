package com.mta.claudia.stock.exception;

/**
 * An exception num of stocks larger then the max portofolio size.
 * @author Claudia Edelman
 * @since 2015
 * date 8/1/2015
 */

public class PortfolioFullException extends Exception {
	
	public PortfolioFullException() {
		super("Cant add any more stocks! you have reached the max size of portfolio");
	}
}
