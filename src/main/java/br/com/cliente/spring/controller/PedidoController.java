package br.com.cliente.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cliente.spring.entity.Cliente;
import br.com.cliente.spring.entity.Pedido;
import br.com.cliente.spring.service.PedidoService;

@Controller
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;
    
    @RequestMapping("/pedidos")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView("listaPedidos");
        List<Pedido> pedidos = pedidoService.listaTodosPedidos();
        
        mv.addObject("pedidos", pedidos);
        return mv;
    }
}
