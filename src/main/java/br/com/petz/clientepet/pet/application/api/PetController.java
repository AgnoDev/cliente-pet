package br.com.petz.clientepet.pet.application.api;

import java.util.List;
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

	@Override
	public List<PetClienteListResponse> getPetsDoCliente(UUID idCliente) {
		log.info("[start] - PetController - getPetsDoCliente");
		log.info("[login] - {}", idCliente);
		List<PetClienteListResponse> petsDoCliente = petService.buscaPetsDoCliente(idCliente);
		log.info("[finish] - PetController - getPetsDoCliente");
		return petsDoCliente;
	}

	@Override
	public PetDetalhadoResponse getPetDetalhadoCliente(UUID idCliente, UUID idPet) {
		log.info("[start] - PetController - getPetDetalhadoCliente");
		log.info("[idCliente] - {} // [idPet] - {}", idCliente, idPet);
		PetDetalhadoResponse pet  = petService.buscaPetsDoCliente(idCliente, idPet);
		log.info("[finish] - PetController - getPetDetalhadoCliente");
		return pet;
	}

	@Override
	public void deletePetDetalhadoCliente(UUID idCliente, UUID idPet) {
		log.info("[start] - PetController - deletePetDetalhadoCliente");
		log.info("[idCliente] - {} // [idPet] - {}", idCliente, idPet);
		petService.deletaPetDoCliente(idCliente, idPet);
		log.info("[finish] - PetController - deletePetDetalhadoCliente");
		
	}

}



