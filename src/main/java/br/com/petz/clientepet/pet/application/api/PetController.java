package br.com.petz.clientepet.pet.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class PetController implements PetAPI {

	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[start] - PetController - postPet");
		log.info("[login] - {}", idCliente);
		log.info("[finish] - PetController - postPet");
		return null;
	}

}
