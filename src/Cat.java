import javax.swing.JPanel;
import javax.swing.plaf.ColorChooserUI;

import java.awt.*;
import java.awt.geom.*;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 100;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 10;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/4;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 2;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		// Draw one ear
		Polygon p1 = new Polygon();
		p1.addPoint(x + 30, y + 15);
		p1.addPoint(x + 8, y + 40);
		p1.addPoint(x - 40, y - 30);
		g2.setColor(Color.orange);
		g2.fillPolygon(p1);
		g2.drawPolygon(p1);
		// Draw the other ear
		x += HEAD_DIMENSION;
		Polygon p2 = new Polygon();
		p2.addPoint(x - 30, y + 15);
		p2.addPoint(x - 8, y + 40);
		p2.addPoint(x + 40, y - 30);
		g2.fillPolygon(p2);
		g2.drawPolygon(p2);
		x -= HEAD_DIMENSION;
		// Draw the head
		g2.setColor(Color.MAGENTA);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.darkGray);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.rotate(0.5, x, y);
		g2.fillRect(x, y - 15, 15, 5);
		g2.rotate(-0.5, x, y);
		g2.setColor(Color.green);
		g2.fillOval(x, y, EYE_HEIGHT, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.setColor(Color.darkGray);
		g2.rotate(-0.5, x, y);
		g2.fillRect(x, y-10, 15, 5);
		g2.rotate(0.5, x, y);
		g2.setColor(Color.green);
		g2.fillOval(x, y, EYE_HEIGHT, EYE_HEIGHT);

		g2.setColor(Color.black);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y + 5;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		// Draw the nose
		g2.setColor(Color.black);
		x += 7;
		y -= 14;
		g2.fillOval(x, y, MOUTH_HEIGHT, MOUTH_HEIGHT);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("Meow, world!", catX, catY+HEAD_DIMENSION+10);	
	}
}
