package tp3Sincro;


import java.util.logging.Level;
import java.util.logging.Logger;
import tp3Sincro.Silla;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author randal.pereda
 */
public class empleado {
    
    private Silla silla;
  
       
    public empleado(Silla s ) {
    this.silla=s;

}
    
  public void run() {
  
  try{
       Thread.sleep((long)((Math.random()*20)*1000));//llegando a la cafeteria
              
                  if(silla.sillaLibre()){
                      silla.llamarMozo();
                         
                      
                  }else{
                  //no consigui silla
                    System.out.println(Thread.currentThread().getName() + ": no pudo entrar a la cafe");
                    Thread.sleep(15000);
                  }
              
  
  }catch(InterruptedException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);}
  
  }
  
  
  terminarComer
  
  private void terminarComer() {
        try {
            Thread.sleep(10000);
            
            System.out.println("--------Termino de comer--------");
            System.out.println("--------saluda al mozo--------");
        } catch (InterruptedException ex) {
            Logger.getLogger(empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    
    
    

