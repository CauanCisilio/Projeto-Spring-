package br.com.cliente.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cliente.spring.entity.Cliente;
import br.com.cliente.spring.entity.Pedido;
import br.com.cliente.spring.repository.PedidoRepository;
import br.com.cliente.spring.service.ClienteService;
import br.com.cliente.spring.service.PedidoService;
import java.util.ArrayList;


@Controller
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @Autowired PedidoRepository repository;
    
    @Autowired
    private ClienteService clienteService;
    
    @RequestMapping(value="/cadastraPedido", method=RequestMethod.GET)
	public String form() {
		return "formCliente";
	}
    
	@RequestMapping(value="/cadastrarPedido", method=RequestMethod.POST)
	public String form(Pedido pedido) {
		pedidoService.cadastraPedido(pedido);
		return "redirect:/cadastraPedido";
	}
	
    
    @RequestMapping("/pedidos")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("listaPedidos");
        List<Pedido> pedidos = pedidoService.listaTodosPedidos();
        
        mv.addObject("pedidos", pedidos);
        return mv;
    }
    
    @GetMapping("/pedidos/novo")
    public String mostrarFormularioNovoPedido(Model model) {
        List<Cliente> clientes = clienteService.listaClientes();
        model.addAttribute("clientes", clientes);
        model.addAttribute("pedido", new Pedido());
        return "formPedido";
    }
    
    @PostMapping("/pedidos/salvar")
    public String salvarPedido(@ModelAttribute("pedido")Pedido pedido) {
        pedidoService.cadastraPedido(pedido);
        return "redirect:/pedidos"; 
    }
    
    @GetMapping("/pedidos/")
    public ModelAndView buscaPorId(@RequestParam("id") Long id) {
        ModelAndView mv = new ModelAndView("listaPedidos");
        Pedido pedido = repository.encontraPedido(id);
        List<Pedido> pedidos = new ArrayList<>();
        if (pedido != null) {
            pedidos.add(pedido);
        }if(pedido ==null){

        }   
        mv.addObject("pedidos", pedidos);
        return mv;
    }
    
}
