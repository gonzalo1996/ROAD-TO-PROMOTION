package inventaryClasses;


import interfaces.IEquip;
import enumerations.EHierarchy;

public abstract class Element implements IEquip{

    private static int cantidad_elementos;
    private int id_numeroElemento;
    private boolean selected;
    private String name_of_element;//nombre espada, nombre pociÃ³n, nombre shield, nombre armor
    private EHierarchy jerarquia; //1 es legendario, 2 es exotico, 3 peculiar, 4 comun. Es un #Bonus#

    public Element(String name_of_element, EHierarchy jerarquia) {
        cantidad_elementos++;
        id_numeroElemento = cantidad_elementos;
        this.name_of_element = name_of_element;
        this.jerarquia = jerarquia;
    }

    @Override
    public boolean equals(Object obj) {
        boolean answer=false;
        if(obj instanceof Element){
            Element e = (Element)obj;
            if( this.getId_numeroElemento() == e.getId_numeroElemento() ){
                answer = true;
            }
        }
        return answer;
    }

    public Element() {
        id_numeroElemento = -1;
        name_of_element = "";
        jerarquia = null;
    }

    public int getId_numeroElemento() {
        return id_numeroElemento;
    }

    public String getName_of_element() {
        return this.name_of_element;
    }

    public EHierarchy getJerarquia() {
        return jerarquia;
    }

    //	arreglar esta villeriada
    @Override
    public double use() {
        return 0;
    }

    @Override
    public String toString() {
        return "\nId: "+ id_numeroElemento +" Nombre: " + this.getName_of_element() + " Jerarquia: " + this.getJerarquia() + " ";
    }

//	@Override
//	public int getIdWeapon() {
//		// TODO Auto-generated method stub
//		return 0;
//	}

}
