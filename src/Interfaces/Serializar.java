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
    
    public void serializar(ArrayList<Persona> person){
        try{
            ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("registro.txt"));
            salida.writeObject(person);
            salida.close();
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println(ioe);
        }
    }
    
    public ArrayList<Persona> leerpersona(){
        try(ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("registro.txt"))) {
            persona = (ArrayList<Persona>) entrada.readObject();
        } 
        catch(IOException ioe){
            ioe.printStackTrace();
            System.out.println(ioe);
        }
        catch(ClassNotFoundException c){
           System.out.println("Class not found");
           c.printStackTrace();
        }
        return persona;
    }
    
    public ArrayList<Persona> enlazar(ArrayList<Persona> persona1, ArrayList<Persona> persona2){
        ArrayList<Persona> personaUnida = new ArrayList<Persona>();
        
        for(int i = 0;i < persona2.size(); i++){
            for(int j = 0;j < persona1.size();j++){
                if(persona2.get(i).id.equals(persona1.get(j).id)){
                    persona2.get(i).setNombre(persona1.get(j).nombre);
                    persona2.get(i).setApellidoPat(persona1.get(j).apellidoPaterno);
                    persona2.get(i).setApellidoMat(persona1.get(j).apellidoMaterno);
                    persona2.get(i).setDeuda(persona1.get(j).deuda);
                    persona2.get(i).setCredito(persona1.get(j).credito);
                    persona2.get(i).setDiaNac(persona1.get(j).diaNac);
                    persona2.get(i).setMesNac(persona1.get(j).mesNac);
                    persona2.get(i).setAnoNac(persona1.get(j).anoNac);
                    persona1.remove(j);
                }
            }
        }
        
        for(int i=0;i< persona1.size(); i++){
            personaUnida.add(persona1.get(i));
        }
        for(int i=0;i< persona2.size(); i++){
            personaUnida.add(persona2.get(i));
        }
        return personaUnida;
    }
}