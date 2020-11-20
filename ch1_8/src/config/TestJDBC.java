package config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.TestService;
public class TestJDBC {
	public static void main(String[] args) {
		//初始化Spring容器ApplicationContext
		AnnotationConfigApplicationContext appCon = 
			new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
		TestService ts = appCon.getBean(TestService.class);
		ts.testJDBC();
		appCon.close();
	}
}
