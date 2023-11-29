/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.parcialLock.cajaslock;

/**
 *
 * @author Randal
 */
public class main {
 public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Thread hiloTransportador = new Thread(new Transportador(almacen), "Transportador ");
        Thread hiloEmpaquetador = new Thread(new Empaquetador(almacen),  "Empaquetador ");
        Thread[] hiloEmbotellador = new Thread[15];
        hiloEmpaquetador.start();
        hiloTransportador.start();
        for (int i = 0; i < hiloEmbotellador.length; i++) {
            if (i / 2 == 0) {
                hiloEmbotellador[i] = new Thread(new Embotellador(almacen, 1) , "Embotellador " + i);
            } else {
                hiloEmbotellador[i] = new Thread(new Embotellador(almacen, 2) , "Embotellador " + i);
            }
            hiloEmbotellador[i].start();
        }
        
    }
}