package br.com.cliente.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cliente.spring.entity.Cliente;
import br.com.cliente.spring.service.ClienteService;

@Controller
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String form() {
		return "formCliente";
	}
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String form(Cliente cliente) {
		clienteService.cadastroCliente(cliente);
		return "redirect:/cadastrarCliente";
	}
	
	@DeleteMapping("/deleCliente/{id}")
	public void deleteById() {
		clienteService.deletaCliente(null);
	}
	
	@RequestMapping("/clientes")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("listaClientes");
		Iterable <Cliente> clientes = clienteService.listaClientes();
		mv.addObject("clientes",clientes);
		return mv;
	}
}
