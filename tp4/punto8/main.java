/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.punto8;

/**
 *
 * @author Randal
 */
public class main {
        private static Producto[] productosE;
        private static Producto[] productosM;
	private static Thread[] th;
        private static Thread[] th2;
	private static GestorLinea gestor = new GestorLinea();
        private static control c = new control(gestor);    
        
        
        
        
         public static void main(String[] args) {
                Thread hilocontrol = new Thread(c);
                
                
                crearProductos();
		crearHilos();
		empezarHilos();
                hilocontrol.start();
         }     
                private static void crearProductos() {
		productosE = new Producto[10];
		for (int i = 0; i < 10; i++) {
			productosE[i] = new Producto("Electronico",gestor);
		}
                productosM = new Producto[10];
		for (int i = 0; i < 10; i++) {
			productosM[i] = new Producto("Meca",gestor);
		}
                  } 
         
                private static void crearHilos() {
                    th = new Thread[10];
                    th2 = new Thread[10];
                    for (int i = 0; i < 10; i++) {
                        System.out.println("entroh1h1h1");
			th[i] = new Thread(productosM[i], "Producto " + i);
                        //th[i+1] = new Thread(productosM[i+10], "Producto " + i+10);
                    }
                    for (int i = 0; i < 10; i++) {
                        System.out.println("creo h2");
			th2[i] = new Thread(productosE[i], "Producto e " + i);
		}
                }
         
                private static void empezarHilos() {
		for (int i = 0; i < th.length; i++) {
			th[i].start();
                        
                    }
                for (int j = 0; j < th2.length; j++) {
			th2[j].start();
                        
                    }
                }
}
