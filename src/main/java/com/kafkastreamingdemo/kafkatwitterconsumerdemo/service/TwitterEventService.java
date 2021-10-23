package com.kafkastreamingdemo.kafkatwitterconsumerdemo.service;

import com.kafkastreamingdemo.kafkatwitterconsumerdemo.entity.Record;

public interface TwitterEventService {

    void saveEvents(Record record);
}
