package com.issac.foundation;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.issac.foundation.company.model.Company;
import com.issac.foundation.company.repository.CompanyRepository;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	@Test
	public void contextLoads() {
		/*List<User> user = userRepository.findAll();
		
		for(User aa : user) {
			System.out.println(aa.getUser
		}Nm());
	}*/

		List<Company> comp = (List<Company>) companyRepository.findAll();

		List<Company> comp2 = companyRepository.findByCompSeq((long) 2);

		for (Company aa : comp) {
			for (User u : aa.getUsers()) {
				System.out.println("userId : " + u.getUserId());
			}
		}
	}
}
