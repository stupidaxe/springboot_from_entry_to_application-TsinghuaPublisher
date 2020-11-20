package com.ch.practice4_2.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

public class ConditionConfig {
	@Bean
	@Conditional(WindowsCondition.class)
	public MessagePrint windowsMessage() {
		return new WindowsPrint();
	}
	@Bean
	@Conditional(LinuxCondition.class)
	public MessagePrint linuxMessage() {
		return new LinuxPrint();
	}

}
