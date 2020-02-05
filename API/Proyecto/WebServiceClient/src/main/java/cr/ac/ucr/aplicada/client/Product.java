/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.aplicada.client;

/**
 *
 * @author Ale
 */
public class Product {
    
    private int product_id;
    private String name;
    private float price;

    public Product(int product_id, String name, float price) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public int getproduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", name=" + name + ", price=" + price + '}';
    }
    
    
    
}
