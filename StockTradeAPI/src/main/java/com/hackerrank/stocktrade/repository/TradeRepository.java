package com.hackerrank.stocktrade.repository;

import com.hackerrank.stocktrade.entity.Trade;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TradeRepository extends CrudRepository<Trade, Long> {

     Optional<List<Trade>> getTradeBySymbol(String symbol);

     Optional<List<Trade>> getTradeByUserId(Long userid);

     Optional<List<Trade>> getTradeByUserIdAndSymbol(Long userid, String symbol);

}
