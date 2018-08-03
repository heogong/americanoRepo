package com.issac.foundation;

import java.util.Date;
import java.util.List;

import com.issac.foundation.user.model.Role;
import com.issac.foundation.user.repository.RoleRepository;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.transform.sax.SAXSource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private RoleRepository roleRepository;

	@PersistenceContext
	private EntityManager em;

	@Test
	@Transactional
	@Rollback(value=true)
	public void contextLoads() {
		/*List<User> user = userRepository.findAll();
		
		for(User aa : user) {
			System.out.println(aa.getUser
		}Nm());
	}*/

		//List<Company> comp = (List<Company>) companyRepository.findAll();

//		Company comp2 = companyRepository.findByCompSeq((long) 2);
//
//		System.out.println(comp2.getCompNm());
//		System.out.println(comp2.getCompTel());
//		System.out.println(comp2.getCompSeq());

		//Role role = new Role();
		//role.setRoleLv(2);
		//role.setRoleSeq(7);

//		Role role = roleRepository.findByRoleLv(2);
//		List<User> users = userRepository.findByCompSeqAndUserFlAndRolesOrderBySeqDesc((long) 1, 1, role);
//
//		for(User aa : users) {
//			System.out.println("userId : " +aa.getUserId());
//			System.out.println("userName : "+aa.getUserNm());
//		}


//		List<Company> company = companyRepository.findByOrderByCompSeqDesc();
//
//
//		for(Company com : company) {
//			System.out.println("compname : "+com.getCompNm());
//			//System.out.println(com.getCompNm() +" : "+com.getUsers().size());
//		}



//		Company newComp = new Company();
//
//		newComp.setCompNm("junit test");
//		newComp.setCompOwner("junit test");
//		newComp.setCompTel("010-0000-1111");
//		newComp.setCompFl(1);
//		newComp.setInstDt(new Date());
//
//		System.out.println(companyRepository.save(newComp));
	}

	@Test
	@Transactional
	public void updateTest() {
		Company cc = companyRepository.findByCompSeq((long) 1);

		System.out.println("owner : " +cc.getCompOwner());
		cc.setCompOwner("jjjjjjjjjjjj");
		cc.setModDt(new Date());

		companyRepository.save(cc);

		Company cc2 = companyRepository.findByCompSeq((long) 1);

		System.out.println("owner2 : " +cc2.getCompOwner());

	}
}
