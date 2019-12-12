package uy.org.pmarket.shopping.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shopping_cart")
public class ShoppingCart extends Shopping {

	@Id
	private String id;
	private String store;
	private String chain;
	private String qr;
	private StatusCart state;
	private String shoppingMissingId;
	private List<Audience> audiences;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getChain() {
		return chain;
	}
	public void setChain(String chain) {
		this.chain = chain;
	}
	public String getQr() {
		return qr;
	}
	public void setQr(String qr) {
		this.qr = qr;
	}
	public StatusCart getState() {
		return state;
	}
	public void setState(StatusCart state) {
		this.state = state;
	}
	public String getShoppingMissingId() {
		return shoppingMissingId;
	}
	public void setShoppingMissingId(String shoppingMissingId) {
		this.shoppingMissingId = shoppingMissingId;
	}
	public List<Audience> getAudiences() {
		return audiences;
	}
	public void setAudiences(List<Audience> audiences) {
		this.audiences = audiences;
	}
	
}
