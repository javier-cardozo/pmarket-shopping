package uy.org.pmarket.shopping.dto;

import java.util.List;

public class ShoppingAudienceDTO {
	
	private String id;
	private AudienceDTO audience;
	private List<Long> shoppings;
	
	public AudienceDTO getAudience() {
		return audience;
	}
	public void setAudience(AudienceDTO audience) {
		this.audience = audience;
	}
	public List<Long> getShoppings() {
		return shoppings;
	}
	public void setShoppings(List<Long> shoppings) {
		this.shoppings = shoppings;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
