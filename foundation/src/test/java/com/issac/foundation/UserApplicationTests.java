package com.issac.foundation;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.issac.foundation.company.model.Company;
import com.issac.foundation.company.repository.CompanyRepository;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	@Test
	@Transactional
	@Rollback(value=true)
	public void contextLoads() {
		/*List<User> user = userRepository.findAll();
		
		for(User aa : user) {
			System.out.println(aa.getUser
		}Nm());
	}*/
//
//		List<Company> comp = (List<Company>) companyRepository.findAll();
//
//		List<Company> comp2 = companyRepository.findByCompSeq((long) 2);
//
//		for (Company aa : comp) {
//			for (User u : aa.getUsers()) {
//				System.out.println("userId : " + u.getUserId());
//			}
//		}

		Company newComp = new Company();

		newComp.setCompNm("junit test");
		newComp.setCompOwner("junit test");
		newComp.setCompTel("010-0000-1111");
		newComp.setCompFl(1);
		newComp.setInstDt(new Date());

		System.out.println(companyRepository.save(newComp));
	}
}
