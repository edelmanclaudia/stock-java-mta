package com.mta.javacourse;

import java.io.IOException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Stock_java_mtaServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html");
		
		int angle,hypotenuse,Radius = 50;
		double base,exp;
		
		hypotenuse = 50;
		angle = 30;
		base = 20;
		exp = 13;
		
		double area = Math.PI * Radius * Radius;
		double ridian = angle* Math.PI / 180;
		double opposite =  Math.sin(ridian) * hypotenuse;
		double powerCal = Math.pow(base, exp);
		
		String line1 = new String("calculation 1: Area of circle with radius 50 is "+area+ " square-cm");
		String line2 = new String("calculation 2: Length of opposite where angle B is 30 degrees and Hypotenuse length is 50 cm is "+opposite+" cm");
		String line3 = new String("calculation 3: Power of 20 with exp of 13 is "+powerCal);
		
		String resultStr = line1 + "<br>" + line2 + "<br>" +line3;
		
		resp.getWriter().println(resultStr);
		
	}
}
