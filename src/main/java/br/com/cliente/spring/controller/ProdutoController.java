package br.com.cliente.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cliente.spring.entity.Cliente;
import br.com.cliente.spring.entity.Pedido;
import br.com.cliente.spring.entity.Produto;
import br.com.cliente.spring.service.ProdutoService;

@Controller
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/produtos")
	public ModelAndView findAll() {
	    ModelAndView mv = new ModelAndView("listaProdutos");
	    List<Produto> produtos = produtoService.listaProdutos();
	    System.out.println("Produtos recuperados: " + produtos); // Adicione esta linha
	    mv.addObject("produtos", produtos); // Adicionando a lista de produtos ao ModelAndView
	    return mv;
	}
	
	 @GetMapping("/produtos")
	    public String mostrarFormularioNovoPedido(Model model) {
	        List<Produto> produtos =produtoService.listaProdutos();
	        model.addAttribute("produtos", produtos);
	        model.addAttribute("produto", new Produto());
	        return "produtos";
	    }
}
