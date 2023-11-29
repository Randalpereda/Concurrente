/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp8.parcialLock.semaforoCajas;

/**
 *
 * @author Randal
 */

public class embotellador implements Runnable{
    private Fabrica fabrica;
    private int tipo;

    public embotellador(Fabrica F, int unTipo){
        fabrica=F;
        tipo=unTipo;
    }

    public void run (){
        try{
            while(true){
                if(tipo%2==0){
                    fabrica.embotellarAgua();
                }else{
                    fabrica.embotellarVino();
                }
            }
        }catch(InterruptedException e){
            
        }
    }
    
}