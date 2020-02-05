/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.aplicada.resources;

import cr.ac.ucr.aplicada.model.Product;
import cr.ac.ucr.aplicada.services.ProductService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ale
 */
@Path("/products")
public class ProductResource {

    ProductService productService = new ProductService();
    
    //Servicio que trae todos los producto
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return productService.getAllproducts();
    }
    
    //Servicio que solicitad la palabra a buscar
    @GET
    @Path("/find")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductByName() {
        return productService.getProductByNameRequest();
    }
    
    //Servicio que trae la respuesta de la palabra que se desea busca
    @GET
    @Path("/find/response")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProductByNameRequest() {
        return productService.getProductByNameResponse();
    }
}
