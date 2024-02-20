package br.com.cliente.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cliente.spring.entity.Pedido;
import br.com.cliente.spring.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido>listaTodosPedidos(){
		List<Pedido> pedidos = pedidoRepository.findAll();
		return pedidos;
	}
	
	public void cadastraPedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
}
