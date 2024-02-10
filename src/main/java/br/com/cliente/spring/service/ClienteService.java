package br.com.cliente.spring.service;

import java.util.List;

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
	
	public void deletaCliente(Long id) {
		clienteRepository.deleteById(id);
	}
}
