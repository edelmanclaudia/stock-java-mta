package com.mta.claudia.stock.exception;

/**
 * An exception of dviation of balance .
 * @author Claudia Edelman
 * @since 2015
 * date 8/1/2015
 */

public class BalanceException extends Exception {
	
	public BalanceException() {
		super("Not enough balance to complete purchase");
	}
}
