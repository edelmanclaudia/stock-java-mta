package com.mta.javacourse.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.javacourse.Stock;
import com.mta.javacourse.model.Portfolio;
import com.mta.javacourse.service.PortfolioService;

public class PortfolioServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		resp.setContentType("text/html");
		
		PortfolioService portfolioService = new PortfolioService(); 
		Portfolio portfolio = portfolioService.getPortfolio(); 
		Stock[] stocks = portfolio.getStocks();
		
		resp.getWriter().println("<b>Portfolio:</b><br><br>");
		resp.getWriter().println(stocks[0].getHtmlDescription() + "<br><br>");
		resp.getWriter().println(stocks[1].getHtmlDescription() + "<br><br>");
		resp.getWriter().println(stocks[2].getHtmlDescription() + "<br><br>");
	}
}
