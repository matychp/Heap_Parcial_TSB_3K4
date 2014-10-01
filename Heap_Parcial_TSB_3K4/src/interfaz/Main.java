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
        Heap<Integer> ah = new Heap<>(6, true);
        ah.add(5);
        ah.add(12);
        ah.add(20);
        ah.add(8);
        ah.add(10);
        ah.add(11);
        System.out.println("Lucky?: " + ah.lucky(1));
        System.out.println("Lucky?: " + ah.lucky(10));
        SimpleList dosOptimosGet = ah.getBoth();
        System.out.println(dosOptimosGet.toString());

        SimpleList dosOptimosRemove = ah.removeBoth();
        System.out.println(dosOptimosRemove.toString());
        System.out.println(ah.toString());

        System.out.print(
                "Mostramos en orden de extraccion: \n[ ");
        while (!ah.isEmpty()) {
            int x = ah.remove();
            System.out.print(x + " ");
        }
        System.out.println("]\n");
    }
}
