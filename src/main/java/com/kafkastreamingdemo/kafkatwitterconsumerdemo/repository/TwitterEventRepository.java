package com.kafkastreamingdemo.kafkatwitterconsumerdemo.repository;

import com.kafkastreamingdemo.kafkatwitterconsumerdemo.entity.Record;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitterEventRepository extends MongoRepository<Record, String> {

}
