package com.test.messaging.model;


import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document

public class Message {
	@Id
	private String messageId;
	private int messageType;
	private int messageLifeUnit;
	private String messageURL;
	
	public String getMessageURL() {
		return messageURL;
	}
	public void setMessageURL(String string) {
		this.messageURL = string;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public int getMessageLifeUnit() {
		return messageLifeUnit;
	}
	public void setMessageLifeUnit(int messageLifeUnit) {
		this.messageLifeUnit = messageLifeUnit;
	}
	public String getMessageId() {
		return messageId;
	}
	private long messageEndDate;


	public long getMessageEndDate() {
		Date date=new Date();
		if(date.getTime()>messageEndDate)
		{
			setStatus(0);
		}
		else
		{
			setStatus(1);
		}
		return messageEndDate;
	}
	public void setMessageEndDate(long messageEndDate) {
		this.messageEndDate = messageEndDate;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public long getMessageLife() {
		return messageLife;
	}
	public void setMessageLife(long messageLife) {
		this.messageLife = messageLife;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessageValue() {
		return messageValue;
	}
	public void setMessageValue(String messageValue) {
		this.messageValue = messageValue;
	}
	
	private long messageLife;
	private String displayName;
	private int status;
	private String messageValue;

}
