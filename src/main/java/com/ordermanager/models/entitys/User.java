package com.ordermanager.models.entitys;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ordermanager.models.entitys.Embeddable.Address;
import com.ordermanager.services.user.UserRole;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity(name = "users")
public class User implements UserDetails {

	private static final long serialVersionUID = 1039068114552819827L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date created_at;
	
	@NotBlank(message = "name cannot be blank")
	private String name;
	@NotBlank(message = "Email cannot be blank")
	private String email;
	
	
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 6, message = "The password must have at least 6 characters.")
	private String password;
		
	@Embedded
	Address address;
	private UserRole role;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, UserRole role,Address address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.setAddress(address);
		this.setCreated_at(new Date());
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
		else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
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