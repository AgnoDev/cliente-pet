package br.com.petz.clientepet.pet.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetAlteraRequest;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetDetalhadoResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.dominio.Pet;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
	private final ClienteService clienteService;
	private final PetRepository petRepository;

	@Override
	public PetResponse cadastraPet(UUID idCliente, @Valid PetRequest petRequest) {
		log.info("[start] - PetApplicationService - cadastraPet");
		log.info("[login] - {}", idCliente);
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
		log.info("[finish] - PetApplicationService - cadastraPet");
		return new PetResponse(pet.getIdPet());
	}

	@Override
	public List<PetClienteListResponse> buscaPetsDoCliente(UUID idCliente) {
		log.info("[start] - PetApplicationService - buscaPetsDoCliente");
		clienteService.buscaClientePorId(idCliente);
		List<Pet> petsDoCliente = petRepository.buscaPetsDoCliente(idCliente);
		log.info("[finish] - PetApplicationService - buscaPetsDoCliente");
		return PetClienteListResponse.converte(petsDoCliente);
	}

	@Override
	public PetDetalhadoResponse buscaPetsDoCliente(UUID idCliente, UUID idPet) {
		log.info("[start] - PetApplicationService - buscaPetsDoCliente");
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.buscaPetDetalhado(idPet);
		log.info("[finish] - PetApplicationService - buscaPetsDoCliente");
		return new PetDetalhadoResponse(pet);
	}

	@Override
	public void deletaPetDoCliente(UUID idCliente, UUID idPet) {
		log.info("[start] - PetApplicationService - deletaPetDoCliente");
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.buscaPetDetalhado(idPet);
		petRepository.deletaPetDetalhado(pet);
		log.info("[finish] - PetApplicationService - deletaPetDoCliente");		
	}

	@Override
	public void alteraPetDoCliente(UUID idCliente, UUID idPet, PetAlteraRequest petAlteraRequest) {
		log.info("[start] - PetApplicationService - alteraPetDoCliente");
		clienteService.buscaClientePorId(idCliente);
		Pet pet = petRepository.buscaPetDetalhado(idPet);
		pet.altera(petAlteraRequest);
		petRepository.salvaPet(pet);
		log.info("[finish] - PetApplicationService - alteraPetDoCliente");			
	}

}





