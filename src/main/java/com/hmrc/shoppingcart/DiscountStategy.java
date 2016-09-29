package com.hmrc.shoppingcart;

import java.math.BigDecimal;
import java.util.List;

public interface DiscountStategy {
	
	public BigDecimal calculateDiscount(List<Item> items, ItemType type);

}
