package gameframework.base;

import java.awt.Graphics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrawableCompositeTest {

	Drawable drawable1, drawable2;
	int drawable1IsDrawn = 0;
	int drawable2IsDrawn = 0;
	
	@Before
	public void createDrawable1() {
		drawable1 = new Drawable() {
			

			@Override
			public void draw(Graphics g) {
				drawable1IsDrawn++;
			}
		};
	}
	
	@Before
	public void createDrawable2() {
		drawable2 = new Drawable() {
			

			@Override
			public void draw(Graphics g) {
				drawable2IsDrawn++;
			}
		};
	}
	
	@Test
	public void drawBoth() throws Exception {
		DrawableComposite composite = new DrawableComposite();
		composite.add(drawable1);
		composite.add(drawable2);
		
		assertEquals(drawable1IsDrawn, 0);
		assertEquals(drawable2IsDrawn, 0);
		composite.draw(null);
		assertEquals(drawable1IsDrawn, 1);
		assertEquals(drawable2IsDrawn, 1);
	}
	
}
