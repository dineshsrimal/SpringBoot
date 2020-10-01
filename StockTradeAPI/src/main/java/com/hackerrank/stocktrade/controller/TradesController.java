package com.hackerrank.stocktrade.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerrank.stocktrade.model.Trade;

import com.hackerrank.stocktrade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Validated
@RestController
@RequestMapping(value = "/trades")
public class TradesController {


    @Autowired
    private TradeService tradeService;


    @Autowired

    private ObjectMapper objectMapper;


    @PostMapping
    public ResponseEntity<Long> createTrade(@RequestBody Trade trade){
        return new ResponseEntity<Long>(tradeService.saveTrade(trade), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Trade> findTradeById(@PathVariable Long id){
        return new ResponseEntity<Trade>(tradeService.findTradeById(id), HttpStatus.OK);

    }


    @GetMapping("/stocks/{stock}")
    public ResponseEntity<List<Trade>> findAllTradesByStockSymbol(@PathVariable String stock){
        return new ResponseEntity<List<Trade>>(tradeService.findTradeBySymbol(stock), HttpStatus.OK);
    }


    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Trade>> findAllTradesByUserId(@PathVariable Long userId){
        return new ResponseEntity<List<Trade>>(tradeService.findTradeByUserId(userId), HttpStatus.OK);
    }


    @GetMapping("/users/{userId}/stocks/{stock}")
    public ResponseEntity<List<Trade>> findAllTradesByUserIdAndStockSymbol(@PathVariable String stock , @PathVariable Long userId){
        return new ResponseEntity<List<Trade>>(tradeService.findTradeByUserIdAndSymbol(userId,stock), HttpStatus.OK);
    }



    @GetMapping()
    public ResponseEntity<List<Trade>> findAllTrades(){
        return new ResponseEntity<List<Trade>>(tradeService.findAllTrades(), HttpStatus.OK);
    }





}
