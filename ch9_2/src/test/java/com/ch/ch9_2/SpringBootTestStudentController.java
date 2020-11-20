package com.ch.ch9_2;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import com.ch.ch9_2.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Ch92Application.class)//应用的主程序
public class SpringBootTestStudentController {
	//注入Spring容器
	@Autowired
	private WebApplicationContext wac;
	//MockMvc模拟实现对Controller的请求
	private MockMvc mvc;
	//在测试前，初始化MockMvc对象
	@Before
	public void initMockMvc() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	@Test
	@Transactional
	public void saveTest() throws Exception {
		Student stu = new Student(1, "5555","陈恒","男");
		ObjectMapper mapper = new ObjectMapper();//把对象转换成JSON字符串
		mvc.perform(post("/student/save")
				.contentType(MediaType.APPLICATION_JSON_UTF8)//发送JSON数据格式
				.accept(MediaType.APPLICATION_JSON_UTF8)//接收JSON数据格式
				.content(mapper.writeValueAsString(stu))//传递JSON字符串参数
				)
		.andExpect(status().isOk())//状态响应码为200，如果不是抛出异常，测试不通过。
		.andDo(print());//输出结果
	}
	@Test
	public void getStudent() throws Exception {
		mvc.perform(get("/student/getOne/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				)
				.andExpect(status().isOk())//状态响应码为200，如果不是抛出异常，测试不通过。
				.andExpect(jsonPath("$.sname").value("陈恒"))
				.andDo(print());//输出结果
	}
}
