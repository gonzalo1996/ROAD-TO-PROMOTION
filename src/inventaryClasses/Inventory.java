package inventaryClasses;


import Exceptions.FullInventoryException;

import java.util.ArrayList;

/**
 * Inventario en dÃ³nde se va a almacenar todos los ELEMENTOS.
 * @param <T> receive Element objects only
 */
public class Inventory<T extends Element>{
    private final static int MAX_ELEMENTS=30;
    ArrayList<T> element_list;

    public Inventory(){
        element_list = new ArrayList<>(MAX_ELEMENTS);
    }

    public boolean addElement(T t)throws FullInventoryException {
        boolean element_added = false;

        if(element_list.size() < MAX_ELEMENTS){
            element_list.add(t);
            element_added = true;
        }

        if(element_added == false){
            //TODO: crear un JPanel que le comunique al usuario que el inventario está lleno.
            throw new FullInventoryException("Inventory is full. Please delete an Element");
        }

        return element_added;
    }

    public boolean removeElement(T t){
        boolean element_removed = false;
        if(element_list.contains(t)) {
            element_list.remove(t);
            element_removed = true;
        }

        return element_removed;
    }

    //TODO: ver si se puede hacer un solo metodo para los conteins
    public boolean containsPotions(){
        boolean rta=false;
        for (T aux : element_list){
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
