package controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Person;
@Controller
public class TestController {
	/**
	 * 接收页面请求的JSON数据，并返回JSON格式结果
	 */
	@RequestMapping("/testJson")
	@ResponseBody
	public List<Map<String, Object>> testJson(@RequestBody Person user) {
		//打印接收的JSON格式数据
		System.out.println("pname=" + user.getPname() +
				", password=" + user.getPassword() + ",page=" + user.getPage());
		//返回Person对象
		//return user;
		/**ArrayList<Person> allp = new ArrayList<Person>();
		Person p1 = new Person();
		p1.setPname("陈恒1");
		p1.setPassword("123456");
		p1.setPage(80);
		allp.add(p1);
		
		Person p2 = new Person();
		p2.setPname("陈恒2");
		p2.setPassword("78910");
		p2.setPage(90);
		allp.add(p2);
		//返回ArrayList<Person>对象
		return allp;
		**/
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pname", "陈恒2");
		map.put("password", "123456");
		map.put("page", 25);
		//返回一个Map<String, Object>对象
		//return map;
		//返回一个List<Map<String, Object>>对象
		List<Map<String, Object>> allp = new ArrayList<Map<String, Object>>();
		allp.add(map);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("pname", "陈恒3");
		map1.put("password", "54321");
		map1.put("page", 55);
		allp.add(map1);
		return allp;
	}
}
