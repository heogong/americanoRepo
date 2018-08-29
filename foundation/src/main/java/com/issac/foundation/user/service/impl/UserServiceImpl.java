package com.issac.foundation.user.service.impl;

import java.text.ParseException;
import java.util.*;

import javax.transaction.Transactional;

import com.issac.foundation.user.model.Level;
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
	public Optional<User> findUser(Long seq) {
		return userRepository.findById(seq);
	}

		@Override
		public User findUserByUserId(String userId) {
			return userRepository.findByUserIdAndUserFl(userId, 1);
		}

		@Override
		public User saveUser(User user) {
			user.setUserPasswd(bCryptPasswordEncoder.encode(user.getUserPasswd()));
			user.setUserFl(1);
			user.setUserSt(1000);
			user.setUserLv(user.getUserLv().intValue());
			user.setInstDt(new Date());

		Role userRole = roleRepository.findByRole(user.getUserLv().toString());
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

		return userRepository.save(user);
	}

	@Override
	public Page<User> listUser(Pageable pageable, String search) {
		return userRepository.findByUserFlAndUserIdContaining(1, pageable, search);
	}

	@Override
	public void editUser(User user) {
		// 변경 될 db 데이터 조회
		Optional<User> dbUser = userRepository.findById(user.getSeq());
		User updtUser = dbUser.get();
		
		// set value
		updtUser.setUserNm(user.getUserNm());

		try {
			updtUser.setUserBirth(user.getUserBirth());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		updtUser.setUserTel(user.getUserTel());
		updtUser.setModDt(new Date());
		updtUser.setUserLv(user.getUserLv().intValue());

		Role userRole = roleRepository.findByRole(user.getUserLv().toString());
		updtUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		
		userRepository.save(updtUser);
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
		Role role = roleRepository.findByRole(Level.COMP_ADM.toString());
		return userRepository.findByCompSeqAndUserFlAndRolesOrderBySeqDesc(compSeq, 1, role);
	}
}