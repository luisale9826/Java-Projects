package com.venticas.data;


import com.venticas.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDataTest {

    @Autowired
    ProductData productData;

    @Test
    public void findProductByFamily() {
        List<Product> products = productData.findProductByFamily(7);
        Assert.assertNotNull(products);
        Assert.assertFalse(products.isEmpty());
    }

    @Test
    public void findAllProductsTest() {
        List<Product> products = productData.findAllProducts();
        Assert.assertNotNull(products);
        Assert.assertFalse(products.isEmpty());
    }

    @Test
    public void insertProductTest() throws Exception {
        Product product = new Product();
        product.setName("Samsung 55NU7405 - Smart TV de 55\" 4K UHD HDR ");
        product.setPrice(500000);
        product.setUnitsOnStock(5);
        product.getImagenes().add(new ProductImage());
        product.setCategory(new ProductCategory(2, "", new Tax()));
        product.setDescription("Televisores Samsung NU7405 con 4K UHD y HDR.");
        productData.insertProduct(product);
    }

    @Test
    public void getByNameTest() {
        List<Product> products = productData.findByName("A");
        Assert.assertNotNull(products);
        Assert.assertTrue(!products.isEmpty());
    }
    
    @Test
    public void getByFamily() {
        List<Product> products = productData.findByFamily("Video");
        Assert.assertNotNull(products);
        Assert.assertTrue(!products.isEmpty());
    }

    @Test
    public void deleteProductTest() {
        Assert.assertTrue(productData.deleteProduct(25));
    }

    @Test
    public void findProductByIdTest() {
        Product product = productData.findProductById(26);
        Assert.assertNotNull(product);
    }

    @Test
    public void updateProductTest() {
        Product product = new Product();
        product.setId(26);
        product.setName("Apple MacBook Pro");
        product.getCategory().setId(8);
        product.setDescription("Dual-core 7th-generation Intel Core i5 processor\n" +
                " Brilliant Retina display\n" +
                " Intel Iris Plus Graphics 640\n" +
                " Ultrafast SSD\n" +
                " Two Thunderbolt 3 (USB-C) ports\n" +
                " Up to 10 hours of battery life\n" +
                " Force Touch trackpad macOS Mojave, inspired by pros but designed for everyone, with Dark Mode, Stacks, easier screenshots, new built-in apps, and more\n" +
                " ");
        product.setUnitsOnStock(5);
        product.setPrice(450000);

        Family family1 = new Family();
        family1.setId(6);

        Family family2 = new Family();
        family2.setId(7);

        product.getFamilies().add(family1);
        product.getFamilies().add(family2);

        Assert.assertTrue(productData.updateProduct(product));
    }
    
    @Test
    public void findByCategory() {
    	List<Product> products = productData.getProductsByCategory("Televisores");
    	assertNotNull(products);
    }

}
