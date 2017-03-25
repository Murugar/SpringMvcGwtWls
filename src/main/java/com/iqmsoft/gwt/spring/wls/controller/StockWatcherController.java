package com.iqmsoft.gwt.spring.wls.controller;

import static com.iqmsoft.gwt.spring.wls.url.URLConstants.JSON_RANDOMIZE;
import static com.iqmsoft.gwt.spring.wls.url.URLConstants.JSON_STOCK_PRICES;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iqmsoft.gwt.spring.wls.domain.StockDataDto;
import com.iqmsoft.gwt.spring.wls.service.JsonRandomizeService;
import com.iqmsoft.gwt.spring.wls.service.JsonStockDataService;

@Controller
public class StockWatcherController
{
	private JsonStockDataService jsonStockDataService;
	private JsonRandomizeService jsonRandomizeService;

	@RequestMapping(value = "**/" + JSON_STOCK_PRICES, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<StockDataDto> getStocks(@RequestParam("q") String rawSymbols)
	{
		return this.jsonStockDataService.getStockDataFromSymboles(rawSymbols);
	}

	@RequestMapping(value = "**/" + JSON_RANDOMIZE, method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Integer randomize()
	{
		return this.jsonRandomizeService.getRandomNumber();
	}

	public void setJsonStockDataService(JsonStockDataService stockDataService)
	{
		this.jsonStockDataService = stockDataService;
	}

	public void setJsonRandomizeService(JsonRandomizeService jsonRandomizeService)
	{
		this.jsonRandomizeService = jsonRandomizeService;
	}

}
