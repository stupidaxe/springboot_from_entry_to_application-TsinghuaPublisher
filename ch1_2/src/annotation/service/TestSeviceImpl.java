package annotation.service;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import annotation.dao.TestDao;
@Service("testService")//相当于@Service
public class TestSeviceImpl implements TestService{
	@Resource(name="testDao")
	/**相当于@Autowired，@Autowired默认按照Bean类型注入Bean**/
	private TestDao testDao;
	@Override
	public void save() {
		testDao.save();
		System.out.println("testService save");
	}
}
