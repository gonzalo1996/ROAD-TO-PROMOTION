package map;

public abstract class Map {

	private int width;
	private int tall;

	private int[] tiles;

	public Map(int width,int tall){

		this.width=width;
		this.tall=tall;

		tiles = new int[width*tall];
		generateMap();
	}

	public Map(String path){
		loadMap(path);
	}

	public void generateMap(){

	}

	public void loadMap(String path){

	}

	public void upDate(){

	}

	public void show(int compensationX,int compensationY/*, Screen screen*/){

	}



}
