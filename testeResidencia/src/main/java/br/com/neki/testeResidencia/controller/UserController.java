package br.com.neki.testeResidencia.controller;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.testeResidencia.entity.User;
import br.com.neki.testeResidencia.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/todos")
	public ResponseEntity<List<User>> listar(){
		List<User> user = userService.listar();
		return ResponseEntity.ok(user);
	}

	
	@GetMapping("/listar/{id}")
	public ResponseEntity<User> buscarUser(@PathVariable Long id){
		User user = userService.buscarUser(id);
		if(null != user) {
			return ResponseEntity.ok(user);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<User> inserir( @Valid @RequestBody User user){
		User user1 = userService.inserir(user);
		return ResponseEntity.ok(user1);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<User> atualizar(@PathVariable Long id,@Valid @RequestBody User user){
			User user1 = userService.atualizar(id, user);
			if( null != user1) {
				
				return ResponseEntity.ok(user1);
			}
			else {
				return ResponseEntity.notFound().build();
			}
			
		}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		boolean user1 = userService.delete(id);
		
		if(false == user1) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/login")
	public ResponseEntity<User> logar( @Valid @RequestBody User user){
		User user1 = userService.logar(user);
		return ResponseEntity.ok(user1);
	}
}
