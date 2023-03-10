package br.com.tech.sdconecta.mvc.mudi.controller;

import br.com.tech.sdconecta.mvc.mudi.model.Pedido;
import br.com.tech.sdconecta.mvc.mudi.model.StatusPedido;
import br.com.tech.sdconecta.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private PedidoRepository repository;

    @GetMapping
    public String home(Model model) {
        List<Pedido> pedidos = repository.findAll();
        model.addAttribute("pedidos",pedidos);
        return "home";
    }

    @GetMapping("/{status}")
    public String porStatus(@PathVariable("status") String status, Model model) {
        List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }
}
