package com.venticas.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.venticas.domain.Address;
import com.venticas.domain.Customer;
import com.venticas.domain.Item;
import com.venticas.domain.Product;
import com.venticas.domain.ShoppingCart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDataTest {

    @Autowired
    OrderData orderData;

    @Test
    public void updateStatusTest() {
        orderData.updateOrderStatus(3,5);
    }

    @Test
    public void saveOrder() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(12);

        List<Address> addresses = new ArrayList<>();
        Address address = new Address();
        address.setId(9);
        addresses.add(address);

        Customer customer = new Customer();
        customer.setId(11);
        customer.setAddress(addresses);

        Product product = new Product();
        product.setId(26);
        product.setPrice(5000);

        Item item = new Item();
        item.setProduct(product);
        item.setQuantity(5);

        List<Item> items = new ArrayList<>();
        items.add(item);

        shoppingCart.setCustomer(customer);
        shoppingCart.setItems(items);
        shoppingCart.setId(12);
        //.assertTrue(orderData.saveOrder("addressTest", "11", shoppingCart));
    }

}
