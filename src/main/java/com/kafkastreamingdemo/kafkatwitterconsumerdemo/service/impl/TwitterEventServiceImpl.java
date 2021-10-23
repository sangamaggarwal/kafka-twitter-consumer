package com.kafkastreamingdemo.kafkatwitterconsumerdemo.service.impl;

import com.kafkastreamingdemo.kafkatwitterconsumerdemo.entity.Record;
import com.kafkastreamingdemo.kafkatwitterconsumerdemo.repository.TwitterEventRepository;
import com.kafkastreamingdemo.kafkatwitterconsumerdemo.service.TwitterEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterEventServiceImpl implements TwitterEventService {

    private final TwitterEventRepository twitterEventRepository;

    @Autowired
    public TwitterEventServiceImpl(TwitterEventRepository twitterEventRepository) {
        this.twitterEventRepository = twitterEventRepository;
    }

    @Override
    public void saveEvents(Record record) {
        twitterEventRepository.save( record );
    }
}
