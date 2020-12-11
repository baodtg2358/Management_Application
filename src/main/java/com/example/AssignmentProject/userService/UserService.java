package com.example.AssignmentProject.userService;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.AssignmentProject.entity.Users;
import com.example.AssignmentProject.reporitory.userRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private userRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userrepo.findByUsers(username);
		if(user ==null) {
			throw new UsernameNotFoundException("Không tìm thấy tên đăng nhập");
		}
		return new CustomUsersDetails(user);
	}

}
