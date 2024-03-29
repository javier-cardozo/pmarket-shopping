package uy.org.pmarket.shopping.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class ShoppingMissingDTO {

	private String id;
	@NotEmpty
	private String name;
	@NotEmpty
	private AudienceDTO audience;
	private Date created;
	private Date updated;
	private Date expired;
	private ShoppingSummary summary;
	@NotEmpty
	private Boolean eliminated;
	private List<ShoppingItemDTO> items;
	private String version;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AudienceDTO getAudience() {
		return audience;
	}
	public void setAudience(AudienceDTO audience) {
		this.audience = audience;
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
	public Date getExpired() {
		return expired;
	}
	public void setExpired(Date expired) {
		this.expired = expired;
	}
	public ShoppingSummary getSummary() {
		return summary;
	}
	public void setSummary(ShoppingSummary summary) {
		this.summary = summary;
	}
	public void addSummary(Integer items, Double total) {
		setSummary(new ShoppingSummary(items, total));
	}
	public Boolean getEliminated() {
		return eliminated;
	}
	public void setEliminated(Boolean eliminated) {
		this.eliminated = eliminated;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public List<ShoppingItemDTO> getItems() {
		return items;
	}
	public void setItems(List<ShoppingItemDTO> items) {
		this.items = items;
	}
	
}
