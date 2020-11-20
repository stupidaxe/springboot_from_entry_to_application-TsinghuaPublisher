package com.ch.spring_boot_addstarters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//开启属性配置类AddProperties提供参数
@EnableConfigurationProperties(AddProperties.class)
//类加载器（类路径）中是否存在对应的类
@ConditionalOnClass(AddService.class)
//应用环境中属性是否存在指定的值
@ConditionalOnProperty(prefix = "add", value = "enabled", matchIfMissing = true)
public class AddAutoConfiguration {
	@Autowired
	private AddProperties myProperties;
	@Bean
	//当容器中不存在AddService的Bean时，自动配置这个Bean
	@ConditionalOnMissingBean(AddService.class)
	public AddService myService() {
		AddService myService = new AddService();
		myService.setNumber1(myProperties.getNumber1());
		myService.setNumber2(myProperties.getNumber2());
		return myService;
	}
}
