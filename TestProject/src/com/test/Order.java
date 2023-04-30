package com.test;

public class Order {
	private final Product product;
	private final int quantity;

	public Order(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public double getValue() {
		return product.getPrice()*quantity;
	}

	public Product getItem() {

		return product;
	}
}
