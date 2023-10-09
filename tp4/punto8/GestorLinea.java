/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto8;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Randal
 */
public class GestorLinea {
   
   
    private Semaphore semLineaUno;
    private Semaphore semLineaDos;
  
    
    
    public GestorLinea(){
       
       
        semLineaUno = new Semaphore(5);
        semLineaDos = new Semaphore(5);
      
    }
    public void llegaMeca(Producto p) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + ": llega al cruce  Producto Mecanico ");
         Thread.sleep(5000);
         semLineaUno.release();
    }

    public void llegaElec(Producto P) throws InterruptedException {
       
        System.out.println(Thread.currentThread().getName() + ": llega al cruce  Producto Electronico ");
        Thread.sleep(5000);
       semLineaDos.release();
    }

      public synchronized boolean entrarAlinea() {
        boolean entro = semLineaUno.tryAcquire();
        notifyAll();
        return entro;
    }
    
      public synchronized boolean entrarAlineaM() {
        boolean entro = semLineaDos.tryAcquire();
        notifyAll();
        return entro;
    }
  
    
    
}
