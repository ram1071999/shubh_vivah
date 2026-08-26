package com.Shubh_Vivah.Shubh_Vivah.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Shubh_Vivah.Shubh_Vivah.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
