package config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.MyService;
@Configuration
public class JavaConfig {
	//initMethod和destroyMethod指定MyService类的initService和destroyService方法
	//在构造之后、销毁之前执行
	@Bean(initMethod="initService",destroyMethod="destroyService")
	public MyService getMyService() {
		return new MyService();
	}
}
