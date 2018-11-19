package org.jana.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisherImpl implements MessagePublisher {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic topic;

    public MessagePublisherImpl() {
    }

    public MessagePublisherImpl(RedisTemplate<String, Object> template, ChannelTopic topic) {
        this.redisTemplate = template;
        this.topic = topic;
    }


    @Override
    public void publish(String message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }

}
