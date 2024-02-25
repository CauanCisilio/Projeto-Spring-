package br.com.cliente.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.cliente.spring.entity.Cliente;
import br.com.cliente.spring.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	@Query("SELECT p FROM Pedido p INNER JOIN p.cliente c")
	List<Pedido> listaDosPedidosDosClientes();

	@Query("SELECT p FROM Pedido p WHERE p.id = :id")
	Pedido encontraPedido(Long id);
}
