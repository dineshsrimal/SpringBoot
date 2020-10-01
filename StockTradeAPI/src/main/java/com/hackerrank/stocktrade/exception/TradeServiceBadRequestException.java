package com.hackerrank.stocktrade.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TradeServiceBadRequestException  extends RuntimeException{
}
