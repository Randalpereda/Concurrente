/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3Sincro;

/**
 *
 * @author randal.pereda
 */
public class ejerEnergia {
    
    public static void main(String[] args) {
        EnergiaCompartida energiaCompartida = new EnergiaCompartida();

        Thread criaturaOscuraThread = new Thread(new CriaturaOscura(energiaCompartida));
        Thread sanadorThread = new Thread(new Sanador(energiaCompartida));

        criaturaOscuraThread.start();
        sanadorThread.start();
    }
}



 class EnergiaCompartida {
    private int energia = 10;

    public synchronized void drenarEnergia(int cantidad) {
        if (energia >= cantidad) {
            energia -= cantidad;
            System.out.println("Criatura Oscura drena " + cantidad + " unidades de Energía.");
        } else {
            System.out.println("Criatura Oscura no puede drenar más Energía. Energía agotada.");
        }
        System.out.println("Energía restante: " + energia);
    }

    public synchronized void revitalizarEnergia(int cantidad) {
        energia += cantidad;
        System.out.println("Sanador revitaliza " + cantidad + " unidades de Energía.");
        System.out.println("Energía restante: " + energia);
    }
}
class CriaturaOscura implements Runnable {
    private EnergiaCompartida energiaCompartida;

    public CriaturaOscura(EnergiaCompartida energiaCompartida) {
        this.energiaCompartida = energiaCompartida;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            energiaCompartida.drenarEnergia(3);
        }
    }
}      



class Sanador implements Runnable {
    private EnergiaCompartida energiaCompartida;

    public Sanador(EnergiaCompartida energiaCompartida) {
        this.energiaCompartida = energiaCompartida;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            
       try {
energiaCompartida.revitalizarEnergia(3);
if(cbenergiaCompartida.getBalance() < 0){
System.out.println("La cuenta está sobregirada.");
}
} catch (InterruptedException ex) {
Logger.getLogger(VerificarCuenta.class.getName()).
log(Level.SEVERE, null, ex); }
}
} }
    }
}
