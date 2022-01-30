package br.com.neki.testeResidencia.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.neki.testeResidencia.entity.User;
import br.com.neki.testeResidencia.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listar() {
		return userRepository.findAll();
	}

	public User buscarUser(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}

		return null;
	}

	public User inserir(User user) {

		user = userRepository.save(user);

		return user;
	}

	public User atualizar(Long id, User user) {
		Optional<User> user1 = userRepository.findById(id);

		return userRepository.save(user1.get());
	}

	public boolean delete(Long id) {

		if (!userRepository.existsById(id)) {
			return false;
		}
		userRepository.deleteById(id);
		return true;
	}

	public User logar( User user) {
		
		return userRepository.logar(user.getLogin(), user.getPassword());
	}

}