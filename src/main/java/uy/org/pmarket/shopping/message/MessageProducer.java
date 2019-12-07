package uy.org.pmarket.shopping.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class MessageProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	@Value(value = "${kafka.shopping.missing.topic.name}")
	private String topicMissing;
	@Value(value = "${kafka.shopping.missing.topic.error}")
	private String topicError;
	
	public void sendMessage(String message) {
		ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicMissing, message);
		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("Sent message:" + message + ", offset:" + result.getRecordMetadata().offset());
			}

			@Override
			public void onFailure(Throwable ex) {
				System.err.println("Error send message" + ex.getMessage());
			}
		});
	}
}
