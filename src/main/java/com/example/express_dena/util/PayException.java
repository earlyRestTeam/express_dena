package com.example.express_dena.util;

/**
 * @author :Yang Jiahong
 * @date :2019/12/13 17:19
 */
public class PayException extends RuntimeException {
    public PayException(){
        super();
    }

    public PayException(String message) {
        super(message);
    }
}
