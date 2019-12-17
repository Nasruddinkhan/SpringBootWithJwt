/**
 * nasru
 * UserRepository.java
 * Dec 18, 2019
 */
package com.mypractice.jwttoken.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mypractice.jwttoken.modal.Users;

/**
 * @author nasru
 *
 */
@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

	/**
	 * @param username
	 */
	Optional<Users> findByUsername(String username);
}
