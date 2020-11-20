package com.ch.ch6_9;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
@EnableCaching
@SpringBootApplication
public class Ch69Application {
	public static void main(String[] args) {
		SpringApplication.run(Ch69Application.class, args);
	}
	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
		RedisTemplate<Object, Object> rTemplate = new RedisTemplate<Object, Object>();
		rTemplate.setConnectionFactory(redisConnectionFactory);
		@SuppressWarnings({ "unchecked", "rawtypes" })
		Jackson2JsonRedisSerializer<Object>  jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		//设置值的序列化采用Jackson2JsonRedisSerializer
		rTemplate.setValueSerializer(jackson2JsonRedisSerializer);
		//设置键的序列化采用StringRedisSerializer
		rTemplate.setKeySerializer(new StringRedisSerializer());
		return rTemplate;
	}
}
