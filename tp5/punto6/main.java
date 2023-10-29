/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.punto6;

/**
 *
 * @author Randal
 */
public class main {

    private static Avion[] aviones;
    private static Thread[] th;

    private static final Torre pista = new Torre();

    public static void main(String[] args) {

        crearAviones();
        crearHilos();
        empezarHilos();

    }

    private static void crearAviones() {
        aviones = new Avion[20];
        for (int i = 0; i < 20; i++) {
            aviones[i] = new Avion(pista);
        }

    }

    private static void crearHilos() {
        th = new Thread[aviones.length];

        for (int i = 0; i < aviones.length; i++) {

            th[i] = new Thread(aviones[i], "Avion " + i);
            //th[i+1] = new Thread(productosM[i+10], "Producto " + i+10);
        }

    }

    private static void empezarHilos() {
        for (Thread th1 : th) {
            th1.start();
        }

    }
}
