/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto7;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Randal
 */
public class Confiteria {
      private Semaphore semMozo;
    private Semaphore semEmpleado;
    private Semaphore semSilla;
    
    
    
    public Confiteria(){
      semMozo= new Semaphore(0);
      semEmpleado= new Semaphore(0);
      semSilla= new Semaphore(1);
    }
    
    public void llamarMozo(){
       System.out.println(Thread.currentThread().getName() +"llama al mozo");
        semMozo.release();
        System.out.println("espera q le sirvan");
        
    }
     public synchronized boolean solicitarSilla(){
    
        boolean compro = semSilla.tryAcquire();
        notifyAll();
        return compro;
    }
    
     
    public void llegaEmpleado() throws InterruptedException{
            
        semMozo.acquire();
        System.out.println("mozo toma orden");
        Thread.sleep(15000);
        System.out.println("sirve comida");
        semEmpleado.release();
    
    } 
    
    public void terminaEmpleado() throws InterruptedException{
        semEmpleado.acquire();
        System.out.println("termina de comer y saluda al mozo");
        semSilla.release();
        System.out.println(Thread.currentThread().getName() +"libera silla");
    }
}
