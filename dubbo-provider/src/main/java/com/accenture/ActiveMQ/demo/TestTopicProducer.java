package com.accenture.ActiveMQ.demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TestTopicProducer {

    public  void send(){
        Connection connection = null;
        // 1.初始化connection工厂,使用默认的URL
        // failover://tcp://localhost:61616
        ConnectionFactory connectionFactory =new ActiveMQConnectionFactory();
        try {
            //2.创建Connection
            connection = connectionFactory.createConnection();
            // 3.打开连接
            connection.start();
            // 4.创建Session，(是否支持事务)
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 5.创建消息目标
            Destination destination_send = session.createTopic("1");

            // 6.创建生产者
            MessageProducer producer = session.createProducer(destination_send);

            // 7.配置消息是否持久化
            /*
             * DeliverMode有2种方式：
             *
             * public interface DeliveryMode { static final int NON_PERSISTENT =
             * 1;//不持久化：服务器重启之后，消息销毁
             *
             * static final int PERSISTENT = 2;//持久化：服务器重启之后，该消息仍存在 }
             */
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // 8.初始化要发送的消息
            TextMessage message = session.createTextMessage("asdasd");

            // 9.发送消息
            producer.send(message);

            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
