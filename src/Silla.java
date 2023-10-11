/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author randal.pereda
 */



import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Silla {
private int cantSillasDispo;
    private Semaphore semEmpleado;
    private Semaphore semMozo;
    private Semaphore semSilla;
  
    
    public Silla(){
        
        semSilla= new Semaphore(1);
        semMozo = new Semaphore(0);
        semEmpleado = new Semaphore(0);
     
    }
}
