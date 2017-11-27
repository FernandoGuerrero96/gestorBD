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
    
    public ArrayList<Persona> updateData(Persona person){
        this.persona = this.leerpersona();
        for(int i = 0;i < this.persona.size();i++){
            if(this.persona.get(i).id.equals(person.id)){
                this.persona.get(i).setNombre(person.nombre);
                this.persona.get(i).setApellidoPat(person.apellidoPaterno);
                this.persona.get(i).setApellidoMat(person.apellidoMaterno);
                this.persona.get(i).setAnoNac(person.anoNac);
                this.persona.get(i).setMesNac(person.mesNac);
                this.persona.get(i).setDiaNac(person.diaNac);
                this.persona.get(i).setDeuda(person.deuda);
                this.persona.get(i).setCredito(person.credito);
            }
        }
        
        return this.persona;
    }
    
    public ArrayList<Persona> sustituir(Persona aSustiPersona, Persona sustiPersona){
        ArrayList<Persona> personas = this.leerpersona();
        for(int i = 0; i < personas.size(); i++){
            if(personas.get(i).id.equals(aSustiPersona.id)){
                personas.get(i).setNombre(sustiPersona.getnombre());
                personas.get(i).setApellidoPat(sustiPersona.getapellidoPaterno());
                personas.get(i).setApellidoMat(sustiPersona.getapellidoMaterno());
                personas.get(i).setAnoNac(sustiPersona.getanoNac());
                personas.get(i).setMesNac(sustiPersona.getmesNac());
                personas.get(i).setDiaNac(sustiPersona.getdiaNac());
                personas.get(i).setDeuda(sustiPersona.getdeuda());
                personas.get(i).setCredito(sustiPersona.getcredito());
            }
        }
        personas.remove(sustiPersona.id);
        return personas;
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