package org.jana.springdata.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageSubscriber implements MessageListener {

    static List<String> messages = new ArrayList<>();

    @Override
    public void onMessage(Message message, byte[] bytes) {
        messages.add(message.toString());
        System.out.println("message = " + message);
    }

}
