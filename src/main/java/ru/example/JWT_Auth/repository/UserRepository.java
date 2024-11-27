package ru.example.JWT_Auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.example.JWT_Auth.entity.User;
import ru.example.JWT_Auth.entity.UserEmail;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	
	@Query("SELECT new ru.example.JWT_Auth.entity.UserEmail(u.email, u.verified) " +
		       "FROM User u " +
		       "WHERE u.username = :username")
	Optional<UserEmail> findUserEmailByUsername(@Param("username") String username);
	
//	@Query("SELECT new com.yourpackage.UserEmail(u.email, u.verified) " +
//		       "FROM User u " +
//		       "WHERE u.id = :id")
//		Optional<UserEmail> findUserEmailById(@Param("id") Long id);


}
