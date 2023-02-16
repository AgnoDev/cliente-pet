package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;
import java.util.UUID;

import br.com.petz.clientepet.pet.dominio.Pet;
import br.com.petz.clientepet.pet.dominio.Porte;
import br.com.petz.clientepet.pet.dominio.Sexo;
import br.com.petz.clientepet.pet.dominio.TipoPet;
import lombok.Value;

@Value
public class PetDetalhadoResponse {
	private UUID idPet;
	private String nomePet;
	private Porte porte;
	private TipoPet tipo;
	private String microchip;
	private String raca;
	private Sexo sexo;
	private String pelagemCor;
	private LocalDate dataNascimento;
	private String rga;
	private Integer peso;

	public PetDetalhadoResponse(Pet pet) {
		this.idPet = pet.getIdPet();
		this.nomePet = pet.getNomePet();
		this.porte = pet.getPorte();
		this.tipo = pet.getTipo();
		this.microchip = pet.getMicrochip();
		this.raca = pet.getRaca();
		this.sexo = pet.getSexo();
		this.pelagemCor = pet.getPelagemCor();
		this.dataNascimento = pet.getDataNascimento();
		this.rga = pet.getRga();
		this.peso = pet.getPeso();

	}
}