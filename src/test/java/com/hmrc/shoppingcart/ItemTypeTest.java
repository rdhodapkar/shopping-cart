package com.hmrc.shoppingcart;

import java.math.BigDecimal;

import junit.framework.Assert;

import org.junit.Test;

public class ItemTypeTest {

	@Test
	public void test_does_shop_sell_apple_and_orange() {
		
		ItemType[] items = {ItemType.APPLE, ItemType.ORANGE};
		org.junit.Assert.assertArrayEquals(items, ItemType.getAllItemsSoldInShop());
		
	}

	@Test
	public void test_given_apple_then_get_price() {
		
		Assert.assertEquals(new BigDecimal(.60), ItemType.APPLE.getUnitPrice());
		
	}
	
	@Test
	public void test_given_oranges_then_get_price() {
		
		Assert.assertEquals(new BigDecimal(.25), ItemType.ORANGE.getUnitPrice());
		
	}
}
