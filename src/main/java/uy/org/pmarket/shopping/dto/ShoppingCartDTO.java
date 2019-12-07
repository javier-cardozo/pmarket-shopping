package uy.org.pmarket.shopping.dto;

import java.util.Date;
import java.util.List;

import uy.org.pmarket.shopping.model.Audience;

public class ShoppingCartDTO {

	private Long id;
	private String store;
	private String chain;
	private String qr;
	private String name;
	private List<Audience> audiences;
	private Date created;
	private Date updated;
	
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
	public List<Audience> getAudiences() {
		return audiences;
	}
	public void setAudiences(List<Audience> audiences) {
		this.audiences = audiences;
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
	
}
