package br.com.petz.clientepet.pet.dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "UUID", name = "idPet", updatable = false, unique = true, nullable = false)
	private UUID idPet;

	@NotBlank
	private String nomePet;

	@Enumerated(EnumType.STRING)
	private Porte porte;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPet tipo;

	private String microchip;

	@NotBlank
	private String raca;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	private String pelagemCor;

	@NotNull
	private LocalDate dataNascimento;

	private String rga;

	private Integer peso;

	private LocalDateTime dataHoraDoCadastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
}
