package com.senai.ryan.PrjGame.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.senai.ryan.PrjGame.entities.Jogo;
import com.senai.ryan.PrjGame.repository.Repository;

@org.springframework.stereotype.Service
public class Service {
	private static Repository repository;

	@Autowired
	public Service(Repository repository) {
		Service.repository = repository;
	}

	public Jogo saveJogo(Jogo jogo) {
		return repository.save(jogo);
	}

	public static List<Jogo> getAlljogo() {
		return repository.findAll();
	}

	public Jogo getJogoById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public void deleteJogo(Long id) {
		repository.deleteById(id);
	}

	public static Jogo updateJogo(Long id, Jogo novoJogo) {
		Optional<Jogo> jogoOptional = repository.findById(id);
		if (jogoOptional.isPresent()) {
			Jogo jogoExistente = jogoOptional.get();
			jogoExistente.setName(novoJogo.getName());
			jogoExistente.setPlataform(novoJogo.getPlataform());
			return repository.save(jogoExistente);
		} else {
			return null;
		}
	}

}
