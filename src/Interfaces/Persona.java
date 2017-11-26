/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author fernando
 */
public class Persona implements java.io.Serializable{
public String  id;
public int  diaNac;
public int  mesNac;
public int  anoNac;
public int  credito;
public int  deuda;
public String nombre;
public String apellidoPaterno;
public String apellidoMaterno;

//constructor base
public Persona(){
    id = "";
    diaNac = 0;
    mesNac = 0;
    anoNac= 0;
    credito = 0;
    deuda = 0;
    nombre = "";
    apellidoPaterno= "";
    apellidoMaterno= "";
    
    }
//constructor que recibe atributos
void registro (String id , String nombre, String apellidoPaterno, String apellidoMaterno ,int diaNac,int mesNac,int anoNac,int credito,int deuda){

    this.id = id;
    this.diaNac=diaNac;
    this.mesNac=mesNac;
    this.anoNac=anoNac;
    this.credito=credito;
    this.deuda=deuda;
    this.nombre=nombre;
    this.apellidoPaterno=apellidoPaterno;
    this.apellidoMaterno=apellidoMaterno;    
}

//getters
public String getid(){
    return this.id;
}
public int getdiaNac(){
        
return this.diaNac;
}
public int getmesNac(){
    return this.mesNac;
}
public int getanoNac(){
    return this.anoNac;
}
public int getcredito(){
    return this.credito;
}
public int getdeuda(){
    return this.deuda;
}
public String getnombre(){
    return this.nombre;
}
public String getapellidoPaterno(){
    return this.apellidoPaterno;
}
public String getapellidoMaterno(){
    return this.apellidoMaterno;
}

    void registro(String text, String text0, String text1, int parseInt, int parseInt0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




}//llave final

