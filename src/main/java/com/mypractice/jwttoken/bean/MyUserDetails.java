/**
 * nasru
 * MyUserDetails.java
 * Dec 18, 2019
 */
package com.mypractice.jwttoken.bean;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mypractice.jwttoken.modal.Role;
import com.mypractice.jwttoken.modal.Users;
import com.mypractice.jwttoken.repo.RoleRepository;

/**
 * @author nasru
 *
 */

public class MyUserDetails implements UserDetails {
@Autowired
private RoleRepository roleRepo;
	private Collection<? extends GrantedAuthority> authorities;
	private String username;
	private String password;
	/*private boolean accountNonExpired;
	private boolean credentialsNonExpired;
	private boolean accountNonLocked;
	private boolean enabled;*/
	


	/**
	 * @param user 
	 * 
	 */
	public MyUserDetails(Users user) {

		List<String> roles=  roleRepo.findByRoleName(user.id);
		if(roles.isEmpty())
			throw new RuntimeException("user role is not found");
		this.authorities = roles.stream().map((Function<? super String,? extends SimpleGrantedAuthority>)obj->{
			return new SimpleGrantedAuthority(obj);
		}).collect(Collectors.toList());
		this.username = user.username;
		this.password=user.password;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public MyUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
