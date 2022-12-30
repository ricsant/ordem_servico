package br.com.gaby.sistemaos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gaby.sistemaos.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
