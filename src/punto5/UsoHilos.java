/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto5;

/**
 *
 * @author randal.pereda
 */
class UsoHilos{
public static void main(String[] args) {
System.out.println("Hilo principal iniciando.");
//Primero, construye un objeto unHilo.
MiHilo mh=new MiHilo("#1");
MiHilo mh1=new MiHilo("#3");
MiHilo mh2=new MiHilo("#2");
//Luego, construye un hilo de ese objeto.
Thread nuevoHilo=new Thread(mh);
Thread nuevoHilo1=new Thread(mh1);
Thread nuevoHilo2=new Thread(mh2);
//Finalmente, comienza la ejecución del hilo.
nuevoHilo.start();
nuevoHilo2.start();
nuevoHilo1.start();
for (int i=0; i<50;i++){
System.out.print(" .");
}try{
Thread.sleep(100);
}catch (InterruptedException exc){
System.out.println("Hilo principal interrumpido.");
}
System.out.println("Hilo principal finalizado.");
}
}