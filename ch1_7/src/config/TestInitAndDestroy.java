package config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import service.MyService;
public class TestInitAndDestroy {
	public static void main(String[] args) {
		//初始化Spring容器ApplicationContext
		AnnotationConfigApplicationContext appCon = 
			new AnnotationConfigApplicationContext(JavaConfig.class);
		MyService ms = 	appCon.getBean(MyService.class);
		appCon.close();
	}
}
