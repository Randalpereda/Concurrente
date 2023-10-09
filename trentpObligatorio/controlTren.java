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
public class controlTren implements Runnable {
    private Tren tren;
    
    
    public controlTren(Tren t){
    this.tren=t;
    }
    
    
    public synchronized void run(){
    try{
    while(true){
    tren.esperarTrenLleno();
    simularViaje();
    tren.avisarQueTerminoViaje();
    }
        }catch(InterruptedException ex){
            Logger.getLogger(controlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      private void simularViaje() {
        try {
            System.out.println("--------EMPIEZA RECORRIDO DEL TREN TURISMO--------");
            Thread.sleep(10000);
            System.out.println("--------TERMINO RECORRIDO DEL TREN TURISMO--------");
        } catch (InterruptedException ex) {
            Logger.getLogger(controlTren.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
    
    

