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

    //GETTERS & SETTERS
    public ArrayList<T> getElement_list() {
        return element_list;
    }

    public void setElement_list(ArrayList<T> element_list) {
        this.element_list = element_list;
    }
}
