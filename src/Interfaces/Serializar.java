        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;
import java.util.*;
import java.io.*;

/**
 *
 * @author fernando
 */
public class Serializar {
    ArrayList<Persona> persona= new ArrayList<Persona>();
    public void serializar(ArrayList<Persona> person)
    {
        try{
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("registro.txt"));
      this.persona= this.leerpersona();
      salida.writeObject(this.enlazar(person, this.persona));
      salida.close();
    }

    catch(IOException ioe){
      ioe.printStackTrace();
      System.out.println(ioe);
    }
    }
    public ArrayList<Persona> enlazar(ArrayList<Persona> persona1, ArrayList<Persona> persona2){
        ArrayList<Persona> personaUnida = new ArrayList<Persona>();
        for(int i=0;i< persona1.size(); i++){
            personaUnida.add(persona1.get(i));
        }
        for(int i=0;i< persona2.size(); i++){
            personaUnida.add(persona2.get(i));
        }
        return personaUnida;
    }
    public ArrayList<Persona> leerpersona(){
      ArrayList<Persona> personaReturn = new ArrayList<Persona>();
      try{
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("registro.txt"));
      personaReturn = (ArrayList<Persona>) entrada.readObject();
      entrada.close();  
        } 
      catch(IOException ioe){
      ioe.printStackTrace();
      System.out.println(ioe);
    }
    catch(ClassNotFoundException c){
       System.out.println("Class not found");
       c.printStackTrace();
    }
      return personaReturn;
    }
}