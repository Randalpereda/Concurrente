/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio5;

/**
 *
 * @author Randal
 */
import java.util.Random;
    public class Vehiculo {

    private String patente;
    private String marca;
    private String modelo;
   
 
    public Vehiculo(String patente, String marca, String modelo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
      

    }

   

    public Vehiculo(String unPatente){
        this.patente=unPatente;
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

   

}

