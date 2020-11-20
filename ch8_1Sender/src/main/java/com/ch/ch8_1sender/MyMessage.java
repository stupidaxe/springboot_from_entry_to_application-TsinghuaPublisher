package com.ch.ch8_1sender;
import java.util.ArrayList;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.springframework.jms.core.MessageCreator;
public class MyMessage implements MessageCreator{
	@Override
	public Message createMessage(Session session) throws JMSException {
		MapMessage mapm = session.createMapMessage();
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("陈恒1");
		arrayList.add("陈恒2");
		mapm.setObject("mesg1", arrayList);//只能存Java的基本对象
		mapm.setString("mesg2", "测试消息2");
		return mapm;
	}
}
