package com.test.messaging.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.messaging.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

}
