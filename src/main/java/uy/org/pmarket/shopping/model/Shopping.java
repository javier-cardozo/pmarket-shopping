package uy.org.pmarket.shopping.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

public class Shopping {

	private String name;
	private List<ShoppingItem> items;
	private Audience audience;
	private Boolean eliminated;
	@CreatedDate
	private Date created;
	@LastModifiedDate
	private Date updated;
	@Version String version;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ShoppingItem> getItems() {
		return items;
	}
	public void setItems(List<ShoppingItem> items) {
		this.items = items;
	}
	
	public Audience getAudience() {
		return audience;
	}
	public void setAudience(Audience audience) {
		this.audience = audience;
	}
	public Boolean getEliminated() {
		return eliminated;
	}
	public void setEliminated(Boolean eliminated) {
		this.eliminated = eliminated;
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
}
