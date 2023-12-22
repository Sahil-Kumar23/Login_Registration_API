package com.login.registration.grp.jpa_repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.registration.grp.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
}
