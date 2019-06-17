package graphics;

import java.awt.image.BufferedImage;

/**
 * Hoja de Sprite
 */
public class SpriteSheet {
	//ancho de hoja en pixeles
	final private int widthSheetPixels;
	//Alto de hoja en pixeles
	final private int tallSheetinPixel;

	//ancho Hoja En Sprites
	final private int WideSheetOnSprites;
	//alto Hoja En Sprites
	final private int HighLeafOnSprites;

	//Ancho sprites
	final private int widthSprites;
	//alto Sprite
	final private int tallSprites;
	final private Sprite[] sprites;

	//Inicio de coleccion de los Sprites
/*
	//TODO: falta agregar los recursos antes de inicial los sprites, de los personajes
	public static SpriteSheet Boss= new SpriteSheet(final String path, final int spriteSide, final boolean opaqueSheet);
*/
	//Fin de la coleccion de los Sprites

	//Le pasamos la ruta, donde esta la hoja de sprite, luego el lado del sprite y la hoja opacada
	public SpriteSheet(final String path, final int spriteSide, final boolean opaqueSheet) {
		//TODO: MISMA SITUACION QUE EL OTRO CONSTRUCTOR
		final BufferedImage image = null; //	Creamos la imagen

		/* //TODO: AUN NO LLEGUE A ESTA PARTE DEL VIDEO
		if (opaqueSheet) {

			image = CargadorRecursos.cargarImagenCompatibleOpaca(path);
		} else {
			image = CargadorRecursos.cargarImagenCompatibleTranslucida(path);
		}*/

		widthSheetPixels = image.getWidth();
		tallSheetinPixel = image.getHeight();

		WideSheetOnSprites = widthSheetPixels / spriteSide;
		HighLeafOnSprites = tallSheetinPixel / spriteSide;

		widthSprites = spriteSide;
		tallSprites = spriteSide;

		sprites = new Sprite[WideSheetOnSprites * HighLeafOnSprites];

		FillSpritesFromImage(image);
	}

	public SpriteSheet(final String path, final int width, final int widthSprite, final boolean sheetOpaque) {
		//TODO: POSIBLEMENTE SE TENDRA QUE SACAR ESE NULL, YA QUE  EL METODO DE ABAJO ES EL QUE INICILIZA LA IMAGEN
		final BufferedImage image = null;

		//TODO: MISMA SITUACION, AUN NO LLEGUE A  VER LA IMPLEMENTACION DE ESTE METODO
		/*if (sheetOpaque) {
			image = CargadorRecursos.cargarImagenCompatibleOpaca(path);
		} else {
			image = CargadorRecursos.cargarImagenCompatibleTranslucida(path);
		}
*/
		widthSheetPixels = image.getWidth();
		tallSheetinPixel = image.getHeight();

		WideSheetOnSprites = widthSheetPixels / width;
		HighLeafOnSprites = tallSheetinPixel / widthSprite;

		this.widthSprites = width;
		this.tallSprites = widthSprite;

		sprites = new Sprite[WideSheetOnSprites * HighLeafOnSprites];

		FillSpritesFromImage(image);
	}

	private void FillSpritesFromImage(final BufferedImage image) {
		for (int y = 0; y < HighLeafOnSprites; y++) {
			for (int x = 0; x < WideSheetOnSprites; x++) {
				final int positionX = x * widthSprites;
				final int positionY = y * tallSprites;

				sprites[x + y * WideSheetOnSprites] = new Sprite(
						image.getSubimage(positionX, positionY, widthSprites, tallSprites));
			}
		}
	}

	public Sprite obtenerSprite(final int indice) {
		return sprites[indice];
	}

	public Sprite obtenerSprite(final int x, final int y) {
		return sprites[x + y * WideSheetOnSprites];
	}

}
