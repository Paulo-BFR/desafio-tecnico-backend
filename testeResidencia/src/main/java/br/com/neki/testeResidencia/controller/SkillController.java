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

import br.com.neki.testeResidencia.entity.Skill;
import br.com.neki.testeResidencia.service.SkillService;

@RestController
@RequestMapping("/skill")
public class SkillController {
	
	
	@Autowired
	private SkillService skillService;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Skill>> listar(){
		List<Skill> skill = skillService.listar();
		return ResponseEntity.ok(skill);
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<Skill> buscarSkill(@PathVariable Long id){
		Skill skill = skillService.buscarSkill(id);
		if(null != skill) {
			return ResponseEntity.ok(skill);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Skill> inserir( @Valid @RequestBody Skill skill){
		Skill skill1 = skillService.inserir(skill);
		return ResponseEntity.ok(skill1);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Skill> atualizar(@PathVariable Long id,@Valid @RequestBody Skill skill){
			Skill skill1 = skillService.atualizar(id, skill);
			if( null != skill1) {
				
				return ResponseEntity.ok(skill1);
			}
			else {
				return ResponseEntity.notFound().build();
			}
			
		}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		boolean skill1 = skillService.delete(id);
		
		if(false == skill1) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.noContent().build();
	}

}