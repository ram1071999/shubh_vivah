package com.Shubh_Vivah.Shubh_Vivah.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shubh_Vivah.Shubh_Vivah.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByEmail(String email);

    User findByEmail(String email);

}
