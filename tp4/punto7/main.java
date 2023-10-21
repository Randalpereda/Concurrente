/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto7;

import java.util.Scanner;

/**
 *
 * @author Randal
 */
public class main {
      private static int cant;
    private static Empleado[] emple;
    private static Thread[] th;
    private static Confiteria c = new Confiteria();
    private static Mozo mozo = new Mozo(c);
    private static cocinero cocinero = new cocinero(c);

    public static void main(String[] args) {
        
        
        Thread hiloMozo = new Thread(mozo);
        Thread hiloC = new Thread(cocinero);
        Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos empleados?");
		cant = sc.nextInt();
        hiloMozo.start();
        hiloC.start();
        crearEmpleados();
        crearHilos();
        empezarHilos();

    }

    private static void crearEmpleados() {
        emple = new Empleado[cant];
        for (int i = 0; i < cant; i++) {
            emple[i] = new Empleado(c);
        }
    }

    private static void crearHilos() {
        th = new Thread[cant];

        for (int i = 0; i < cant; i++) {

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
