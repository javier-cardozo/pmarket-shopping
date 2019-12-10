package uy.org.pmarket.shopping.dto;

import java.util.List;

public class ShoppingCartPromotionDTO {

	private ShoppingCartDTO shoppingCartDTO;
	private List<ShoppingPromotionItemDTO> promotions;
	
	public ShoppingCartPromotionDTO(ShoppingCartDTO shoppingCartDTO, List<ShoppingPromotionItemDTO> promotions) {
		super();
		this.shoppingCartDTO = shoppingCartDTO;
		this.promotions = promotions;
	}
	
	public ShoppingCartDTO getShoppingCartDTO() {
		return shoppingCartDTO;
	}
	public void setShoppingCartDTO(ShoppingCartDTO shoppingCartDTO) {
		this.shoppingCartDTO = shoppingCartDTO;
	}
	public List<ShoppingPromotionItemDTO> getPromotions() {
		return promotions;
	}
	public void setPromotions(List<ShoppingPromotionItemDTO> promotions) {
		this.promotions = promotions;
	}
	
}
