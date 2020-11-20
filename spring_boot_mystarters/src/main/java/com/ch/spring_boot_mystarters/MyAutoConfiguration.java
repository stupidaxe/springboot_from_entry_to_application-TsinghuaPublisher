package com.ch.spring_boot_mystarters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//开启属性配置类MyProperties提供参数
@EnableConfigurationProperties(MyProperties.class)
//类加载器（类路径）中是否存在对应的类
@ConditionalOnClass(MyService.class)
//应用环境中属性是否存在指定的值
@ConditionalOnProperty(prefix = "my", value = "enabled", matchIfMissing = true)
public class MyAutoConfiguration {
	@Autowired
	private MyProperties myProperties;
	@Bean
	//当容器中不存在MyService的Bean时，自动配置这个Bean
	@ConditionalOnMissingBean(MyService.class)
	public MyService myService() {
		MyService myService = new MyService();
		myService.setMsg(myProperties.getMsg());
		return myService;
	}
}
