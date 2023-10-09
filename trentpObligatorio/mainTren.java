/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trentpObligatorio;

import java.util.Scanner;


/**
 *
 * @author Randal
 */
public class mainTren {
     private static final Tren tren=new Tren(4);
    private static int cantPasajeros;
	private static Pasajero[] pasajeros;
	private static Thread[] th;
	private static controlTren c = new controlTren(tren);
	private static vendedorTicket v = new vendedorTicket(tren);
       
    

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos pasajeros?");
		cantPasajeros = sc.nextInt();
		crearPasajeros();
		crearHilos();
		empezarHilos();
                Thread controlTren = new Thread(c);
                 Thread vendedorTickets = new Thread(v);
                 
                 
                  controlTren.start();
                 vendedorTickets.start();
    }
                private static void crearPasajeros() {
		pasajeros = new Pasajero[cantPasajeros];
		for (int i = 0; i < cantPasajeros; i++) {
			pasajeros[i] = new Pasajero(tren);
		}
	}

	private static void crearHilos() {
		th = new Thread[cantPasajeros];
		for (int i = 0; i < cantPasajeros; i++) {
			th[i] = new Thread(pasajeros[i], "pasajero " + i);

		}
	}
       

	private static void empezarHilos() {
		for (int i = 0; i < th.length; i++) {
			th[i].start();
		}
	}
}
