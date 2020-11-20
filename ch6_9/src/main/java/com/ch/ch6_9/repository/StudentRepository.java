package com.ch.ch6_9.repository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import com.ch.ch6_9.entity.Student;
@Repository
public class StudentRepository {
	@SuppressWarnings("unused")
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@SuppressWarnings("unused")
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	/**
	 * 使用@Resource注解指定stringRedisTemplate，可注入基于字符串的简单属性操作方法
	 * ValueOperations<String, String> valueOpsStr = stringRedisTemplate.opsForValue();
	 */
	@Resource(name="stringRedisTemplate")
	ValueOperations<String, String> valueOpsStr;
	/**
	 * 使用@Resource注解指定redisTemplate，可注入基于对象的简单属性操作方法
	 * ValueOperations<Object, Object> valueOpsObject = redisTemplate.opsForValue();
	 */
	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valueOpsObject;
	/**
	 * 保存字符串到redis
	 */
	public void saveString(String key, String value) {
		valueOpsStr.set(key, value);
	}
	/**
	 * 保存对象到redis
	 */
	public void saveStudent(Student stu) {
		valueOpsObject.set(stu.getSno(), stu);
	}
	/**
	 * 保存List数据到redis
	 */
	public void saveMultiStudents(Object key, List<Student> stus) {
		valueOpsObject.set(key, stus);
	}
	/**
	 * 从redis中获得字符串数据
	 */
	public String getString(String key) {
		return valueOpsStr.get(key);
	}
	/**
	 * 从redis中获得对象数据
	 */
	public Object getObject(Object key) {
		return valueOpsObject.get(key);
	}
}
