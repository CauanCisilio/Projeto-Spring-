package br.com.cliente.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cliente.spring.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
