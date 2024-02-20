package br.com.cliente.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cliente.spring.entity.Produto;
import br.com.cliente.spring.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public void salvarProduto(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public List<Produto>listaProdutos(){
		List<Produto> produtos = produtoRepository.findAll();
		return produtos;
	}
	
}
