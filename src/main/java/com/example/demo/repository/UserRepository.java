package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User ,Integer>
{
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    Optional<User> getLogin(@Param("email") String email, @Param("password") String password);

	String findByEmail(String email);
	List<User> findAll();
}
