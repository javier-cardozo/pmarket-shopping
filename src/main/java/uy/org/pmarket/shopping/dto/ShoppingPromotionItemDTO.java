package uy.org.pmarket.shopping.dto;

import java.util.List;

public class ShoppingPromotionItemDTO extends ShoppingItemDTO {
	
	private List<String> promotions;
	
	public List<String> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<String> promotions) {
		this.promotions = promotions;
	}
	
}
