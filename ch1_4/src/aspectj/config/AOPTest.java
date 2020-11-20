package aspectj.config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aspectj.dao.TestDao;
public class AOPTest {
	public static void main(String[] args) {
		//初始化Spring容器ApplicationContext
		AnnotationConfigApplicationContext appCon = 
			new AnnotationConfigApplicationContext(AspectjAOPConfig.class);
		//从容器中，获取增强后的目标对象
		TestDao testDaoAdvice = appCon.getBean(TestDao.class);
		//执行方法
		testDaoAdvice.save();
		System.out.println("================");
		testDaoAdvice.modify();
		System.out.println("================");
		testDaoAdvice.delete();
		appCon.close();
	}
}
