package com.example.express_dena.asyn;


import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


@Component
public class MessageQueue {
    private BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

    public String take(){
        try{
            return queue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void offer(String res){
        queue.offer(res);
    }
}
