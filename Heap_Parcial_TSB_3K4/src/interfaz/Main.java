package interfaz;

import estructuras.Heap;
import estructuras.SimpleList;

/**
 *
 * @author matychp
 */
public class Main {

    private static Heap<Integer> h;
    private static int cantidad = 0;

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\tMenú de Opciones");
            System.out.println();
            System.out.println("1.  Crear un Heap de tamaño n.");
            System.out.println("2.  Cargar el Heap manualmente.");
            System.out.println("3.  Cargar el Heap automaticamente.");
            System.out.println("4.  Probar si tiene suerte agregando un número.");
            System.out.println("5.  Mostrar los dos optimos del heap.");
            System.out.println("6.  Remover los dos optimos del heap.");
            System.out.println("7.  toString() por niveles.");
            System.out.println("8.  toString() sin niveles.");
            System.out.println("9.  Extraer los elementos del Heap mostrandolos.");
            System.out.println("10. Test propuesto por el programador.");
            System.out.println();
            System.out.println("0.  Salir del programa.");

            System.out.print("Ingrese una opcion: ");
            opcion = Consola.readInt();
            
            if(!validarCargaHeap()) { opcion = -1; }
            
            switch (opcion) {
                case 1:
                    crear();
                    break;
                case 2:
                    cargaManual();
                    break;
                case 3:
                    cargaAutomatica();
                    break;
                case 4:
                    agregarConSuerte();
                    break;
                case 5:
                    mostrarOptimos();
                    break;
                case 6:
                    removerOptimos();
                    break;
                case 7:
                    toStringPorNiveles();
                    break;
                case 8:
                    toStringSinNiveles();
                    break;
                case 9:
                    extraerElementos();
                    break;
                case 10:
                    testPropuesto();
                    break;
                case 0:
                    System.out.println("Saliendo del programa... P:");
                    break;
                case -1:
                    System.out.println("Todavia no creó el Heap, por favor utilice la opcion 1..Gracias...");
                    break;
                default:
                    System.out.println("Opcion incorrecta -_-\nIngrese de nuevo...");
            }
            System.out.println("Presione Enter para volver al menú...");
            Consola.readLine();
        } while (opcion != 0);
    }

    private static void crear() {
        if (validarCargaHeap()) {
            System.out.println("Se detectó un Heap existente...");
            System.out.println("Está seguro que desea continuar?, se perderá su Heap anterior.");
            int check = 'c';
            System.out.print("Presion 's' para confirmar, cualquier otra tecla para cancelar: ");
            check = Consola.readChar();
            if (check != 's') {
                return;
            }
        }
        do {
            System.out.print("Ingrese el tamaño del arreglo (la cantidad de elementos que tendrá): ");
            cantidad = Consola.readInt();
        } while (cantidad < 0);

        char ascendencia;
        do {
            System.out.print("Ingrese 't' si quiere un heap ascendente, ó 'f' si quiere uno descentende.");
            ascendencia = Consola.readChar();
        } while (ascendencia != 't' && ascendencia != 'f');

        boolean ascendenciaBool = false;
        if (ascendencia == 't') {
            ascendenciaBool = true;
        }
        h = new Heap(cantidad, ascendenciaBool);
    }

    private static void cargaManual() {
        System.out.println("Comienza la carga...");
        int contador = 0;
        while (contador != cantidad) {
            System.out.print("Ingrese el número que desea agregar: ");
            int T = Consola.readInt();
            h.add(T);
            contador++;
        }
        System.out.println("La carga finalizó...");
    }

    private static void cargaAutomatica() {
        System.out.println("Comienza la carga...");
        int contador = 0;
        while (contador != cantidad) {
            h.add((int) (Math.random() * cantidad));
            contador++;
        }
        System.out.println("La carga finalizó...");
    }

    private static void agregarConSuerte() {
        System.out.print("Ingrese el numero a probar suerte: ");
        int suerte = Consola.readInt();
        if (h.lucky(suerte)) {
            System.out.println("El número se ingresó en la raiz... :D");
        } else {
            System.out.println("Seguí participando... insercion logaritmica :/");
        }
        char again = 'c';
        System.out.println("Deseas probar tu suerte de nuevo?...");
        System.out.print("(Presiona 's' para aceptar, o cualquier otra tecla para cancelar: )");
        again = Consola.readChar();
        if (again == 's') {
            agregarConSuerte();
        }
    }

    private static void mostrarOptimos() {
        SimpleList dosOptimosGet = h.getBoth();
        System.out.println("Optimos: \n" + dosOptimosGet.toString());
    }

    private static void removerOptimos() {
        SimpleList dosOptimosRemove = h.removeBoth();
        System.out.println("Removiendo los dos optimos: \n" + dosOptimosRemove.toString());

    }

    private static void toStringPorNiveles() {
        System.out.println(h.toString());
    }

    private static void toStringSinNiveles() {
        System.out.println(h.toStringSinNiveles());
    }

    private static void extraerElementos() {
        System.out.print("Mostramos en orden de extraccion: \n[ ");
        while (!h.isEmpty()) {
            int x = h.remove();
            System.out.print(x + " ");
        }
        System.out.println("]\n");
    }

    private static void testPropuesto() {
        //Creo un Heap de tamaño 6, inicialmente.
        h = new Heap<>(6, true);
        System.out.println("Se creó el Heap correctamente...");
        System.out.println("Ascendente y de tamaño inicial 6...");
        System.out.print("Presione Enter para continuar...");
        Consola.readLine();

        //Se agregan algunos elementos. Y el Heap se ordena cada vez que se agrega uno.
        h.add(5);
        h.add(12);
        h.add(20);
        h.add(8);
        h.add(10);
        h.add(11);
        System.out.println("Se cargaron algunos números...");
        System.out.print("Presione Enter para continuar...");
        Consola.readLine();

        //Se ponen dos ejemplos del metodo lucky(). Si el Heap es ascendente, el primer lucky() da true, y el siguiente false.
        //En caso de que el Heap sea descendente, el primero devuelve false, y el segundo true.
        System.out.println("Lucky?: " + h.lucky(4));
        System.out.println("Lucky?: " + h.lucky(30));

        System.out.print("Presione Enter para continuar...");
        Consola.readLine();
        //Se obtienen los dos optimos.
        //Si el Heap es ascendente, debe devolver la raiz y el hijo menor.
        //Si el Heap es descendente, debe devolver la raiz y el hijo mayor.
        SimpleList dosOptimosGet = h.getBoth();
        System.out.println("Optimos: \n" + dosOptimosGet.toString());
        System.out.print("Presione Enter para continuar...");
        Consola.readLine();

        //Lo mismo que el getBoth(), pero esta vez elimina los optimos.
        SimpleList dosOptimosRemove = h.removeBoth();
        System.out.println("Removiendo los dos optimos: \n" + dosOptimosRemove.toString());
        System.out.print("Presione Enter para continuar...");
        Consola.readLine();

        //Vector ordenado en forma de arbol binario completo o casi completo.
        System.out.println("Vector tipo arbol binario: \n" + h.toString());
        System.out.print("Presione Enter para continuar...");
        Consola.readLine();

        //A continuacion se extrae del Heap uno a uno el menor(si es ascendente) o el mayor(descendente).
        //Y se muestran por pantalla.
        System.out.print("Mostramos en orden de extraccion: \n[ ");
        while (!h.isEmpty()) {
            int x = h.remove();
            System.out.print(x + " ");
        }
        System.out.println("]\n");
        System.out.print("Presione Enter para volver al menú...");
        Consola.readLine();
    }
    
    private static boolean validarCargaHeap(){
        return (h != null);
    }
}
