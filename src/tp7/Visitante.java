package tp7;


import java.util.logging.Level;
import java.util.logging.Logger;


        

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author randal.pereda
 */
public class Visitante implements Runnable{
    private Gestor gestor;
    private Boolean jubilado; 
    
    public Visitante(Gestor gestor, boolean jubi){
    this.gestor=gestor;
    this.jubilado=jubi; 
    }
    
    public void run() {
        
        try{
        llegando();
        if (!jubilado) {//Para que no lleguen todos juntos
            gestor.entrarSala();
        } else {
            gestor.entrarSalaJubilado();
        }
        visita();
        gestor.salirSala();
        System.out.println(Thread.currentThread().getName() + " salio de la sala");
        } catch (InterruptedException ex) {
            Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void llegando() {
        try {
            int llegando = (int) (Math.random() * 10);
            Thread.sleep(llegando * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void visita() {
        try {
            Thread.sleep(12000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Visitante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
