package config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import instance.BeanClass;
public class TestBean {
	public static void main(String[] args) {
		//初始化Spring容器ApplicationContext
		AnnotationConfigApplicationContext appCon = 
			new AnnotationConfigApplicationContext(JavaConfig.class);
		BeanClass b1 = (BeanClass)appCon.getBean("beanClass");
		System.out.println(b1+ b1.message);
		BeanClass b2 = (BeanClass)appCon.getBean("beanStaticFactory");
		System.out.println(b2+ b2.message);
		BeanClass b3 = (BeanClass)appCon.getBean("beanInstanceFactory");
		System.out.println(b3+ b3.message);
		appCon.close();
	}
}
