package javaConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import controller.TestController;
import dao.TestDao;
import service.TestService;
@Configuration
//一个配置类，相当于一个Spring配置的XML文件；
//此处没有使用包扫描，是因为所有Bean都在此类中定义了。
public class JavaConfig {
	@Bean
	public TestDao getTestDao() {
		return new TestDao();
	}
	@Bean
	public TestService getTestService() {
		TestService ts = new TestService();
		//使用set方法注入testDao
		ts.setTestDao(getTestDao());
		return ts;
	}
	@Bean
	public TestController getTestController() {
		TestController tc = new TestController();
		//使用set方法注入testService
		tc.setTestService(getTestService());
		return tc;
	}
}
