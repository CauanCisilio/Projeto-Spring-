package br.com.cliente.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cliente.spring.entity.Cliente;
import br.com.cliente.spring.service.ClienteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
	
	@RequestMapping("/clientes")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("listaClientes");
		List<Cliente> clientes = clienteService.listaClientes();
		
		mv.addObject("clientes",clientes);
		return mv;
	}
	
	@RequestMapping("/deletar")
	public String deletarCliente(Long id) {
		Cliente cliente = clienteService.deletaCliente(id);
		return "redirect:/clientes";
	}
}
