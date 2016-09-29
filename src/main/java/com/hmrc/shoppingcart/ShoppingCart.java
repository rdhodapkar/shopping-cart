package com.hmrc.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		
		List<Item> listOfApple = listOf(ItemType.APPLE);
		List<Item> listOfOranges = listOf(ItemType.ORANGE);
		
		DiscountStategy twoForOne = new BuyOneGetOneFreeStrategy();
		BigDecimal discountOnApples = twoForOne.calculateDiscount(listOfApple, ItemType.APPLE);
		
		DiscountStategy threeForTwo = new ThreeForTwoStrategy();
		BigDecimal discountOnOranges = threeForTwo.calculateDiscount(listOfOranges, ItemType.ORANGE);
		
		BigDecimal totalPriceForApples = new BigDecimal(listOfApple.size()).multiply(ItemType.APPLE.getUnitPrice()).subtract(discountOnApples);
		BigDecimal totalPriceForOranges = new BigDecimal(listOfOranges.size()).multiply(ItemType.ORANGE.getUnitPrice()).subtract(discountOnOranges);
		totalPrice = totalPriceForApples.add(totalPriceForOranges).setScale(2, RoundingMode.CEILING);
		return totalPrice;
		
	}
	
	
	private List<Item> listOf(ItemType type) {
		
		List<Item> listOfProdcutByType = items.stream().filter(item -> item.getName().equals(type.getDescription())).collect(Collectors.toList());
		return listOfProdcutByType;
	}

}
