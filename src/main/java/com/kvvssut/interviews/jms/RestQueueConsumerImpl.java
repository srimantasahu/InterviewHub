package com.kvvssut.interviews.jms;/*package com.kvvssut.interviews.jms;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/restTestQueue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
public class RestQueueConsumerImpl implements MessageListener {

	@Override
	public void onMessage(Message message) {
		restQueuePayload restQueuePayload = null;

		if (message instanceof TextMessage) {
			try {
				String textMessage = ((TextMessage) message).getText();
				restQueuePayload = objectMapper.readValue(textMessage, RestQueuePayload.class);
				this.logConsumingMessage(message);
				restService.verifyUserDetails(restQueuePayload.getUserName(), restQueuePayload.getAmount());
			} catch (JMSException | IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}*/