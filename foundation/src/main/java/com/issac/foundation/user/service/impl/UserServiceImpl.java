package com.issac.foundation.user.service.impl;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.issac.foundation.user.model.Role;
import com.issac.foundation.user.model.User;
import com.issac.foundation.user.repository.RoleRepository;
import com.issac.foundation.user.repository.UserRepository;
import com.issac.foundation.user.service.UserService;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private RoleRepository roleRepository;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void saveUser(User user) {
		user.setUserPasswd(bCryptPasswordEncoder.encode(user.getUserPasswd()));
        user.setUserFl(1);
        user.setUserSt(1000);
        user.setInstDt(new Date());
        
        user.setUserLv(2);
        user.setUserTel("010-1111-1111");
        
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
		userRepository.save(user);
	}

	@Override
	public Page<User> listUser(Pageable pageable, String search) {
		return userRepository.findByUserFlAndUserIdContaining(1, pageable, search);
	}


	@Override
	public Optional<User> findUser(Long seq) {
		
		return userRepository.findById(seq);
	}


	@Override
	public void editUser(User user) {
		// 변경 될 db 데이터 조회
		Optional<User> dbUser = userRepository.findById(user.getSeq());
		User existUser = dbUser.get(); 
		
		// set value
		existUser.setUserNm(user.getUserNm()); 
		existUser.setUserTel(user.getUserTel());
		existUser.setModDt(new Date());
		existUser.setRoles(user.getRoles());
		
		userRepository.save(existUser);
		
	}

	@Override
	public void deleteUser(Long seq) {
		
		/*Optional<User> dbUser = userRepository.findById(seq);
		User existUser = dbUser.get();
		
		existUser.setUserFl(0);
		
		userRepository.save(existUser);*/
		
		userRepository.deleteById(seq);
	}

	//	회사 관리자 사용자 리스트
	@Override
	public List<User> companyUser(Long compSeq) {
		Role role = roleRepository.findByRoleLv(Role.LevelType.COMP.getLvNum());
		return userRepository.findByCompSeqAndUserFlAndRolesOrderBySeqDesc(compSeq, 1, role);
	}
}