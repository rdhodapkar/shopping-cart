package com.hmrc.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;

import junit.framework.Assert;

import org.junit.Test;

public class ShoppingCartTest {
	
	
	@Test
	public void test_when_one_apple_added_to_cart_then_cart_contains_correct_items() {
		
		ShoppingCart cart = new ShoppingCart();
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		Assert.assertEquals(1, cart.getTotalNumberOfItems());
		Assert.assertTrue(cart.contains(new Item("Apple")));
		
	}
	
	@Test
	public void test_when_add_one_apple_and_one_orange_to_cart_then_cart_contains_correct_items() {
		
		ShoppingCart cart = new ShoppingCart();
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		cart.addItems(new Item(ItemType.ORANGE.getDescription()));
		
		Assert.assertEquals(2, cart.getTotalNumberOfItems());
		Assert.assertTrue(cart.contains(new Item("Apple")));
		Assert.assertTrue(cart.contains(new Item("Orange")));
	}
	
	@Test
	public void test_when_add_two_apples_then_cart_contains_correct_items() {
		
		ShoppingCart cart = new ShoppingCart();
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		
		Assert.assertEquals(2, cart.getTotalNumberOfItems());
	}
	
	@Test
	public void test_checkout_when_no_items_added_then_price_zero() {
		ShoppingCart cart = new ShoppingCart();
		Assert.assertEquals(new BigDecimal(0.0),  cart.checkout());
		
	}
	
	@Test
	public void test_checkout_when_one_apple_in_cart_then_calculate_total_price() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		Assert.assertEquals(new BigDecimal(.60).setScale(2, RoundingMode.CEILING),  cart.checkout());
		
	}
	
	@Test
	public void test_checkout_when_two_apples_in_cart_then_calculate_total_price() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		Assert.assertEquals(new BigDecimal(1.20).setScale(2, RoundingMode.CEILING),  cart.checkout());
		
	}
	
	@Test
	public void test_checkout_when_three_oranges_in_cart_then_calculate_total_price() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItems(new Item(ItemType.ORANGE.getDescription()));
		cart.addItems(new Item(ItemType.ORANGE.getDescription()));
		cart.addItems(new Item(ItemType.ORANGE.getDescription()));
		Assert.assertEquals(new BigDecimal(.75).setScale(2, RoundingMode.CEILING),  cart.checkout());
		
	}
	
	@Test
	public void test_checkout_when_three_apples_and_one_orange_in_cart_then_calculate_total_price() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		cart.addItems(new Item(ItemType.APPLE.getDescription()));
		cart.addItems(new Item(ItemType.ORANGE.getDescription()));
		Assert.assertEquals(new BigDecimal(2.05).setScale(2, RoundingMode.CEILING),  cart.checkout());
		
	}

}
