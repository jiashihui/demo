package com.example.demo;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test() {
		// User user = new User(1002,"嬴政","123456","13991568756","西安中路5号");
		User user = userMapper.selectByPrimaryKey(1001);
		Assert.assertEquals("王昭君2", user.getUserName());
	}

	@Test
	public void contextLoads() {
	}

}
