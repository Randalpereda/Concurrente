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
      private Semaphore semCocinero;
     private Semaphore semByC;
    private Semaphore semEmpleado;
    private Semaphore semSilla;
    
    
    
    public Confiteria(){
      semMozo= new Semaphore(0);
      semByC= new Semaphore(0);
      semCocinero=new Semaphore(0);
      semEmpleado= new Semaphore(0);
      semSilla= new Semaphore(2);
    }
    
    public synchronized void llamarMozo(){
       System.out.println(Thread.currentThread().getName() +" Llega y llama al mozo");
      
       semMozo.release();
        
        
    }
    public synchronized void llamarCocinero(){
       System.out.println(Thread.currentThread().getName() +" Llega y llama al cocinero");
      
       semCocinero.release();
      
        
    }
    public synchronized void llamarMozoyCocinero(){
       System.out.println(Thread.currentThread().getName() +" Llega y llama al mozo1 ");
      
       semByC.release();
        System.out.println(" espera q le sirvan bebida y comida");
        
    }
    
     
      
        
     public synchronized boolean solicitarSilla(){
         
        boolean compro = semSilla.tryAcquire();
        notifyAll();
       
        return compro;
    }
    
     
    public  void pideBebida() throws InterruptedException{
       
        
        semMozo.acquire();
        System.out.println("----------- mozo toma orden");
        Thread.sleep(15000);
         System.out.println("----------- mozo sirve bebida");
       
        semEmpleado.release();
    } 
     public  void pideComida() throws InterruptedException{
       
        
        semCocinero.acquire();
        System.out.println("----------- cocinero prepara la comida");
        Thread.sleep(15000);
         System.out.println( "----------- cocinero sirve comida");
        semEmpleado.release();
        
    } 
     public synchronized void pideBebidayComida() throws InterruptedException{
         
         semByC.acquire();
         
         semMozo.release();
         Thread.sleep(5000);
         semCocinero.release();
         Thread.sleep(15000);
             semEmpleado.release();  

       
        
    } 
    
    
    public void terminaEmpleado() throws InterruptedException{
        
        semEmpleado.acquire();
         System.out.println(Thread.currentThread().getName() + " esta disfrutando su orden");
         Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + " termina y saluda ...libera silla");
        semSilla.release();
        
    }
}
