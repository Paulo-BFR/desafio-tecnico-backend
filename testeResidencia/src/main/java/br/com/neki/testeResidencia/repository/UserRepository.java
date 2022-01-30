package br.com.neki.testeResidencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.neki.testeResidencia.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT u FROM User u WHERE u.login = :login and u.password = :senha")
	User logar(@Param("login") String login, @Param("senha") String senha);
	
	
	//https://www.baeldung.com/spring-data-jpa-query
}