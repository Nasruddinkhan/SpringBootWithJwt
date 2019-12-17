/**
 * nasru
 * RoleRepository.java
 * Dec 18, 2019
 */
package com.mypractice.jwttoken.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mypractice.jwttoken.modal.Role;
import com.mypractice.jwttoken.modal.Users;

/**
 * @author nasru
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	/**
	 * @param id
	 * @return
	 */
	@Query("select roleName from Role where users = :USERID")
	List<String> findByRoleName(@Param("USERID")Integer user);
}
