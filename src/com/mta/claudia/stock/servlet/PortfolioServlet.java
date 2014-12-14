package com.mta.claudia.stock.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.claudia.stock.model.Portfolio;
import com.mta.claudia.stock.model.Stock;
import com.mta.claudia.stock.service.PortfolioService;

/**
* An instance of this class represents a Portfolio Servlet.
* @author Claudia Edelman
* @since 2014
* date 2/12/2014
*/

public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		resp.setContentType("text/html");
		
		PortfolioService portfolioService = new PortfolioService(); 
		Portfolio portfolio = portfolioService.getPortfolio(); 
		Stock[] stocks = portfolio.getStocks();

		Portfolio portfolio2 = new Portfolio(portfolio); 

		resp.getWriter().println(portfolio.getHtmlString() + "<br>");
		portfolio2.setTitle("<h1>Portfolio 2#</h1>");
		resp.getWriter().println(portfolio2.getHtmlString() + "<br>");
		
		//portfolio.removeStock(0);
		resp.getWriter().println("<h1><font color=darkblue> After Remove Stock: </font><h1>");
		resp.getWriter().println("-----------------------------------------------------");
		resp.getWriter().println(portfolio.getHtmlString() + "<br>");
		resp.getWriter().println(portfolio2.getHtmlString() + "<br>");
		
		portfolio2.getStocks()[2].setBid(55.55f);
		resp.getWriter().println("<h1><font color=darkblue> After Change of Stock Bid: </font><h1>");
		resp.getWriter().println("-----------------------------------------------------");
		resp.getWriter().println(portfolio.getHtmlString() + "<br>");
		resp.getWriter().println(portfolio2.getHtmlString() + "<br>");

	}
}
