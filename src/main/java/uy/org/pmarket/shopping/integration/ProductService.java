package uy.org.pmarket.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;

public class ProductService {

	@Autowired
    @Qualifier("circuitBreaker")
    protected CircuitBreaker circuitBreaker;
}
