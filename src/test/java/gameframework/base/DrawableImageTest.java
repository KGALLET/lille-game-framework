package gameframework.base;

import java.awt.Canvas;
import java.awt.Image;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DrawableImageTest {

	private Canvas canvas;

	@Before
	public void createCanvas() {
		canvas = new Canvas();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCantCreateFromNull() throws Exception {
		new DrawableImage((URL)null, canvas);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantCreateFromNonExisting() throws Exception {
		new DrawableImage("non existing file name.gif", canvas);
	}

	@Test
	public void createFromFilename() {
		DrawableImage drawableImage = new DrawableImage("/courbes.png", canvas);
		Image image = drawableImage.getImage();
		assertNotNull(image);
	}
	
}
