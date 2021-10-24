package com.javatechie.tx.exceptions;

public class InSufficientAmountException extends RuntimeException {
    public InSufficientAmountException(String message){
        super(message);
    }
}
