/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.aplicada.resources;

import cr.ac.ucr.aplicada.model.EncryptedPassword;
import cr.ac.ucr.aplicada.services.EncryptedService;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ale
 */
@Path("/encrypted")
public class EncryptedResource {
    
   EncryptedService encryptedService = new EncryptedService();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EncryptedPassword> getEncryptedPassword(){
        return encryptedService.getPassword();
    }
    
    @GET
    @Path("/finalPass")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EncryptedPassword> getPasswordForUser(){
        return encryptedService.getFinalPasswordForUser();
    }
    
    @GET
    @Path("/tempPass")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EncryptedPassword> getTempPasswordForUser(){
        return encryptedService.getTempPasswordForUser();
    }
}
