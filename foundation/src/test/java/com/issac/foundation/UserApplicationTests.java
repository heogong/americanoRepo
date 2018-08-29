package com.issac.foundation;

import java.text.ParseException;
import java.util.*;

import com.issac.foundation.user.model.Level;
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

import static org.junit.Assert.assertEquals;

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

	//@Test
	//@Transactional
	public void updateTest() {
		Company cc = companyRepository.findByCompSeq((long) 1);

		System.out.println("owner : " +cc.getCompOwner());
		cc.setCompOwner("jjjjjjjjjjjj");
		cc.setModDt(new Date());

		companyRepository.save(cc);

		Company cc2 = companyRepository.findByCompSeq((long) 1);

		System.out.println("owner2 : " +cc2.getCompOwner());
	}

//	@Test
//	@Transactional
	public void findCompany() {
		List<Company> company = companyRepository.findByOrderByCompSeqDesc();

		for(Company com : company) {
			System.out.println("compname : "+com.getCompNm());
		}
	}

	@Test
	@Transactional
	public void findUser() {


//		Role role = roleRepository.findByRoleLv(Role.LevelType.COMP.LEVEL);
//		List<User> users = userRepository.findByCompSeqAndUserFlAndRolesOrderBySeqDesc((long) 1, 1, role);
//
//		for(User aa : users) {
//			System.out.println("userId : " +aa.getUserId());
//			System.out.println("userName : "+aa.getUserNm());
//		}
	}

	@Test
	public void findRole() {


		List<Role> userRole = roleRepository.findByRoleNot(Level.SYS_ADM.toString());

		for(Role aa : userRole) {
			System.out.println(aa.getRole());
			System.out.println(aa.getRoleSeq());
		}

	}

	@Test
	//@Transactional
	public void enumTest() throws ParseException {
		//assertEquals(1, Level.BASIC);
//		assertEquals(Level.SILVER, 2);
//		assertEquals(Level.GOLD, 3);

		User user = new User();

		user.setUserId("ENUM_TEST");
		user.setUserNm("ENUM_TEST");
		user.setCompSeq(Long.valueOf(1));
		user.setUserPasswd("123");
		user.setUserFl(1);
		user.setUserSt(1000);
		user.setInstDt(new Date());

		user.setUserLv(Level.COMP_ADM.intValue());
		Role userRole = roleRepository.findByRole(Level.COMP_ADM.toString());
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

		userRepository.save(user);

		System.out.println("test level : "+user.getUserLv());
		System.out.println("ordinal : "+user.getUserLv().ordinal());
		System.out.println("intValue : "+user.getUserLv().intValue());

		//System.out.println("valueof : "+Level.valueOf(1));
	}

	@Test
	public void dateFormat() {

		Optional<User> user = userRepository.findById((long) 3);

		System.out.println("birthday : "+user.get().getUserBirth());
		System.out.println("birthday : "+user.get().getUserBirth());
		System.out.println("birthday : "+user.get().getUserBirth());
		System.out.println("birthday : "+user.get().getUserBirth());
		System.out.println("birthday : "+user.get().getUserBirth());

	}
}


