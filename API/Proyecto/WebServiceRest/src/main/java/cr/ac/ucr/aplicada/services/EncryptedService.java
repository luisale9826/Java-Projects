/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.aplicada.services;

import com.google.gson.Gson;
import cr.ac.ucr.aplicada.model.EncryptedPassword;
import java.util.ArrayList;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author Ale
 */
public class EncryptedService {

    private ArrayList<EncryptedPassword> password = new ArrayList<>();

    public EncryptedService() {
    }
    
    //Solicita la contraseña temporal del GreatVises
    public List<EncryptedPassword> getPassword() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://192.168.43.22/gbridge/WebService.asmx/getEncryptedPassword");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        String respuesta = response.readEntity(String.class);
        Gson gson = new Gson();
        EncryptedPassword[] passwordsJSON = gson.fromJson(respuesta, EncryptedPassword[].class);
        for (EncryptedPassword encryptedPassword : passwordsJSON) {
            EncryptedPassword encrypted = new EncryptedPassword("ip", encryptedPassword.getEncryptedP());
            password.add(encrypted);
        }
        return password;
    }
    
    //Devuelve la contraseña final al Cliente
    public List<EncryptedPassword> getFinalPasswordForUser() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://192.168.43.22/gbridge/WebService.asmx/getFinalPassword");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        String respuesta = response.readEntity(String.class);
        Gson gson = new Gson();
        EncryptedPassword[] passwordsJSON = gson.fromJson(respuesta, EncryptedPassword[].class);
        for (EncryptedPassword encryptedPassword : passwordsJSON) {
            EncryptedPassword encrypted = new EncryptedPassword(encryptedPassword.getIp(), encryptedPassword.getEncryptedP());
            password.add(encrypted);
        }
        return password;
    }
    
    //Trae la dirección ip del Cliente para que el GreatVises le pueda adjuntar la contraseña
    public List<EncryptedPassword> getTempPasswordForUser() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://192.168.43.44/myserver/api/password/getAll");
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        Response response = builder.get();
        String respuesta = response.readEntity(String.class);
        Gson gson = new Gson();
        EncryptedPassword[] passwordsJSON = gson.fromJson(respuesta, EncryptedPassword[].class);
        for (EncryptedPassword encryptedPassword : passwordsJSON) {
            EncryptedPassword encrypted = new EncryptedPassword(encryptedPassword.getIp(), encryptedPassword.getEncryptedP());
            password.add(encrypted);
        }
        return password;
    }

}
