package com.wk.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wk.entity.Account;
import com.wk.mybatis.inter.IAccountOperation;

public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private IAccountOperation accountOperation;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDetails user = null;
		Account account = accountOperation.queryAccountByUsername(username);
		System.out.println(account);
		if (account==null) {
			System.out.println(username+"is not exist");
			throw new UsernameNotFoundException(username+"is not exist");
		}
		user = new User(account.getUsername(), account.getPassword(), true, true, true, true, getAuthorities(account.getAccess()));
		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(Integer access){
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
		authList.add(new GrantedAuthorityImpl("ROLE_USER"));
		if (access.compareTo(1)==0) {
			authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
		}
		return authList;
	}
}
