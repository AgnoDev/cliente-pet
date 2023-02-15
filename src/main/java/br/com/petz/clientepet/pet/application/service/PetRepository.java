package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.pet.dominio.Pet;

public interface PetRepository {
	Pet salvaPet(Pet pet);
}
