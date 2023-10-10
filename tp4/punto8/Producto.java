/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto8;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class Producto implements Runnable {
     private String tipo;
    private GestorLinea gestorLinea;
    
    public Producto(String tipo, GestorLinea gestorLinea) {
        this.tipo = tipo;
        this.gestorLinea=gestorLinea;
    }
    
    public void run() {
  boolean ensamb=false;
 
  try{
       Thread.sleep((long)((Math.random()*20)*1000));//llegando al cruce
              while(!ensamb){
                  
                  if(this.tipo.equals("Electronico")){
                       //llega electronico
                       esTipoElec();
                       ensamb=true;
                  }else{
                      esTipoMecanico();
                    ensamb=true;
                  }
              }
  
  }catch(InterruptedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);}
  
  }
    
     private void esTipoElec() throws InterruptedException {
       boolean entro=false;
     try{
       while(!entro){
          if(gestorLinea.entrarAlinea()){
             gestorLinea.llegaElec(this);
             
             entro=true;
          }
           System.out.println(Thread.currentThread().getName() + ": no pudo entrar asi que espera");
                    Thread.sleep(15000);
        
         
          }
    } catch(InterruptedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
}
     } 
  

    private void esTipoMecanico() throws InterruptedException {
         boolean entro=false;
     try{
       while(!entro){
          if(gestorLinea.entrarAlineaM()){
                
        gestorLinea.llegaMeca(this);
       
             entro=true;
          }
           System.out.println(Thread.currentThread().getName() + ": no pudo entrar asi que espera");
                    Thread.sleep(15000);
        
         
          }
    } catch(InterruptedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
}
     } 
        
     
        
    

    public void cruzo()throws InterruptedException  {
        try {
            System.out.println(Thread.currentThread().getName() + ": ya esta ensamblado ");
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
}
