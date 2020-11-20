package com.ch.ch10_2.health;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
@Component
public class MyHealthIndicator implements HealthIndicator{
	@Override
	public Health health() {
		int errorCode = check();
		if(errorCode != 0) {
			//down方法表示异常，withDetail方法添加任意多的异常信息
			return Health.down().withDetail("message", "error:" + errorCode).build();
		}
		//up方法表示健康
		return Health.up().build();
	}
	/**
	 * 模拟返回一个错误状态
	 */
	private int check() {
		return 1;
	}
}
