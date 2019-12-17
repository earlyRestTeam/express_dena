package com.example.express_dena.util;

public class PayException extends RuntimeException {
    public PayException(){
        super();
    }

    public PayException(String message) {
        super(message);
    }
}
