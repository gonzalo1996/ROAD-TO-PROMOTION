package inventaryClasses;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Inventario en dÃ³nde se va a almacenar todos los ELEMENTOS.
 * @param <T>
 */
public class Inventory<T extends Element> {
    ArrayList<T> element_list;

    /**
     * Agrega un elemento al inventario.
     * @param t
     */
    public boolean addElement(T t){
        boolean ans = false;

        if(!element_list.contains(t)){
            element_list.add(t);
            ans = true;
        }
        return ans;
    }

    public boolean removeElement(T t){
        boolean ans = false;
        if(element_list.contains(t)) {
            element_list.remove(t);
            ans = true;
        }
        return ans;
    }

    //TODO: ver si se puede hacer un solo metodo para los conteins
    public boolean containsPotions(){
        boolean rta=false;

        for (T aux : element_list) {
            if (aux instanceof Potion){
                rta=true;
            }
        }

        return rta;

    }

    public boolean containsShields(){
        boolean rta=false;

        for (T aux : element_list) {
            if (aux instanceof Shield){
                rta=true;
            }
        }

        return rta;

    }

    /**
     * te muestra un item aleatorio, y devuelve el indice
     * @return -1 = no acepto el item, ans>0 acepto el item y este es su indice dentro del arreglo
     */
    public int showRandomItemToDrop (){
        int ans = ThreadLocalRandom.current().nextInt(0, element_list.size());

        //TODO: CAMBIAR POR SWING QUE NO SE COMO FUNCIONA jeje
//        System.out.println("\nQuiere haceptar el item? y/n \n");
//        scanner sc = new scanner(system.in);
//        char c = sc.nextChar();
//        if (c=="n"){
//            ans == -1;
//        }

        return ans;
    }

    /**
     * devuelve el elemento del inventario
     * @param indexOfItem
     * @return
     */
    public T dromItem(int indexOfItem) {
        element_list.remove(indexOfItem);
        return element_list.get(indexOfItem);
    }


    //GETTERS & SETTERS
    public ArrayList<T> getElement_list() {
        return element_list;
    }

    public void setElement_list(ArrayList<T> element_list) {
        this.element_list = element_list;
    }
		/*element_list.add();
		element_list.remove();
		element_list.contains();*/

}
