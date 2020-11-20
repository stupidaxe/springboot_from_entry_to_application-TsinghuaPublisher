package service;
import dao.TestDao;
//此处没有使用@Service声明Bean
public class TestService {
	//此处没有使用@Autowired注入testDao
	TestDao testDao;
	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	public void save() {
		testDao.save();
	}
}
