/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.aplicada.model;

/**
 *
 * @author Ale
 */
public class EncryptedPassword {

    private String ip;
    private String encryptedP;

    public EncryptedPassword(String ip, String encryptedP) {
        this.ip = ip;
        this.encryptedP = encryptedP;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getEncryptedP() {
        return encryptedP;
    }

    public void setEncryptedP(String encryptedP) {
        this.encryptedP = encryptedP;
    }

}
