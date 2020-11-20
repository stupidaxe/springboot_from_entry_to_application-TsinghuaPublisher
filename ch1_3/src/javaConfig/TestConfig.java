package javaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import controller.TestController;
public class TestConfig {
	public static void main(String[] args) {
		//初始化Spring容器ApplicationContext
		AnnotationConfigApplicationContext appCon = 
			new AnnotationConfigApplicationContext(JavaConfig.class);
		TestController tc = appCon.getBean(TestController.class);
		tc.save();
		appCon.close();
	}
}
