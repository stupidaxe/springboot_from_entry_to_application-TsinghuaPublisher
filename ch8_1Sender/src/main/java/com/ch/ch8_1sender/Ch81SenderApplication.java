package com.ch.ch8_1sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsTemplate;
@SpringBootApplication
public class Ch81SenderApplication implements CommandLineRunner{
	@Autowired
	private JmsTemplate jmsTemplate;
	public static void main(String[] args) {
		SpringApplication.run(Ch81SenderApplication.class, args);
	}
	/**
	 * 我们这里为了方便操作使用run方法发送消息，
	 * 当然完全可以使用控制器通过Web访问
	 */
	@Override
	public void run(String... args) throws Exception {
		//new MyMessage()回调接口方法createMessage产生消息
		jmsTemplate.send("mydestination", new MyMessage());
	}
}
