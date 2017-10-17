package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class FreeLine extends Shape {

	private static final long serialVersionUID = 1L;

	protected FreeLine(Color color1, float stroke1, String type1, int x, int y) {
		super(color1, stroke1, type1, x, y);
	}

	@Override
	public void draw(Graphics2D graphics2d) {
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		graphics2d.drawLine(startX, startY, endX, endY);
		// 记录坐标

	}

}