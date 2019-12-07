package uy.org.pmarket.shopping.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shopping_audience")
@CompoundIndex(def = "{'audience.name':1}", name = "audience_name_index")
public class ShoppingAudience {
	
	@Id
	private String id;
	private Audience audience;
	private List<String> shoppings;
	@LastModifiedDate
	private Date updated;
	@Version String version;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Audience getAudience() {
		return audience;
	}
	public void setAudience(Audience audience) {
		this.audience = audience;
	}
	public List<String> getShoppings() {
		return shoppings;
	}
	public void setShoppings(List<String> shoppings) {
		this.shoppings = shoppings;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void add(String shoppingId) {
		if (shoppings == null) {
			shoppings = new ArrayList<>();
		}
		
		if (!shoppings.contains(shoppingId)) {
			shoppings.add(shoppingId);
		}
	}
}
