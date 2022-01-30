package br.com.neki.testeResidencia.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.testeResidencia.entity.Skill;
import br.com.neki.testeResidencia.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public List<Skill> listar() {
		return skillRepository.findAll();
	}

	public Skill buscarSkill(Long id) {
		Optional<Skill> skill = skillRepository.findById(id);
		if (skill.isPresent()) {
			return skill.get();
		}

		return null;
	}

	public Skill inserir(Skill skill) {

		skill = skillRepository.save(skill);

		return skill;
	}

	public Skill atualizar(Long id, Skill skill) {
		Optional<Skill> skill1 = skillRepository.findById(id);

		return skillRepository.save(skill1.get());
	}

	public boolean delete(Long id) {

		if (!skillRepository.existsById(id)) {
			return false;
		}
		skillRepository.deleteById(id);
		return true;
	}

}