package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.dominio.Pet;

public interface PetRepository {
	Pet salvaPet(Pet pet);
	List<Pet> buscaPetsDoCliente(UUID idCliente);
	Pet buscaPetDetalhado(UUID idPet);
}
