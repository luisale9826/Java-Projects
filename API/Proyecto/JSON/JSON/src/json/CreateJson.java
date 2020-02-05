/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juang
 */
public class CreateJson {


    public void ToJSON() {
        Persona p = new Persona("Luis", 20);
        Persona p1 = new Persona("Glori", 18);
        Persona p2 = new Persona("Jeany", 19);
        Persona personas[] = {p, p1, p2};
        String ruta = "src\\archivos\\personas.json";
        //  insert
        //Crea el archivo y lo hace json
        File file = new File(ruta);
        //el writer sirve para escribir en el archivo físico
        try (Writer writer = new FileWriter(file)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(personas, writer);

        } catch (IOException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ReadJSON() {

        try {
            Reader reader = new FileReader("src\\archivos\\personas.json");
            Gson gson = new GsonBuilder().create();
            //el reader lee el archivo físico, Personas[].class es la clase arreglo de personas
            Persona personas[] = gson.fromJson(reader, Persona[].class);
            for (Persona persona : personas) {
                System.out.println(persona.toString());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
