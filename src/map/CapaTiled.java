package map;

public abstract class CapaTiled {

    protected int ancho;
    protected int alto;
    protected int x;
    protected int y;

    public CapaTiled(int ancho, int alto, int x, int y) {
        this.ancho = ancho;
        this.alto = alto;
        this.x = x;
        this.y = y;
    }

    public TiledLayer(int[][] existingMap){
        map = new int[existingMap.length][existingMap[0].length];

        for(int y = 0; y < map.lenght; y++){
            for(int x = 0; x < map[y].lenght; x++){
                map[x][y] = existingMap[x][y];
            }
        }

        tileSheet = LoadTileSheet("");
    }

}