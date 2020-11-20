package com.ch.ch8_2Sender;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ch.ch8_2Sender.entity.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
@SpringBootApplication
public class Ch82SenderApplication implements CommandLineRunner{ 
	@Autowired
    private ObjectMapper objectMapper;
	@Autowired 
	RabbitTemplate rabbitTemplate;
	public static void main(String[] args) {
		SpringApplication.run(Ch82SenderApplication.class, args);
	}
	/**
	 * 定义发布者
	 */
	@Override
	public void run(String... args) throws Exception {
		//定义消息对象
		Weather weather = new Weather();
		weather.setId("010");
		weather.setCity("北京");
		weather.setWeatherDetail("今天晴到多云，南风5-6级，温度19-26°C");
		//指定Json转换器，Jackson2JsonMessageConverter默认将消息转换成byte[]类型的消息
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		//objectMapper将weather对象转换为JSON字节数组
		Message msg=MessageBuilder.withBody(objectMapper.writeValueAsBytes(weather))
				.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT)
                .build();
        // 消息唯一ID
        CorrelationData correlationData = new CorrelationData(weather.getId());
		//使用已封装好的convertAndSend(String exchange , String routingKey , Object message, CorrelationData correlationData)
		//将特定的路由key发送消息到指定的交换机
		rabbitTemplate.convertAndSend(
				"weather-exchange", //分发消息的交换机名称
				"weather.message", //用来匹配消息的路由Key
				msg, //消息体
				correlationData);
	}
}
