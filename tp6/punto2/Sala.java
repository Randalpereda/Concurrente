/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.punto2;

/**
 *
 * @author Randal
 */
public class Sala {
    
    private int maxPersonas;
    private int personasEnSala;
    
        public Sala() {
        maxPersonas = 5;//Cantidad maxima de personas que pueden entrar
       personasEnSala=0;
        }
    
    
    public synchronized void entrarSala() throws InterruptedException {
        while (personasEnSala >= maxPersonas ) {
            
            wait();
        }
        personasEnSala++;
        System.out.println(Thread.currentThread().getName() + " entro a la sala. Cantidad de personas: " + personasEnSala);
    }
    
    
    
     public synchronized void liberaMesa() {
        //Avisa que salio de la sala
        personasEnSala--;
System.out.println(Thread.currentThread().getName() + " se va de la sala...... " + personasEnSala);
        
        notifyAll();
    }
    
        
}
