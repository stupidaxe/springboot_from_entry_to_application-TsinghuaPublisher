package com.ch.ch6_5.repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ch.ch6_5.entity.MyUser;
@Repository
public class MyUserRepositoryImpl implements MyUserRepository{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public int saveUser(MyUser myUser) {
		String sql = "insert into user (username, password) values (?,?)";
		Object args[] = {
				myUser.getUsername(),
				myUser.getPassword()
		};
		return jdbcTemplate.update(sql, args);
	}
	@Override
	public int deleteUser(Integer id) {
		String sql = "delete from user where id = ? ";
		Object args[] = {
				id
		};
		return jdbcTemplate.update(sql, args);
	}
	@Override
	public int updateUser(MyUser myUser) {
		String sql = "update user set username = ?, password = ? where id = ? ";
		Object args[] = {
				myUser.getUsername(),
				myUser.getPassword(),
				myUser.getId()
		};
		return jdbcTemplate.update(sql, args);
	}
	@Override
	public List<MyUser> findAll() {
		String sql = "select * from user ";
		//定义一个RowMapper
		RowMapper<MyUser> rowMapper = new BeanPropertyRowMapper<MyUser>(MyUser.class);
		return jdbcTemplate.query(sql, rowMapper);
	}
	@Override
	public MyUser findUserById(Integer id) {
		String sql = "select * from user where id = ? ";
		Object args[] = {
				id
		};
		//定义一个RowMapper
		RowMapper<MyUser> rowMapper = new BeanPropertyRowMapper<MyUser>(MyUser.class);
		return jdbcTemplate.queryForObject(sql, args, rowMapper);
	}
}
