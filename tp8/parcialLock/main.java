/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.parcialLock;

/**
 *
 * @author Randal
 */
public class main {
    public static void main(String[] args) {
        Espacio e= new Espacio(3);
        
        Thread[] atomoOx = new Thread[5];
        Thread[] atomoHi = new Thread[10];
        
       
        for (int i = 0; i < atomoOx.length; i++) {
            atomoOx[i]= new Thread(new atomoO(e), "atomo Oxi " + (i + 1));
           
            atomoOx[i].start();
        }
        
         for (int i = 0; i < atomoHi.length; i++) {
            atomoHi[i]= new Thread(new atomoH(e), "atomo hidro " + (i + 1));
           
            atomoHi[i].start();
        }
}
}