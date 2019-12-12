package uy.org.pmarket.shopping.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.vavr.control.Try;
import uy.org.pmarket.shopping.dto.ShoppingPromotionItemDTO;
import uy.org.pmarket.shopping.model.ShoppingItem;

@Service
public class PromotionService {

	@Autowired
    @Qualifier("circuitBreaker")
    protected CircuitBreaker circuitBreaker;
	
	public List<ShoppingPromotionItemDTO> getPromotions(List<ShoppingItem> items) {
		return items.stream().map(this::getPromotion).collect(Collectors.toList());
	}
	
	public ShoppingPromotionItemDTO getPromotion(ShoppingItem item) {
		ShoppingPromotionItemDTO dto = parser(item);
		List<String> promotions = invoke(item);
		dto.setPromotions(promotions);
		return dto;
	}
	
	public List<String> invoke(ShoppingItem item) {
		Supplier<List<String>> supplier = () -> {
			//Invocar servicio de promotions
			return new ArrayList<>();
		};

        supplier = CircuitBreaker.decorateSupplier(this.circuitBreaker, supplier);
        return Try.ofSupplier(supplier).recover(throwable -> new ArrayList<>()).get();
	}
	
	private ShoppingPromotionItemDTO parser(ShoppingItem item) {
		ShoppingPromotionItemDTO dto = new ShoppingPromotionItemDTO();
		dto.setCategory(item.getCategory());
		dto.setCode(item.getCode());
		dto.setPrice(item.getPrice());
		dto.setQuantity(item.getQuantity());
		return dto;
	}
}
