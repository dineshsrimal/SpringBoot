package com.hackerrank.stocktrade.service.impl;


import com.hackerrank.stocktrade.entity.User;
import com.hackerrank.stocktrade.exception.TradeServiceBadRequestException;
import com.hackerrank.stocktrade.exception.TradeServiceNotFoundRequestException;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.repository.TradeRepository;
import com.hackerrank.stocktrade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;


    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Override
    public Long saveTrade(Trade trade){


        if(tradeRepository.existsById(trade.getId())){
            throw  new TradeServiceBadRequestException();
        }

        com.hackerrank.stocktrade.entity.Trade tradeEntity =
                new com.hackerrank.stocktrade.entity.Trade(trade.getId(),trade.getType(), new User(trade.getUser().getId(),trade.getUser().getName()) , trade.getSymbol(),trade.getShares(),trade.getPrice(),trade.getTimestamp());
        return tradeRepository.save(tradeEntity).getId();
    }

    @Override
    public Trade findTradeById(Long id){
        Optional<com.hackerrank.stocktrade.entity.Trade> tradeOptional = tradeRepository.findById(id);
        if(tradeOptional.isPresent()){
            com.hackerrank.stocktrade.entity.Trade t  = tradeOptional.get();
            return new Trade(t.getId(),t.getType(),new com.hackerrank.stocktrade.model.User(t.getUser().getId(),t.getUser().getName()), t.getSymbol() , t.getShares() , t.getPrice() , t.getTimestamp());
        }else {
            throw new TradeServiceNotFoundRequestException();
        }

    }


    @Override
    public List<Trade> findTradeBySymbol(String symbol){
        Optional<List<com.hackerrank.stocktrade.entity.Trade>> tradeOptional = tradeRepository.getTradeBySymbol(symbol);
        if(tradeOptional.isPresent()){

            return tradeOptional.get().stream()
                    .map(t ->new Trade(t.getId(),t.getType(),new com.hackerrank.stocktrade.model.User(t.getUser().getId(),t.getUser().getName()), t.getSymbol() , t.getShares() , t.getPrice() , t.getTimestamp()) )
                    .collect(Collectors.toList());


        }else {
            throw new TradeServiceNotFoundRequestException();
        }

    }



    @Override
    public List<Trade> findTradeByUserId(Long id){
        Optional<List<com.hackerrank.stocktrade.entity.Trade>> tradeOptional = tradeRepository.getTradeByUserId(id);
        if(tradeOptional.isPresent()){

            return tradeOptional.get().stream()
                    .map(t ->new Trade(t.getId(),t.getType(),new com.hackerrank.stocktrade.model.User(t.getUser().getId(),t.getUser().getName()), t.getSymbol() , t.getShares() , t.getPrice() , t.getTimestamp()) )
                    .collect(Collectors.toList());


        }else {
            throw new TradeServiceNotFoundRequestException();
        }

    }
    @Override
    public List<Trade> findTradeByUserIdAndSymbol(Long id,String symbol){
        Optional<List<com.hackerrank.stocktrade.entity.Trade>> tradeOptional = tradeRepository.getTradeByUserIdAndSymbol(id,symbol);
        if(tradeOptional.isPresent()){

            return tradeOptional.get().stream()
                    .map(t ->new Trade(t.getId(),t.getType(),new com.hackerrank.stocktrade.model.User(t.getUser().getId(),t.getUser().getName()), t.getSymbol() , t.getShares() , t.getPrice() , t.getTimestamp()) )
                    .collect(Collectors.toList());


        }else {
            throw new TradeServiceNotFoundRequestException();
        }

    }

    @Override
    public List<Trade> findAllTrades(){
        Iterable<com.hackerrank.stocktrade.entity.Trade> trades = tradeRepository.findAll();
        if(trades.iterator().hasNext()){

            List<Trade> tradesList = new ArrayList<>();
            while (trades.iterator().hasNext()){
                com.hackerrank.stocktrade.entity.Trade t =  trades.iterator().next();
                Trade trade =  new Trade(t.getId(),t.getType(),new com.hackerrank.stocktrade.model.User(t.getUser().getId(),t.getUser().getName()), t.getSymbol() , t.getShares() , t.getPrice() , t.getTimestamp());

                tradesList.add(trade);

            }

           return tradesList;


        }else {
            throw new TradeServiceNotFoundRequestException();
        }

    }




}
