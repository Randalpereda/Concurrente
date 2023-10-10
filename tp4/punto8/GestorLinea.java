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
    private Semaphore cambioLinea;
    private int productosElectricosProducidos;
    private  int productosMecanicosProducidos;
    
    public GestorLinea(){
      
         cambioLinea= new Semaphore(1);
        semLineaUno = new Semaphore(5);
        semLineaDos = new Semaphore(5);
        productosElectricosProducidos = 0;
        productosMecanicosProducidos= 0;
    }
    public void llegaMeca(Producto p) throws InterruptedException {
        if (productosMecanicosProducidos >= 5) {
        cambiaLineas();
    }
               
        productosMecanicosProducidos++;
        System.out.println(Thread.currentThread().getName() + ": llega al cruce  Producto Mecanico ");
         Thread.sleep(5000);
         semLineaUno.release();
         p.cruzo();
    }

    public void llegaElec(Producto p) throws InterruptedException {
         if (productosElectricosProducidos >= 5) {
        cambiaLineas();
    }
        productosElectricosProducidos++;
        System.out.println(Thread.currentThread().getName() + ": llega al cruce  Producto Electronico ");
        Thread.sleep(5000);
       semLineaDos.release();
       p.cruzo();
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
  
    public void cambiaLineas() throws InterruptedException {
    try {
        System.out.println("----------------CAMBIO DE LINEA-----------------");
        cambioLinea.acquire();
        semLineaUno.release(5);
        semLineaDos.release(5);
        productosElectricosProducidos = 0;
        productosMecanicosProducidos = 0;
    } finally {
        cambioLinea.release();
    }
}
    
}
