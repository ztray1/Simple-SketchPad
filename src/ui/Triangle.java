package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Triangle extends Shape {

	private static final long serialVersionUID = 1L;

	private int xS[] = null;
	private int yS[] = null;

	public Triangle(Color color, float stroke, String type, int x, int y) {
		super(color, stroke, type, x, y);
		// 初始化
		xS = new int[3];
		yS = new int[3];
	}

	public void draw(Graphics2D graphics2d) {
		xS[0] = currentX;
		yS[0] = currentY;
		xS[1] = currentX + currentD;
		yS[1] = currentY;
		xS[2] = currentX + currentD / 2;
		yS[2] = (int) (currentY - currentD / 2 * 1.732);

		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		graphics2d.drawPolygon(xS, yS, 3);
	}

}
