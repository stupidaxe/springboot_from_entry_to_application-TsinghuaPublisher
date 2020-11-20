package com.ch.ch9_2;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.ch.ch9_2.controller.StudentController;
import com.ch.ch9_2.entity.Student;
import com.ch.ch9_2.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
@RunWith(SpringRunner.class)
/*仅仅扫描这个StudentController类，即注入StudentController到Spring容器*/
@WebMvcTest(StudentController.class)
public class WebMvcTestStudentController {
	//MockMvc是Spring提供的专用于测试Controller类
	@Autowired
	private MockMvc mvc;
	//因为在StudentController类依赖StudentRepository，所以需要mock掉
	@MockBean
	private StudentRepository studentRepository; 
	@Test
	public void saveTest() throws Exception {
		Student stu = new Student(1,"5555","陈恒","男");
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
		Student stu = new Student(1,"5555","陈恒","男");
		//模拟StudentRepository，getOne(1)将返回stu对象
		BDDMockito.given(studentRepository.getOne(1)).willReturn(stu);
		mvc.perform(get("/student/getOne/{id}", 1)
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON_UTF8)
				)
				.andExpect(status().isOk())//状态响应码为200，如果不是抛出异常，测试不通过。
				.andExpect(jsonPath("$.sname").value("陈恒"))
				.andDo(print());//输出结果
	}
}
