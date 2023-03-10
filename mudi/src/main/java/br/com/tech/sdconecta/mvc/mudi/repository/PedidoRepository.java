package br.com.tech.sdconecta.mvc.mudi.repository;

import br.com.tech.sdconecta.mvc.mudi.model.Pedido;
import br.com.tech.sdconecta.mvc.mudi.model.StatusPedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByStatus(StatusPedido aguardando);

    //public List<Pedido> findAll();
}
