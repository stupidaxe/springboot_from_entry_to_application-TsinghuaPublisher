package service;
public class MyService {
	public void initService() {
		System.out.println("initMethod");
	}
	public MyService() {
		System.out.println("构造方法");
	}
	public void destroyService() {
		System.out.println("destroyMethod");
	}
}
