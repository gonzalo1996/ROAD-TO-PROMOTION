package Exceptions;

public class FullInventoryException extends Exception {
    public FullInventoryException(String s){
        super(s);
    }

    public FullInventoryException(){
        super();
    }

}
