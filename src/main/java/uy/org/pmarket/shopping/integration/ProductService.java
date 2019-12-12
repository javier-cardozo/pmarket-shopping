package uy.org.pmarket.shopping.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;
import uy.org.pmarket.shopping.dto.ShoppingItemDTO;
import uy.org.pmarket.shopping.dto.ShoppingPromotionItemDTO;
import uy.org.pmarket.shopping.exception.IntegrationPromotionException;
import uy.org.pmarket.shopping.model.ShoppingItem;

@Service
public class ProductService {

	@Autowired
    @Qualifier("circuitBreaker")
    protected CircuitBreaker circuitBreaker;
	@Autowired
	private PromotionService promotionService;
	
	public ShoppingPromotionItemDTO getProduct(ShoppingItem itemCart, String chain, String store) {
		ShoppingItem item = invoke(itemCart, chain, store);
		return promotionService.getPromotion(item);
	}
	
	private ShoppingItem invoke(ShoppingItem item, String chain, String store) {
		Supplier<ShoppingItem> supplier = () -> {
			//Invocar servicio de promotions
			return null;
		};

        supplier = CircuitBreaker.decorateSupplier(this.circuitBreaker, supplier);
        return Try.ofSupplier(supplier).recover(throwable -> null).get();
	}
	
	
}
