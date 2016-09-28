package com.hmrc.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private List<Item> items = null;

	public ShoppingCart() {
		items = new ArrayList<Item>();
	}
	
	public int getTotalNumberOfItems() {
		return items.size();
		
	}

	public void addItems(Item item) {
		items.add(item);
	}

	public boolean contains(Item item) {
		return items.contains(item);
	}

	public BigDecimal checkout() {
		BigDecimal totalPrice;
		totalPrice = items.size() == 0 ? new BigDecimal(0.0) : calculateTotalPrice();
		return totalPrice;
		
	}

	private BigDecimal calculateTotalPrice() {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for(Item item : items) {
            totalPrice = totalPrice.add(item.getPrice());
		}
		return totalPrice.setScale(2, RoundingMode.CEILING);
	}

}
