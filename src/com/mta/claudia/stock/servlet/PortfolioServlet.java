package com.mta.claudia.stock.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mta.claudia.stock.dto.PortfolioDto;
import com.mta.claudia.stock.dto.PortfolioTotalStatus;
import com.mta.claudia.stock.model.StockStatus;


public class PortfolioServlet extends AbstractAlgoServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		
		PortfolioTotalStatus[] totalStatus = portfolioService.getPortfolioTotalStatus();
		StockStatus[] stockStatusArray = portfolioService.getPortfolio().getStocks();
		List<StockStatus> stockStatusList = new ArrayList<>();
		for (StockStatus ss : stockStatusArray) {
			if(ss != null)
				stockStatusList.add(ss);
		}
		
		PortfolioDto pDto = new PortfolioDto();
		pDto.setTitle(portfolioService.getPortfolio().getTitle());
		pDto.setTotalStatus(totalStatus);
		pDto.setStockTable(stockStatusList);
		String bla = withNullObjects().toJson(pDto);
		resp.getWriter().print(bla);
	}
}