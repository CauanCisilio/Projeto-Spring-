package br.com.cliente.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cliente.spring.entity.Cliente;
import br.com.cliente.spring.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void cadastroCliente(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public List<Cliente>listaClientes(){
		return clienteRepository.findAll();
	}
	
	public Cliente deletaCliente(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (clienteOptional.isPresent()) {
	        Cliente cliente = clienteOptional.get();
	        clienteRepository.deleteById(id);
	        return cliente;
	    } else {
	        throw new RuntimeException("Cliente não encontrado com o ID: " + id);
	    }
	}
}
