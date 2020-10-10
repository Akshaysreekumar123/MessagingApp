package com.test.messaging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.messaging.model.Message;
import com.test.messaging.service.MessageService;

@RestController
public class MessagingAPIController {
	@Autowired
	MessageService msgService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/message", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Message>> retrieveMessages()
	{
		return new ResponseEntity<List<Message>> (msgService.findAllMessages(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/message/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> retrieveMessage(@PathVariable String id)
	{
		return new ResponseEntity<Message> (msgService.findMessage(id), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value="/message", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> createMessage(@RequestBody Message msg)
	{
		return new ResponseEntity<Message> (msgService.createMessage(msg), HttpStatus.OK);
	}
	
}
