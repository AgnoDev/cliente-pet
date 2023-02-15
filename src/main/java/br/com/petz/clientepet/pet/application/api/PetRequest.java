package br.com.petz.clientepet.pet.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.petz.clientepet.pet.dominio.Porte;
import br.com.petz.clientepet.pet.dominio.Sexo;
import br.com.petz.clientepet.pet.dominio.TipoPet;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class PetRequest {
	
	@NotBlank
	private String nomePet;

	@Enumerated(EnumType.STRING)
	private Porte porte;

	@NotNull
	private TipoPet tipo;

	private String microchip;

	@NotBlank
	private String raca;

	@NotNull
	private Sexo sexo;

	private String pelagemCor;

	@NotNull
	private LocalDate dataNascimento;

	private String rga;

	private Integer peso;

}
