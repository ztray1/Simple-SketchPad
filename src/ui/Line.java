package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Line extends Shape {

	private static final long serialVersionUID = 1L;

	private int lineStartX = 0;

	private int lineStartY = 0;

	private int lineEndX = 0;

	private int lineEndY = 0;

	private int direction = 0;

	protected Line(Color color1, float stroke1, String type1, int x, int y) {
		super(color1, stroke1, type1, x, y);
	}

	@Override
	public void draw(Graphics2D graphics2d) {
		graphics2d.setColor(color);
		graphics2d.setStroke(new BasicStroke(stroke));
		graphics2d.drawLine(currentX, currentY, currentX + endX - startX, currentY + endY - startY);
		// 记录坐标
		// graphics2d.drawLine(startX, startY, endX, endY);
		lineStartX = currentX;
		lineStartY = currentY;
		lineEndX = currentX + endX - startX;
		lineEndY = currentY + endY - startY;
	}

	public int getLineStartX() {
		return lineStartX;
	}

	public void setLineStartX(int lineStartX) {
		this.lineStartX = lineStartX;
	}

	public int getLineStartY() {
		return lineStartY;
	}

	public void setLineStartY(int lineStartY) {
		this.lineStartY = lineStartY;
	}

	public int getLineEndX() {
		return lineEndX;
	}

	public void setLineEndX(int lineEndX) {
		this.lineEndX = lineEndX;
	}

	public int getLineEndY() {
		return lineEndY;
	}

	public void setLineEndY(int lineEndY) {
		this.lineEndY = lineEndY;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
