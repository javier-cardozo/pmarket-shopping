package uy.org.pmarket.shopping.dto;

import uy.org.pmarket.shopping.model.AudienceType;

public class AudienceDTO {

	private String name;
	private AudienceType type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AudienceType getType() {
		return type;
	}
	public void setType(AudienceType type) {
		this.type = type;
	}
	
}
