package com.hackerrank.stocktrade.service;

import com.hackerrank.stocktrade.model.Trade;

import java.util.List;

public interface TradeService {

    Long saveTrade(Trade trade);

    Trade findTradeById(Long id);

    List<Trade> findTradeBySymbol(String symbol);

    List<Trade> findTradeByUserId(Long id);

    List<Trade> findTradeByUserIdAndSymbol(Long id,String symbol);

    List<Trade> findAllTrades();
}
