package com.hmrc.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ThreeForTwoStrategy implements DiscountStategy {

	/**
	 * This method calculates the discount. It is assumed that the list has same kind of Items. 
	 */
	public BigDecimal calculateDiscount(List<Item> items, ItemType type) {
		
		BigDecimal totalDiscount = items.size() < minNumberOfProducts() ? BigDecimal.ZERO : discount(items, type); 
		return totalDiscount;
	}

	

	private BigDecimal discount(List<Item> items, ItemType type) {
        int numToApplyFullPrice = items.size() % minNumberOfProducts();
        int numToApplyOffer = items.size() - numToApplyFullPrice;
        
        BigDecimal totalPriceWithoutDiscount = type.getUnitPrice().multiply(new BigDecimal(numToApplyOffer));
        return  totalPriceWithoutDiscount.subtract(type.getUnitPrice().multiply(new BigDecimal(.66)).multiply(new BigDecimal(numToApplyOffer))).setScale(2, RoundingMode.DOWN);
        
	}


	public int minNumberOfProducts() {
		
		return 3;
	}
	

}
