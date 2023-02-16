package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import jakarta.validation.Valid;

public interface PetService {
	PetResponse cadastraPet(UUID idCliente, @Valid PetRequest petRequest);
	List<PetClienteListResponse> buscaPetsDoCliente(UUID idCliente);
	PetDetalhadoResponse buscaPetsDoCliente(UUID idCliente, UUID idPet);
	void deletaPetDoCliente(UUID idCliente, UUID idPet);
}
