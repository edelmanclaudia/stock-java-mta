package com.mta.claudia.stock.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		Portfolio portfolio = portfolioService.getPortfolio(); 

	//	Portfolio portfolio2 = new Portfolio(portfolio); 

		resp.getWriter().println(portfolio.getHtmlString() + "<br>");
	//	portfolio2.setTitle("<h1>Portfolio 2#</h1>");
	//	resp.getWriter().println(portfolio2.getHtmlString() + "<br>");

	}
}
