package br.com.petz.clientepet.cliente.application.api;

import java.time.LocalDate;

import br.com.petz.clientepet.cliente.domain.Sexo;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class ClienteAlteraRequest {
		@NotBlank
		private String nomeCompleto;
		@NotBlank
		private String celular;
		private String telefone;
		@Enumerated(EnumType.STRING)
		private Sexo sexo;
		@NotNull
		private LocalDate dataNascimento;
		@NotNull
		private Boolean aceitaTermos;
}
