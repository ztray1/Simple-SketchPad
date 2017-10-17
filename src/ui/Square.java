package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Square extends Shape {

	private static final long serialVersionUID = 1L;

	public Square(Color color, float stroke, String type, int x, int y) {
		super(color, stroke, type, x, y);
	}

	public void draw(Graphics2D graphics2d) {
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		graphics2d.drawRect(currentX, currentY, currentD, currentC);
	}
}
