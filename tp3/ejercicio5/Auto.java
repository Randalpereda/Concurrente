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

public class Auto extends Vehiculo implements Runnable {
 
    private int kmParaReserva;
    private int kmRecorridos;
    private Estacion estacion;
    private boolean autoconComb=false;
    
    public Auto(String patente, String marca, String modelo, int kmFaltantesParaService, Estacion estacion) {
        super(patente, marca, modelo);
        this.kmParaReserva=10;
        this.kmRecorridos=kmFaltantesParaService;
        this.estacion=estacion;
    }

    @Override
      public void run(){
        
         System.out.println("Auto: " + this.getMarca() + " Listo. con km: "+this.getKmFaltantesParaElService());
        while(!this.getautoconComb()){
            if(kmRecorridos<=kmParaReserva){
                estacion.cargarNafta(this);
            }else{
                
                System.out.println(this.getMarca()+" km: "+this.kmRecorridos);
                Random rd = new Random();
                int distanciaAvanzada = new Random().nextInt(10) + 1;
                kmRecorridos-=distanciaAvanzada;
                try{
                    Thread.sleep(800);//Lleva spleep para simular la subida de km
                }catch(InterruptedException ex){
                    System.out.println(this.getMarca()+" Auto sin nafta");
                }
            }    
                
        }
    }
        public void setKmRecorridos(int unKmRecorridos){
        this.kmRecorridos = unKmRecorridos;
    }
     public int getKmFaltantesParaElService() {
        return kmRecorridos;
    }
     public void setautoconComb(boolean t){
        this.autoconComb = t;
    }
     public boolean getautoconComb() {
        return autoconComb;
    }
}