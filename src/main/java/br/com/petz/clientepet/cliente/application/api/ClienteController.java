package br.com.petz.clientepet.cliente.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.petz.clientepet.cliente.application.service.ClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteController implements ClienteApi {
	private final ClienteService clienteService;

	@Override
	public ClienteResponse postCliente(ClienteRequest clienteRequest) {
		log.info("[start] - ClienteController - postCliente");
		ClienteResponse clienteCriado = clienteService.criaCliente(clienteRequest);
		log.info("[finish] - ClienteController - postCliente");
		return clienteCriado;
	}

	@Override
	public List<ClienteListResponse> getTodosClientes() {
		log.info("[start] - ClienteController - getTodosClientes");
		List<ClienteListResponse> clientes = clienteService.buscaTodosClientes();
		log.info("[finish] - ClienteController - getTodosClientes");
		return clientes;
	}

	@Override
	public ClienteDetalhadoResponse getClientePorId(UUID idCliente) {
		log.info("[start] - ClienteController - getClientePorId");
		log.info("[login] - {}", idCliente);
		log.info("[finish] - ClienteController - getClientePorId");
		ClienteDetalhadoResponse clienteDetalhado = clienteService.buscaClientePorId(idCliente);
		return clienteDetalhado;
	}

	@Override
	public void deletaClientePorId(UUID idCliente) {
		log.info("[start] - ClienteController - deletaClientePorId");
		log.info("[login] - {}", idCliente);
		log.info("[finish] - ClienteController - deletaClientePorId");

	}
}
