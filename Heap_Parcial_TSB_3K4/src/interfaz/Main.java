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
        //Creo un Heap de tamaño 6, inicialmente.
        Heap<Integer> ah = new Heap<>(6, true);
        
        //Se agregan algunos elementos. Y el Heap se ordena cada vez que se agrega uno.
        ah.add(5);
        ah.add(12);
        ah.add(20);
        ah.add(8);
        ah.add(10);
        ah.add(11);
        
        //Se ponen dos ejemplos del metodo lucky(). Si el Heap es ascendente, el primer lucky() da true, y el siguiente false.
        //En caso de que el Heap sea descendente, el primero devuelve false, y el segundo true.
        System.out.println("Lucky?: " + ah.lucky(4));
        System.out.println("Lucky?: " + ah.lucky(30));
        
        //Se obtienen los dos optimos.
        //Si el Heap es ascendente, debe devolver la raiz y el hijo menor.
        //Si el Heap es descendente, debe devolver la raiz y el hijo mayor.
        SimpleList dosOptimosGet = ah.getBoth();
        System.out.println("Optimos: " + dosOptimosGet.toString());

        //Lo mismo que el getBoth(), pero esta vez elimina los optimos.
        SimpleList dosOptimosRemove = ah.removeBoth();
        System.out.println("Removiendo los dos optimos: " + dosOptimosRemove.toString());
        
        //Vector ordenado en forma de arbol binario completo o casi completo.
        System.out.println("Vector tipo arbol binario: " + ah.toString());

        //A continuacion se extrae del Heap uno a uno el menor(si es ascendente) o el mayor(descendente).
        //Y se muestran por pantalla.
        System.out.print("Mostramos en orden de extraccion: \n[ ");
        while (!ah.isEmpty()) {
            int x = ah.remove();
            System.out.print(x + " ");
        }
        System.out.println("]\n");
    }
}
