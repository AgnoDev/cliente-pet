package br.com.petz.clientepet.pet.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.application.service.PetRepository;
import br.com.petz.clientepet.pet.dominio.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
	private final PetSpringDataJPARepository petSpringDataJPARepository;

	@Override
	public Pet salvaPet(Pet pet) {
		log.info("[start] - PetInfraRepository - salvaPet");
		petSpringDataJPARepository.save(pet);
		log.info("[finish] - PetInfraRepository - salvaPet");
		return pet;
	}

	@Override
	public List<Pet> buscaPetsDoCliente(UUID idCliente) {
		log.info("[start] - PetInfraRepository - buscaPetsDoCliente");
		var pets = petSpringDataJPARepository.findByIdClienteTutor(idCliente);
		log.info("[finish] - PetInfraRepository - buscaPetsDoCliente");
		return pets;
	}

	@Override
	public Pet buscaPetDetalhado(UUID idPet) {
		log.info("[start] - PetInfraRepository - buscaPetDetalhado");
		var pet = petSpringDataJPARepository.findById(idPet)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "PET NÃO ENCONTRADO"));
		log.info("[finish] - PetInfraRepository - buscaPetDetalhado");
		return pet;
	}

	@Override
	public void deletaPetDetalhado(Pet pet) {
		log.info("[start] - PetInfraRepository - deletaPetDetalhado");
		petSpringDataJPARepository.delete(pet);
		log.info("[finish] - PetInfraRepository - deletaPetDetalhado");
	}
}
