package com.mta.claudia.stock.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.claudia.stock.exception.BalanceException;
import com.mta.claudia.stock.exception.PortfolioFullException;
import com.mta.claudia.stock.exception.StockAlreadyExistsException;
import com.mta.claudia.stock.exception.StockNotExistException;
import com.mta.claudia.stock.model.Portfolio;
import com.mta.claudia.stock.service.PortfolioService;

/**
 * An instance of this class represents a Portfolio Servlet.
 * @author Claudia Edelman
 * @since 2014
 * date 2/12/2014
 */

@SuppressWarnings("serial")
public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		resp.setContentType("text/html");

		PortfolioService portfolioService = new PortfolioService(); 
		
		Portfolio portfolio;
		try {
			portfolio = portfolioService.getPortfolio();
			resp.getWriter().println(portfolio.getHtmlString() + "<br>");
		} catch (BalanceException e1) {
			 resp.getWriter().println(e1.getMessage());
		} catch (PortfolioFullException e2) {
			 resp.getWriter().println(e2.getMessage());
		} catch (StockAlreadyExistsException e3) {
			 resp.getWriter().println(e3.getMessage());
		} catch (StockNotExistException e4) {
			 resp.getWriter().println(e4.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
