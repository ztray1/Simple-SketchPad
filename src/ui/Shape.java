package ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;

public abstract class Shape extends JLabel implements MouseMotionListener {

	private static final long serialVersionUID = 1L;

	/** 画笔大小 */
	protected float stroke;
	/** 画笔颜色 */
	protected Color color;
	/** 图形类型 */
	protected String type;

	protected int startX = 0;
	protected int startY = 0;
	protected int endX = 0;
	protected int endY = 0;
	protected int currentX = 0;
	protected int currentY = 0;
	protected int currentD = 0;
	protected int currentC = 0;
	protected int endX1 = 0;
	protected int endY1 = 0;

	protected Shape(Color color1, float stroke1, String type1, int x, int y) {
		type = type1;
		color = color1;
		stroke = stroke1;
		startX = endX = currentX = x;
		startY = endY = currentY = y;

		addMouseMotionListener(this);
	}

	public void mousePressed(MouseEvent mouseevent) {
		if (DrawingBoard.cursor == 0) {
			startX = mouseevent.getX();
			startY = mouseevent.getY();
		}

	}

	public void mousereleased(MouseEvent mouseevent) {
		/*
		 * if (DrawingBoard.cursor == 1) { endX1 = mouseevent.getX(); endY1 =
		 * mouseevent.getY(); }
		 */

	}

	public void mouseDragged(MouseEvent mouseevent) {
		// 变成十字架拖放的时候，需要计算圆形和三角形
		/*
		 * if (DrawingBoard.cursor == 0) { // 鼠标是箭头的话 endX1 = mouseevent.getX();
		 * endY1 = mouseevent.getY(); }
		 */
		if (DrawingBoard.cursor == 1) {
			endX = mouseevent.getX();
			endY = mouseevent.getY();
			currentD = Math.abs(startX - endX);
			currentC = Math.abs(startY - endY);

			if (startX > endX) {
				currentX = endX;
			}
			if (startY > endY) {
				currentY = endY;
			}
		} else {// 拖放完毕之后再次点击只需要控制位置即可
			currentX = mouseevent.getX();
			currentY = mouseevent.getY();
		}

	}

	public void mouseMoved(MouseEvent mouseevent) {
		// 鼠标移动
	}

	/**
	 * 调用画板来画图
	 * 
	 * @param graphics2d
	 *            画板的graphics
	 */
	public abstract void draw(Graphics2D graphics2d);

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
