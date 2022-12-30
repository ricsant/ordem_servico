package br.com.gaby.sistemaos.domain;

import java.math.BigDecimal;
import java.security.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="orders_service")
@Getter
@Setter
public class OrderService {
	
    private static final long serialVersionUID = -227363534743634746L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Timestamp osDate;
	private String equipment;
	private String problem;
	private String tecnique;
	private BigDecimal price;
	
	@ManyToOne(optional = false)
	private Customer customer;
}
