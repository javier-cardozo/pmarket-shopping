package uy.org.pmarket.shopping.dto;

public class ShoppingSummary {

	private Integer items;
	private Double total;
	
	public ShoppingSummary(Integer items, Double total) {
		super();
		this.items = items;
		this.total = total;
	}
	public Integer getItems() {
		return items;
	}
	public void setItems(Integer items) {
		this.items = items;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	
}
