/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto7;

/**
 *
 * @author Randal
 */
public class main {

    private static Empleado[] emple;
    private static Thread[] th;
    private static Confiteria c = new Confiteria();
    private static Mozo mozo = new Mozo(c);

    public static void main(String[] args) {
        Thread hiloMozo = new Thread(mozo);

        hiloMozo.start();
        crearEmpleados();
        crearHilos();
        empezarHilos();

    }

    private static void crearEmpleados() {
        emple = new Empleado[10];
        for (int i = 0; i < 10; i++) {
            emple[i] = new Empleado(c);
        }
    }

    private static void crearHilos() {
        th = new Thread[10];

        for (int i = 0; i < 10; i++) {

            th[i] = new Thread(emple[i], "empleado " + i);
            //th[i+1] = new Thread(productosM[i+10], "Producto " + i+10);
        }

    }

    private static void empezarHilos() {
        for (int i = 0; i < th.length; i++) {
            th[i].start();

        }
    }
}
