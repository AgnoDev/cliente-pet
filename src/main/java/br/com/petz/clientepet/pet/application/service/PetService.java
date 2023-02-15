package br.com.petz.clientepet.pet.application.service;

import java.util.UUID;

import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import jakarta.validation.Valid;

public interface PetService {
	PetResponse cadastraPet(UUID idCliente, @Valid PetRequest petRequest);
}
