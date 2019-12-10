package uy.org.pmarket.shopping.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import uy.org.pmarket.shopping.model.ShoppingItem;

public class ShoppingCartDTO {

	private Long id;
	@NotEmpty
	private String store;
	@NotEmpty
	private String chain;
	private String qr;
	private String name;
	private List<AudienceDTO> audiences;
	@NotEmpty
	private Boolean eliminated;
	@NotEmpty
	private String shoppingMissingId;
	private List<ShoppingItem> items;
	private Date created;
	private Date updated;
	private String version;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public List<AudienceDTO> getAudiences() {
		return audiences;
	}
	public void setAudiences(List<AudienceDTO> audiences) {
		this.audiences = audiences;
	}
	public Boolean getEliminated() {
		return eliminated;
	}
	public void setEliminated(Boolean eliminated) {
		this.eliminated = eliminated;
	}
	public String getShoppingMissingId() {
		return shoppingMissingId;
	}
	public void setShoppingMissingId(String shoppingMissingId) {
		this.shoppingMissingId = shoppingMissingId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public List<ShoppingItem> getItems() {
		return items;
	}
	public void setItems(List<ShoppingItem> items) {
		this.items = items;
	}
	
}
