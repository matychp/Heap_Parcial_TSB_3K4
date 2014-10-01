/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import estructuras.Heap;
import estructuras.SimpleList;

/**
 *
 * @author matychp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Heap <Integer> ah = new Heap<>(6, false);
        ah.add(5);
        ah.add(3);
        ah.add(7);
        ah.add(9);
        ah.add(4);
        ah.add(2);
//        System.out.println("Lucky?: " + ah.lucky(1));
//        System.out.println("Lucky?: " + ah.lucky(10));
        SimpleList dosOptimosGet = ah.getBoth();
        if(dosOptimosGet != null){
            System.out.println(dosOptimosGet.toString());
        }else{
            System.out.println("No existen dos optimos (hay 0 o 1 elemento).");
        }
        
        SimpleList dosOptimosRemove = ah.removeBoth();
        if(dosOptimosRemove != null){
            System.out.println(dosOptimosRemove.toString());
        }else{
            System.out.println("No existen dos optimos (hay 0 o 1 elemento).");
        }
//        System.out.print("Mostramos en orden de extraccion: \n[ ");
//        while( ! ah.isEmpty() )
//        {
//            int x = ah.remove();
//            System.out.print(x + " ");
//        }
//        System.out.println("]\n");
    }
    
}
