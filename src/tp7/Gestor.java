/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp7;

/**
 *
 * @author randal.pereda
 */
public class Gestor {

    private int maxPersonas;
    private int personasEnSala;
    private int jubiladosEsperando;

    public Gestor() {
        maxPersonas = 50;//Cantidad maxima de personas que pueden entrar
        personasEnSala = 0;
        jubiladosEsperando = 0;
    }

    public synchronized void entrarSala() throws InterruptedException{ 
        while (personasEnSala >= maxPersonas || jubiladosEsperando != 0) {
            //Espera si la cantidad de personas en la sala es mayor a la cantidad maxima y si hay jubilados esperando
            wait();
        }
        
        personasEnSala++;
        System.out.println(Thread.currentThread().getName() + " entro a la sala. Cantidad de personas: " + personasEnSala
                + " Jubilados Esperando: " + jubiladosEsperando);
    }
    
    public synchronized void entrarSalaJubilado() throws InterruptedException{ 
    while(personasEnSala >= maxPersonas){
    jubiladosEsperando++;
    wait();
    jubiladosEsperando--;
    }
     personasEnSala++;
        System.out.println(Thread.currentThread().getName() + " entro a la sala. Cantidad de personas: " + personasEnSala
                + " Jubilados Esperando: " + jubiladosEsperando);
    }
    
    public synchronized void salirSala() {
        //Avisa que salio de la sala

        personasEnSala--;
        notifyAll();
    }

    public synchronized int notificarTemperatura(int temp) {
        if (temp >= 30) {
            maxPersonas = 5;
        } else {
            maxPersonas = 10;
        }
        notifyAll();
        return maxPersonas;
    }

}

    
