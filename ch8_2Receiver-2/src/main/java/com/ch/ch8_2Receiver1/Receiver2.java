package com.ch.ch8_2Receiver1;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 定义订阅者Receiver2
 */
@Component
public class Receiver2 {
	@Autowired
    private ObjectMapper objectMapper;
	@RabbitListener(
			bindings = 
			@QueueBinding(
				//队列名weather-queue2保证和别的订阅者不一样
				value = @Queue(value = "weather-queue2",durable = "true"),
				//weather-exchange与发布者的交换机名相同
				exchange = @Exchange(value = "weather-exchange",durable = "true",type = "topic"),
				//weather.message与发布者的消息的路由Key相同
				key = "weather.message"
			)	
    )
    @RabbitHandler
    public void receiveWeather(@Payload byte[] weatherMessage)throws Exception{
        System.out.println("-----------订阅者Receiver2接收到消息--------");
        Weather w=objectMapper.readValue(weatherMessage, Weather.class);
        //将JSON字节数组转换为Weather对象
        System.out.println("Receiver2收到的消息内容："+w);
     
    }
}
