package com.barbershop.barbershop.api.exceptions.services;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String message){
        super(message);
    }
}
