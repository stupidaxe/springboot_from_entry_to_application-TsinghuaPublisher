package com.ch.ch8_1receive;
import java.util.ArrayList;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
@Component
public class ReceiverMsg {
	@JmsListener(destination="mydestination")
	public void receiverMessage(MapMessage mapm) throws JMSException {
		@SuppressWarnings("unchecked")
		ArrayList<String> arrayList = (ArrayList<String>)mapm.getObject("mesg1");
		System.out.println(arrayList);
		System.out.println(mapm.getString("mesg2"));
	}
}
