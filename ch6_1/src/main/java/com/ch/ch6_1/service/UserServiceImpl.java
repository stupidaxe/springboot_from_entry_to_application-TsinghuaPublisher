package com.ch.ch6_1.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ch.ch6_1.entity.MyUser;
import com.ch.ch6_1.repository.UserRepository;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;//依赖注入数据访问层
	@Override
	public void saveAll() {
		MyUser mu1 = new MyUser();
		mu1.setUname("陈恒1");
		mu1.setUsex("男");
		mu1.setAge(88);
		MyUser mu2 = new MyUser();
		mu2.setUname("陈恒2");
		mu2.setUsex("女");
		mu2.setAge(18);
		MyUser mu3 = new MyUser();
		mu3.setUname("陈恒3");
		mu3.setUsex("男");
		mu3.setAge(99);
		List<MyUser> users = new ArrayList<MyUser>();
		users.add(mu1);
		users.add(mu2);
		users.add(mu3);
		//调用父接口中的方法saveAll
		userRepository.saveAll(users);
	}
	@Override
	public List<MyUser> findAll() {
		//调用父接口中的方法findAll
		return userRepository.findAll();
	}
	@Override
	public MyUser findByUname(String uname) {
		return userRepository.findByUname(uname);
	}
	@Override
	public List<MyUser> findByUnameLike(String uname) {
		return userRepository.findByUnameLike("%" + uname + "%");
	}
	@Override
	public MyUser getOne(int id) {
		//调用父接口中的方法getOne
		return userRepository.getOne(id);
	}

}
