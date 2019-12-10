package uy.org.pmarket.shopping.integration;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;
import uy.org.pmarket.shopping.dto.ShoppingPromotionItemDTO;
import uy.org.pmarket.shopping.exception.IntegrationException;
import uy.org.pmarket.shopping.model.ShoppingItem;

@Service
public class PromotionService {

	@Autowired
    @Qualifier("circuitBreaker")
    protected CircuitBreaker circuitBreaker;
	
	public List<ShoppingPromotionItemDTO> getPromotions(List<ShoppingItem> items){
		Supplier<List<ShoppingPromotionItemDTO>> supplier = () -> {
			return promotions(items);
		};

        supplier = CircuitBreaker.decorateSupplier(this.circuitBreaker, supplier);
        return Try.ofSupplier(supplier).recover(throwable -> null).get();
	}
	
	private List<ShoppingPromotionItemDTO> promotions(List<ShoppingItem> items) {
		throw new IntegrationException("");
	}
}
