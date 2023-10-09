/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trentpObligatorio;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Randal
 */
public class vendedorTicket implements Runnable {
    private Tren tren;

    public vendedorTicket(Tren tren) {
        this.tren = tren;
    }

    public synchronized void run() {
        while (true) {
            try {
            
                System.out.println("VENDEDOR: esperando para vender");
                tren.vendendiendo();
                System.out.println("VENDEDOR: vendio todos los pasajes");
                tren.avisarVendioTodo();
                tren.esperarQueVuelva();
            } catch (InterruptedException ex) {
                Logger.getLogger(vendedorTicket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}