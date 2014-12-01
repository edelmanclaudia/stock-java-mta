package com.mta.claudia.stock.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.claudia.stock.model.Portfolio;
import com.mta.claudia.stock.model.Stock;
import com.mta.claudia.stock.service.PortfolioService;

public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		resp.setContentType("text/html");
		
		PortfolioService portfolioService = new PortfolioService(); 
		Portfolio portfolio = portfolioService.getPortfolio(); 
		
		resp.getWriter().println(portfolio.getHtmlPortfolioDescription() + "<br><br>");

	}
}
