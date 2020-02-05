package cr.ac.ucr.aplicada.client;


import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ale
 */
public class restApiClient {

    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://Ale-PC:8080/WebServiceRest/webapi/products");
        Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        System.out.println(response.readEntity(String.class));       
    }
}
