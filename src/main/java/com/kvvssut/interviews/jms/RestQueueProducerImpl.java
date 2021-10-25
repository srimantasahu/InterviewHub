package com.kvvssut.interviews.jms;/*package com.kvvssut.interviews.jms;

public class RestQueueProducerImpl implements RestQueueProducer {

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName = "java:/queue/restTestQueue")
	private Queue queue;

	@Override
	public void putMessage(RestQueuePayload restQueueDTO) throws Exception {

		Session session = null;
		MessageProducer messageProducer = null;
		Connection connection = null;

		try {
			connection = this.connectionFactory.createConnection();
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			messageProducer = session.createProducer(queue);
			connection.start();

			TextMessage textMessage = session.createTextMessage(objectMapper.writeValueAsString(restQueueDTO));
			String executionTime = configurationService
					.getValueByConfigurationKey(RestQueueConstants.CONFIG_QUEUE_EXECUTION_TIME);
			long timeInMilliSeconds = this.calculateScheduledTime(Integer.parseInt(executionTime));
			textMessage.setLongProperty("_HQ_SCHED_DELIVERY", timeInMilliSeconds); // It's the delivery time, not delay!
			messageProducer.send(textMessage);
		} finally {
			if (messageProducer != null) {
				messageProducer.close();
			}
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}*/