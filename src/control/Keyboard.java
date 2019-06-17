package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Final, por que no vamos a extender dicha clase
public final class Keyboard implements KeyListener {
	//Cantidad de teclas en un teclado
	private final  static int numbersKeys=120;
	private  final boolean[] keys= new boolean[numbersKeys];

	public boolean up;
	public boolean down;
	public boolean left;
	public boolean right;

	public void toUpdate(){
		up = keys[KeyEvent.VK_W];
		down= keys[KeyEvent.VK_S];
		left= keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
	}

	//Presionar y soltar una tecla
	//TODO: Estos metodos, leen el codigo de la tecla que se presiono y le damos true cuando se presiona y luego false


	//Cuando se presiona una tecla
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]= true;
	}

	//Cuando soltamos una tecla, que habiamos pulsado
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]= false;
	}
	public void keyTyped(KeyEvent e) {
	}
}
