package cperez;

import javax.jms.Connection;
import javax.jms.JMSException;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.junit.Test;

public class Tests {

  @Test
  public void testConnectionFactory() throws JMSException {
    final String url = System.getProperty("activemq.url");
    final String username = System.getProperty("activemq.username");
    final String password = System.getProperty("activemq.password");

    // Create a connection factory.
    final ActiveMQConnectionFactory connectionFactory = new
     ActiveMQConnectionFactory(url);
    // Pass the username and password.
    connectionFactory.setUserName(username);
    connectionFactory.setPassword(password);
    // Establish a connection for the consumer.
    final Connection consumerConnection = connectionFactory.createConnection();
    consumerConnection.start();

    System.out.println("connection success...");
  }

  @Test
  public void testPooledConnectionFactory() throws JMSException {
    final String url = System.getProperty("activemq.url");
    final String username = System.getProperty("activemq.username");
    final String password = System.getProperty("activemq.password");

    // Create a connection factory.
    final ActiveMQConnectionFactory connectionFactory = new
     ActiveMQConnectionFactory(url);
    // Pass the username and password.
    connectionFactory.setUserName(username);
    connectionFactory.setPassword(password);
    // Create a pooled connection factory.
    final PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
    pooledConnectionFactory.setConnectionFactory(connectionFactory);
    pooledConnectionFactory.setMaxConnections(10);
    // Establish a connection for the producer.
    final Connection producerConnection = pooledConnectionFactory.createConnection();
    producerConnection.start();

    System.out.println("pooled connection success...");
  }

}
