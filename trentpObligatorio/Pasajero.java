/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trentpObligatorio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class Pasajero implements Runnable {
    private Tren tren;
    

    

    
    public Pasajero(Tren t) {
    this.tren=t;

}
  public void run() {
  boolean viajo=false;
  try{
       Thread.sleep((long)((Math.random()*20)*1000));//llegando al tren
              while(!viajo){
                  if(tren.pedirPasaje()){
                      tren.subio();
                           System.out.println(Thread.currentThread().getName() + ": se baja del tren");
                    viajo = true;   
                  }else{
                  //no consigui pasaje
                    System.out.println(Thread.currentThread().getName() + ": no pudo entrar al tren asi que espera");
                    Thread.sleep(15000);
                  }
              }
  
  }catch(InterruptedException ex) {
            Logger.getLogger(Pasajero.class.getName()).log(Level.SEVERE, null, ex);}
  
  }
  }
  
          
            
             

