package com.hmrc.shoppingcart;

import java.math.BigDecimal;

/**
 * COnfigurable class to list all items sold in the shop. 
 * As per the requirement the shop only sells Apple and orange.
 * @author rd
 *
 */
public enum ItemType {

    APPLE("Apple", new BigDecimal(0.60)),
    ORANGE("Orange", new BigDecimal(0.25));

    private final String description;
    private final BigDecimal unitPrice;

    ItemType(String description, BigDecimal unitPrice) {
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
    
    public static ItemType[] getAllItemsSoldInShop() {
    	return ItemType.values();
    	
    }

	public static BigDecimal getPrice(String name) {
		for(ItemType item : getAllItemsSoldInShop()) {
			if(item.description == name) {
				return item.unitPrice;
			}
		}
		return BigDecimal.ZERO;
	}

}
