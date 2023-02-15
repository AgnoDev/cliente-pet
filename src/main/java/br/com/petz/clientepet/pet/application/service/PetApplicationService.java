package br.com.petz.clientepet.pet.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PetApplicationService implements PetService {

	@Override
	public PetResponse cadastraPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[start] - PetApplicationService - cadastraPet");
		log.info("[login] - {}", idCliente);
		log.info("[finish] - PetApplicationService - cadastraPet");
		return null;
	}

}
