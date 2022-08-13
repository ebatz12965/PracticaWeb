/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Edwing
 */
public class Persona {
   PersonaClass[] tablaPersona;
    int indiceArray;
    
    public Persona(){
        this.tablaPersona = new PersonaClass[100];
        this.indiceArray=0;
    }
    
     public void guardarPersona(PersonaClass persona){
        this.tablaPersona[this.indiceArray]=persona;  
        this.indiceArray=this.indiceArray+1;
    }
    
    public PersonaClass[] getPersona(){
        return this.tablaPersona;
    }
    
}
