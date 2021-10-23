package com.kafkastreamingdemo.kafkatwitterconsumerdemo.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkastreamingdemo.kafkatwitterconsumerdemo.entity.Record;
import com.kafkastreamingdemo.kafkatwitterconsumerdemo.service.TwitterEventService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TwitterEventConsumer {

    @Autowired
    private TwitterEventService twitterEventService;

    @KafkaListener( id = "android-twitter-events", topicPartitions = {
        @TopicPartition( topic = "twitter-events4", partitions = { "0" } )
    } )
    public void onAndroidMessage(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        log.info( "record is :: {}", consumerRecord );
        twitterEventService.saveEvents( convert( consumerRecord ) );
    }

    @KafkaListener( id = "other-twitter-events", topicPartitions = {
        @TopicPartition( topic = "twitter-events4", partitionOffsets ={
            @PartitionOffset( initialOffset = "0", partition = "1")
        } )
    } )
    public void onOtherMessage(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        log.info( "record is :: {}", consumerRecord );
    }

    private Record convert(ConsumerRecord<String, String> consumerRecord) throws JsonProcessingException {
        return new ObjectMapper().readValue( consumerRecord.value(), Record.class );
    }
}
