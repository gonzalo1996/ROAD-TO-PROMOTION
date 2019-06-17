package graphics;

import java.awt.image.BufferedImage;

public class Sprite {
	private final BufferedImage image;

	private final int width;
	private final int tall;

	public Sprite(final BufferedImage image) {
		this.image = image;

		width = image.getWidth();
		tall = image.getHeight();
	}

	public BufferedImage getImage() {
		return image;
	}

	public int getWidth() {
		return width;
	}

	public int getTall() {
		return tall;
	}
}
