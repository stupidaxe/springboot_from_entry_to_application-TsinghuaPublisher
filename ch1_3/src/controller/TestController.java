package controller;
import service.TestService;
//此处没有使用@Controller声明Bean
public class TestController {
	//此处没有使用@Autowired注入testService
	TestService testService;
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	public void save() {
		testService.save();
	}
}
