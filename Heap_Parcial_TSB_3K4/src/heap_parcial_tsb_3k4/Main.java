/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap_parcial_tsb_3k4;

/**
 *
 * @author matychp
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        Heap <Integer> ah = new Heap<>(6, true);
        ah.add(8);
        ah.add(3);
        ah.add(7);
        ah.add(9);
        ah.add(4);
        ah.add(2);
        System.out.println("Heap ascendente: " + ah);
        System.out.println(ah.lucky(1));
        System.out.println(ah.lucky(10));
        
        System.out.print("Mostramos en orden de extraccion: \n[ ");
        while( ! ah.isEmpty() )
        {
            int x = ah.remove();
            System.out.print(x + " ");
        }
        System.out.println("]\n");
    }
    
}
