/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ejercicio5;
import java.util.Random;
/**
 *
 * @author Randal
 */
public class Estacion {
     private int combu;
    private String nombre;

    public Estacion(String nombre) {
        this.combu = 250;
        this.nombre = nombre;
    }

    public void setCombu(int n) {
        this.combu=combu-n;
    }
   

    public synchronized void cargarNafta(Auto unAuto){
        if(combu<40){
             unAuto.setKmRecorridos(0);
             System.out.println("Surtidor vacio");
             unAuto.setautoconComb(true);
             
        }else{    
        unAuto.setKmRecorridos(40);
        this.combu=combu-40;
        System.out.println("ESTA CARGANDO NAFTA: "+unAuto.getMarca());
            System.out.println("surtidor con combustible: "+ this.combu);
        try{
                Thread.sleep(2000);
            }catch(InterruptedException ex){
                System.out.println("Hubo error");
        }
    }
    }
    
}

