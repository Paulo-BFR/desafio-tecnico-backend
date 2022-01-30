package br.com.neki.testeResidencia.repository;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.neki.testeResidencia.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	//User logar(@Valid User user);

}