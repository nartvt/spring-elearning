package com.elearning.program.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.elearning.program.dto.CustomUserDetail;
import com.elearning.program.entity.Role;
import com.elearning.program.entity.User;
import com.elearning.program.repository.UserRepository;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepositoryImpl;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepositoryImpl.findByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		Set<GrantedAuthority> authorities =new HashSet<GrantedAuthority>();
		 Role role = user.getRole();
		 authorities.add(new SimpleGrantedAuthority(role.getName()));
		 CustomUserDetail  customUserDetail = new CustomUserDetail(user.getEmail(),user.getPassword(), authorities);
		 customUserDetail.setFullName(user.getFullname());
		 customUserDetail.setAvatar(user.getAvatar());
		return customUserDetail;
	}


}