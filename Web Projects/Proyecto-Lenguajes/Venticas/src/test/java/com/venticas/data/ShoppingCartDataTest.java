package com.venticas.data;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venticas.domain.Item;
import com.venticas.domain.ShoppingCart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartDataTest {

	@Autowired
	ShoppingCartData shopping;
	@Test
    public void insertShoppingCart() {
		ShoppingCart cart = new ShoppingCart();
		cart.setDateCreated(new Date().toString());
		cart.getCustomer().setId(10);
        shopping.insertShoppingCart(cart);
    }
	
	@Test
    public void insertShoppingCarItem() {
		ShoppingCart cart = new ShoppingCart();
		cart.setDateCreated(new Date().toString());
		cart.setId(12);
		cart.getCustomer().setId(10);
		Item item = new Item();
		item.setShoppingCart(cart);
		item.getProduct().setId(36);
		item.setQuantity(1);
        shopping.insertItem(item);
    }
}
