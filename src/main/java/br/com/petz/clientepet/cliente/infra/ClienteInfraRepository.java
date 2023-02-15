package br.com.petz.clientepet.cliente.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor

public class ClienteInfraRepository implements ClienteRepository {

	private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

	@Override
	public Cliente salva(Cliente cliente) {
		log.info("[start] - ClienteInfraRepository - salvaCliente");
		clienteSpringDataJPARepository.save(cliente);
		log.info("[finish] - ClienteInfraRepository - salvaCliente");
		return cliente;
	}

	@Override
	public List<Cliente> buscaTodosClientes() {
		log.info("[start] - ClienteInfraRepository - buscaTodosClientes");
		List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
		log.info("[finish] - ClienteInfraRepository - buscaTodosClientes");
		return todosClientes;
	}

	@Override
	public Cliente buscaClientePorId(UUID idCliente) {
		log.info("[start] - ClienteInfraRepository - buscaClientePorId");
		Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
				.orElseThrow(() -> new RuntimeException("CLIENTE NÃO ENCONTRADO!"));
		log.info("[finish] - ClienteInfraRepository - buscaClientePorId");
		return cliente;
	}

	@Override
	public void deletaClientePorId(UUID idCliente) {
		log.info("[start] - ClienteInfraRepository - deletaClientePorId");
		clienteSpringDataJPARepository.deleteById(idCliente);
		log.info("[finish] - ClienteInfraRepository - deletaClientePorId");
	}
}
