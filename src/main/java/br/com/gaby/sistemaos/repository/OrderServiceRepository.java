package br.com.gaby.sistemaos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gaby.sistemaos.domain.OrderService;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, Long> {

}
