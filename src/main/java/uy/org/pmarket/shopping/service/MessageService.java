package uy.org.pmarket.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import uy.org.pmarket.shopping.exception.ShoppingException;
import uy.org.pmarket.shopping.message.MessageProducer;

public class MessageService<T> {

	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private MessageProducer messageSend;
	
	public void send(T t) throws ShoppingException {
		String message;
		try {
			message = objectMapper.writeValueAsString(t);
			messageSend.sendMessage(message);
		} catch (JsonProcessingException e) {
			throw new ShoppingException(e);
		}
		
	}
}
