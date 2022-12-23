package br.com.tech.sdconecta.mvc.mudi.controller;

import br.com.tech.sdconecta.mvc.mudi.dto.RequisicaoPedido;
import br.com.tech.sdconecta.mvc.mudi.model.Pedido;
import br.com.tech.sdconecta.mvc.mudi.repository.PedidoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String form(RequisicaoPedido requisicaoPedido){
        return "formulario";
    }

    @PostMapping("newInforms")
    public String newInforms(@Valid RequisicaoPedido requisicaoPedido, BindingResult result){
        if (result.hasErrors()) {
            return "formulario";
        }

        Pedido pedido = requisicaoPedido.toPedido();
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
