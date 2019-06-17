package graphics;



public final class Screen {

	private final int width;
	private final int tall;
	private final int[] pixel;


	public Screen(int width, int tall) {
		this.width = width;
		this.tall = tall;
		pixel = new int[width*tall];
	}
	//Este metodo nos va a servir para cada vez que redibujemos la pantalla, lo limpie y lo redibuje

	public void cleanScreen(){
		for(int i=0;i<pixel.length;i++){
			pixel[i]=0;
		}
	}

	//CompesationX e Y, es el movimiento que estemos haciendo con el personaje (W A S D)
	public void drawScreen(final int compensationX,final int compesantionY){
		for(int y=0;y<tall;y++){
			int positionY= y+compesantionY;
			if (positionY < 0 || positionY>= tall){
				continue; //Este comando, significa que al llegar a este punto
						//si esta condicion se cumple, corta el bucle
				//Para que no se pase del mapa
			}
			for (int x=0; x<width; x++){
				int positionX=x+compensationX;
				if (positionX < 0 || positionX>= tall){
					continue;
				}
				//Codigo para Redibujar en la pantalla
				
			}
		}
	}
}
