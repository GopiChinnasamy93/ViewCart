package com.shopping;

import java.util.Objects;

public class Cart {
	private String productid;
	private String make;
	private String model;
	private String color;
	private int price;
	private int Qty;
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Qty, color, make, model, price, productid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		return Qty == other.Qty && Objects.equals(color, other.color) && Objects.equals(make, other.make)
				&& Objects.equals(model, other.model) && price == other.price
				&& Objects.equals(productid, other.productid);
	}
	@Override
	public String toString() {
		return "Cart [productid=" + productid + ", make=" + make + ", model=" + model + ", color=" + color + ", price="
				+ price + ", Qty=" + Qty + "]";
	}
	
	public Cart(String productid, String make, String model, String color, int price, int qty) {
		super();
		this.productid = productid;
		this.make = make;
		this.model = model;
		this.color = color;
		this.price = price;
		Qty = qty;
	}
	


}
