/**
 * nasru
 * Users.java
 * Dec 14, 2019
 */
package com.mypractice.jwttoken.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author nasru
 *
 */
@Entity
@Builder
@Table(name = "USERS")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Users{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_master")
	@SequenceGenerator(name="user_master", sequenceName = "user_seq", allocationSize=1,initialValue = 1000)
	@Column(name = "USER_ID")
	public Integer id;
	@Column(name = "USER_NAME", length = 15)
	public String username;
	@Column(name = "PASSWORD", length = 16)
	public String password;
	@Column(name = "ACTIVE")
	public boolean active;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID" , foreignKey = @ForeignKey(name="FK_USER_ROLE"))
	@JsonIgnore
	public Role roles;
}
