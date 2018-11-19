package org.jana.springdata.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

public class MessagePublisherImpl implements MessagePublisher {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private ChannelTopic channelTopic;

    public MessagePublisherImpl() {
    }

    public MessagePublisherImpl(RedisTemplate<String, Object> template, ChannelTopic topic) {
        this.redisTemplate = template;
        this.channelTopic = topic;
    }


    @Override
    public void publish(String message) {

    }

}
