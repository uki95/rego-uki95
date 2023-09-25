package com.clipclap.rego.repository;

import com.clipclap.rego.model.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * 
 * @author cos
 * JPA는 기본 CRUD를 JpaRepository가 상속하는 CrudRepository가 가지고 있음.
 * JPA는 method names 전략을 가짐. README.md 사진 참고
 */

// JpaRepository 를 상속하면 자동 컴포넌트 스캔됨.
public interface UserRepository extends JpaRepository<User, Integer>{
	// SELECT * FROM user WHERE username = ?1
	User findByUsername(String username);

	User findByEmail(String email);

	Optional<User> findByNickname(String nickname);

	long countByEmail(String email);
	// SELECT * FROM user WHERE provider = ?1 and providerId = ?2
	Optional<User> findByProviderAndProviderId(String provider, String providerId);
}
