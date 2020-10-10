package com.test.messaging.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.test.messaging.model.Message;
import com.test.messaging.model.MessageDetails;

@Service
public class MessageService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Message> findAllMessages()
	{
		List<Message> messages = mongoTemplate.findAll(Message.class);
		return messages;
	}
	
	public Message createMessage(Message msg)
	{
		Date currentDate=new Date();
		long finalTime=currentDate.getTime();

		long msgLife=msg.getMessageLife();
		switch(msg.getMessageLifeUnit())
		{
		case 1:
			finalTime=finalTime+ msgLife*60000;
			break;
		case 2:
			finalTime=finalTime+ msgLife*3600000;
			break;
		case 3:
			finalTime=finalTime+ msgLife*86400000;
			break;
		}

		Date date=new Date(finalTime);

		msg.setMessageEndDate(date.getTime());
		mongoTemplate.save(msg);
		return msg;
	}

	public Message findMessage(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("messageId").is(id));
		Message message = mongoTemplate.findOne(query,Message.class);
		Date date=new Date();
		if(date.getTime()>message.getMessageEndDate())
		{
			message.setStatus(0);
		}
		else
		{
			message.setStatus(1);
		}
		return message;
	}
}
