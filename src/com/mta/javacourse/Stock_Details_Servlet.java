package com.mta.javacourse;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Stock_Details_Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		My_Stock newStock1 = new My_Stock ();
		My_Stock newStock2 = new My_Stock ();
		My_Stock newStock3 = new My_Stock ();
		java.util.Date newDate = new java.util.Date ();
		
		newDate.setMonth(11);
		newDate.setDate(15);
		newDate.setYear(2014);
		
		newStock1.setStockSymbol("PIH");
		newStock1.setAsk(12.4f);
		newStock1.setBid(13.1f);
		newStock1.setDate(newDate);
		
		newStock2.setStockSymbol("AAL");
		newStock2.setAsk(5.5f);
		newStock2.setBid(5.78f);
		newStock2.setDate(newDate);
		
		newStock3.setStockSymbol("CAAS");
		newStock3.setAsk(31.5f);
		newStock3.setBid(31.2f);
		newStock3.setDate(newDate);

		resp.setContentType("text/html");
		
		resp.getWriter().println(newStock1.getHtmlDescription() + "<br>");
		resp.getWriter().println(newStock2.getHtmlDescription() + "<br>");
		resp.getWriter().println(newStock3.getHtmlDescription() + "<br>");

	}
}
