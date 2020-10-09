package com.dineshwork.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dineshwork.entity.Trade;

@RestController
public class TradeController {
	
	@RequestMapping(method=RequestMethod.POST, value = "/trades")
	public int addTrade(@RequestBody Trade trade) {
		
		return 400;
	}
}
