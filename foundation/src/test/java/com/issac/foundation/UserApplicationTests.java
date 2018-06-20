package com.issac.foundation;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.issac.foundation.user.model.User;
import com.issac.foundation.user.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserApplicationTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		List<User> user = userRepository.findAll();
		
		for(User aa : user) {
			System.out.println(aa.getUserNm());
		}
	}
}
