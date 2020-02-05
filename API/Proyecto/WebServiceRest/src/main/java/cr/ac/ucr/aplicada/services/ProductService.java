/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.aplicada.services;

import com.google.gson.Gson;
import cr.ac.ucr.aplicada.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ale
 */
public class ProductService {

    private ArrayList<Product> products = new ArrayList<>();

    public ProductService() {
    }

    //Hace una solicitud a Greatvises para traer todos los productos
    public List<Product> getAllproducts() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://192.168.43.22/gbridge/WebService.asmx/getProducts");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        String respuesta = response.readEntity(String.class);
        Gson gson = new Gson();
        Product[] productsJSON = gson.fromJson(respuesta, Product[].class);
        for (Product productoActual : productsJSON) {
            Product producto = new Product(productoActual.getproduct_id(), productoActual.getName(), productoActual.getPrice(), productoActual.getPriceInColones());
            products.add(producto);
        }
        return products;
    }
    

     //Hace una solicitud al CLiente para traer la palabra que se desea buscar
    public List<Product> getProductByNameRequest() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://192.168.43.44/myserver/api/product/findName/1");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        String respuesta = response.readEntity(String.class);
        Gson gson = new Gson();
        Product[] productsJSON = gson.fromJson(respuesta, Product[].class);
        for (Product productoActual : productsJSON) {
            Product producto = new Product(productoActual.getName());
            products.add(producto);
        }
        
        return products;
    }
    
     //Hace una solicitud a Greatvises para traer el producto que se busca
    public ArrayList<Product> getProductByNameResponse() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://192.168.43.22/gbridge/WebService.asmx/getProductByName");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        String respuesta = response.readEntity(String.class);
        Gson gson = new Gson();
        Product[] productsJSON = gson.fromJson(respuesta, Product[].class);
        for (Product productoActual : productsJSON) {
            Product producto = new Product(productoActual.getproduct_id(), productoActual.getName(), productoActual.getPrice(), productoActual.getPriceInColones());
            products.add(producto);
        }
       
        return products;
    }

}
