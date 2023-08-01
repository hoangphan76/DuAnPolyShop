package edu.poly.shop.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@Column(length = 30)
	private String username;
	@Column(length = 60, nullable = false)
	private String password;
	
	private Boolean isLogin = false;
	
	@OneToMany(mappedBy = "account" , cascade = CascadeType.ALL)
	private Set<Customer> customers;
}
