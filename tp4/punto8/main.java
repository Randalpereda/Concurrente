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
	private static GestorLinea gestor = new GestorLinea();
        private static control c = new control(gestor);    
        
        
        
        
         public static void main(String[] args) {
                Thread hilocontrol = new Thread(c);
                
                hilocontrol.start();
                crearProductos();
		crearHilos();
		empezarHilos();
                
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
                    th = new Thread[20];
                    for (int i = 0; i < 10; i++) {
			th[i] = new Thread(productosM[i], "Producto " + i);
                        th[i+10] = new Thread(productosM[i+10], "Producto " + i+10);
                    }
                }
         
                private static void empezarHilos() {
		for (int i = 0; i < th.length; i++) {
			th[i].start();
                    }
                }
}
