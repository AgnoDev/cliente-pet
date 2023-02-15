package br.com.petz.clientepet.pet.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.pet.application.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PetController implements PetAPI {

	private final PetService petService;

	@Override
	public PetResponse postPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[start] - PetController - postPet");
		log.info("[login] - {}", idCliente);
		PetResponse pet = petService.cadastraPet(idCliente, petRequest);
		log.info("[finish] - PetController - postPet");
		return pet;
	}

}
