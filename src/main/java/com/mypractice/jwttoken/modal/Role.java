/**
 * nasru
 * Role.java
 * Dec 17, 2019
 */
package com.mypractice.jwttoken.modal;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

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
@Table(name = "ROLES")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_master")
	@SequenceGenerator(name="role_master", sequenceName = "role_seq", allocationSize=1,initialValue = 1000)
	@Column(name = "ROLE_ID")
	public Integer roleID;
	@Column(name = "ROLE_NAME", length = 15)
	public String roleName;
	@OneToMany(mappedBy = "roles")
	public List<Users> users;

}
