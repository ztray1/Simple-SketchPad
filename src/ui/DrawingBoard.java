package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.ColorParam;
import data.ImageParam;
import data.LineParam;
import data.PointParam;
//import data.TextParam;

public class DrawingBoard extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener {

	private static final long serialVersionUID = 1L;

	private int tool = 0;
	/** mouse shape */
	public static int cursor = 0;
	/** current shape */
	public Shape currentShape;
	/** shape arraylist */
	public ArrayList<Shape> shapes;
	/** redo arraylist */
	public ArrayList<Shape> cancel_shapes;

	// private String context;
	/** image */
	private ImageParam image;

	private BufferedImage readbimg;

	// default color
	public Color oval_color = Color.GREEN;
	public Color circle_color = Color.GREEN;
	public Color square_color = Color.GREEN;
	public Color tria_color = Color.GREEN;
	public Color line_color = Color.GREEN;

	// default size
	public float oval_stroke = 10.0F;
	public float circle_stroke = 10.0F;
	public float square_stroke = 10.0F;
	public float tria_stroke = 10.0F;
	public float line_stroke = 10.0F;

	public String text_face = "微软雅黑";
	// public int text_style = 0;
	// public int text_size = 20;

	public String path = "test1.jpg";

	private int old_width = 0;
	private int old_height = 0;
	private int new_width = 0;
	private int new_height = 0;

	public DrawingBoard() {
		setBackground(Color.WHITE);
		shapes = new ArrayList<Shape>();
		cancel_shapes = new ArrayList<Shape>();
		addMouseListener(this);
		addMouseWheelListener(this);
		addMouseMotionListener(this);

		image = new ImageParam(1300, 868, new ColorParam(0, 0, 0));
		image.setLines(new ArrayList<LineParam>());
		// image.setTexts(new ArrayList<TextParam>());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		// draw
		ImageIcon icon = createImageIcon(path);
		graphics2d.drawImage(icon.getImage(), 0, 0, new_width, new_height, this);

		// draw shape
		if (null != shapes && shapes.size() > 0) {
			for (int i = 0; i < shapes.size(); i++) {
				((Shape) shapes.get(i)).draw(graphics2d);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (cursor == 1) {
			if (e.getButton() == 1) {
				switch (tool) {
				case 0: // oval
					currentShape = new Oval(oval_color, oval_stroke, "oval", e.getX(), e.getY());
					break;
				case 1: // triangle
					currentShape = new Triangle(tria_color, tria_stroke, "triangle", e.getX(), e.getY());
					break;
				case 2: // line
					currentShape = new Line(line_color, line_stroke, "line", e.getX(), e.getY());
					break;
				/*
				 * case 3: // 文字 currentShape = new Text(text_color, "text",
				 * e.getX(), e.getY(), context, text_face, text_style,
				 * text_size); break;
				 */
				case 4: // circle
					currentShape = new Circle(circle_color, circle_stroke, "circle", e.getX(), e.getY());
					break;
				case 5: // square
					currentShape = new Square(square_color, square_stroke, "square", e.getX(), e.getY());
					break;
				case 6: // 手画线条
					currentShape = new FreeLine(line_color, line_stroke, "line", e.getX(), e.getY());
					break;

				default://
					break;
				}

				shapes.add(currentShape);
				repaint();
			}
		}
		if (cursor == 0) {
			if (e.getButton() == 1) {
				/*
				 * switch (tool) { case 6: // freeline currentShape = new
				 * FreeLine(line_color, line_stroke, "line", e.getX(),
				 * e.getY()); break;
				 * 
				 * default:// break;
				 */

			}

		}
		shapes.add(currentShape);
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// if (cursor != 1) {
		// JOptionPane.showMessageDialog(this, "请选择一种将要绘制的类型！");
		// return;
		// }
		if (getCursor().getType() == Cursor.E_RESIZE_CURSOR) {
			if (e.getX() < old_width) {
				new_width = e.getX();
				repaint();
			}
		} else if (getCursor().getType() == Cursor.S_RESIZE_CURSOR) {
			if (e.getY() < old_height) {
				new_height = e.getY();
				repaint();
			}
		} else if (getCursor().getType() == Cursor.SE_RESIZE_CURSOR) {
			if (e.getX() < old_width && e.getY() < old_height) {
				new_width = e.getX();
				new_height = e.getY();
				repaint();
			}
		} else {
			if (null != currentShape) {
				currentShape.mouseDragged(e);
				repaint();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		cursor = 0;
		setCursor(new Cursor(cursor));

		// 添加一条线路
		if (currentShape instanceof Line) {
			Line temp = (Line) currentShape;
			LineParam line = new LineParam();
			line.setSize(12);
			line.setStart(new PointParam(temp.getLineStartX(), temp.getLineStartY()));
			line.setEnd(new PointParam(temp.getLineEndX(), temp.getLineEndY()));
			image.getLines().add(line);
		}

		// 添加一行文字
		/*
		 * if (currentShape instanceof Text) { // 开始点 PointParam start = new
		 * PointParam(((Text) currentShape).getLineStartX(), ((Text)
		 * currentShape).getLineStartY()); String word = ((Text)
		 * currentShape).getRoadName(); // 文字的排序 TextParam text = new
		 * TextParam(null, word, ((Text) currentShape).getTextSize(), start,
		 * null, null); image.getTexts().add(text); }
		 */
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3) {
			if (null != currentShape) {
				AttributeDialog dialog = new AttributeDialog(this);
				dialog.setLocationRelativeTo(this);
				dialog.setVisible(true);
			}
		} else if (e.getButton() == 1) {
			if (null != currentShape) {
				currentShape.mouseDragged(e);
				repaint();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// 鼠标进入
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// 鼠标退出
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// 鼠标移动
		if (getCursor().getType() == 1) {
			return;
		}
		if ((e.getX() == new_width || e.getX() == new_width + 1 || e.getX() == new_width - 1
				|| e.getX() == new_width + 2 || e.getX() == new_width - 2 || e.getX() == new_width + 3
				|| e.getX() == new_width - 3)
				&& (e.getY() == new_height || e.getY() == new_height + 1 || e.getY() == new_height - 1
						|| e.getY() == new_height + 2 || e.getY() == new_height - 2 || e.getY() == new_height + 3
						|| e.getY() == new_height - 3)) {
			setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
		} else {
			if ((e.getX() == new_width || e.getX() == new_width + 1 || e.getX() == new_width - 1
					|| e.getX() == new_width + 2 || e.getX() == new_width - 2) && (getCursor().getType() != 5)) {
				setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
			} else if ((e.getY() == new_height || e.getY() == new_height + 1 || e.getY() == new_height - 1
					|| e.getY() == new_height + 2 || e.getY() == new_height - 2) && (getCursor().getType() != 5)) {
				setCursor(new Cursor(Cursor.S_RESIZE_CURSOR));
			} else {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// 向前滚动
		if (e.getWheelRotation() == -1) {
			if (new_width < old_width) {
				new_width += 4;
			}
			if (new_height < old_height) {
				new_height += 2;
			}
			repaint();
		}
		// 向前滚动
		if (e.getWheelRotation() == 1) {
			new_width -= 4;
			new_height -= 2;
			repaint();
		}
	}

	/**
	 * 保存绘制好的图像
	 */
	public void saveImage() {
		try {
			BufferedImage bimg = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2d = bimg.createGraphics();
			paint(graphics2d);// 关键
			File file = new File("D:/workspace/Draw/images/temp.jpg");
			ImageIO.write(bimg, "jpg", file);
			JOptionPane.showMessageDialog(this, "已成功保存到D:/workspace/Draw/images/temp.jpg");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "保存出错");
			e.printStackTrace();
		}
	}

	/**
	 * 清楚屏幕已绘制的图像
	 */
	public void clearBoard() {
		shapes.clear();
		image.getLines().clear();
		// image.getTexts().clear();
		repaint();
	}

	/**
	 * 选择图形类型
	 * 
	 * @param i
	 *            0、圆形 1、三角形 2、线条 3、文字
	 */
	public void setTool(int i) {
		if (i < 0 || i > 6) {
			throw new IllegalArgumentException("Invaild Tool Specified!");
		} else {
			tool = i;
		}
	}

	/**
	 * 设置画笔类型（每种图形画笔不同）
	 * 
	 * @param size
	 *            画笔大小
	 * @param type
	 *            图形
	 */
	public void setStrokeSize(float size, String type) {
		if (null == currentShape) {
			throw new NullPointerException("currentShap is Null!");
		}
		if (size < 0 || size > 10) {
			throw new IllegalArgumentException("Invaild Weight Specified!");
		}
		if ("oval".equals(type)) {
			oval_stroke = size;
		}
		if ("tria".equals(type)) {
			tria_stroke = size;
		}
		if ("line".equals(type)) {
			line_stroke = size;
		}
		if ("circle".equals(type)) {
			line_stroke = size;
		}
		if ("square".equals(type)) {
			square_stroke = size;
		}
		if ("freeline".equals(type)) {
			square_stroke = size;
		}
		currentShape.stroke = size;
		repaint();
	}

	/**
	 * 设置当前图形横坐标
	 * 
	 * @param x
	 *            横坐标
	 */
	public void setCurrentX(int x) {
		currentShape.currentX = x;
		repaint();
	}

	/**
	 * 设置当前图形纵坐标
	 * 
	 * @param y
	 *            纵坐标
	 */
	public void setCurrentY(int y) {
		currentShape.currentY = y;
		repaint();
	}

	/**
	 * 设置当前图形缩放比例（主要是圆形和三角形）
	 * 
	 * @param d
	 *            比例
	 */
	public void setCurrentD(int d) {
		currentShape.currentD = d;
		repaint();
	}

	/**
	 * 设置当前图形颜色
	 * 
	 * @param color
	 *            颜色
	 */
	public void setCurrentColor(Color color) {
		currentShape.color = color;
		repaint();
	}

	/**
	 * 设置当前文字图形的字体
	 * 
	 * @param name
	 *            字体
	 */
	/*
	 * public void setCurrentTxtFontFace(String name) { ((Text)
	 * currentShape).setTextFace(name); repaint(); }
	 */

	/**
	 * 设置当前文字图形的样式
	 * 
	 * @param style
	 *            样式
	 */
	/*
	 * public void setCurrentTxtFontStyle(String style) { if
	 * (style.equals("常规")) { ((Text) currentShape).setTextStyle(Font.PLAIN); }
	 * if (style.equals("粗体")) { ((Text) currentShape).setTextStyle(Font.BOLD);
	 * } if (style.equals("斜体")) { ((Text)
	 * currentShape).setTextStyle(Font.ITALIC); } repaint(); }
	 */

	/**
	 * 设置当前文字图形的大小
	 * 
	 * @param size
	 *            大小
	 */
	/*
	 * public void setCurrentTxtFontSize(String size) { ((Text)
	 * currentShape).setTextSize(Integer.valueOf(size)); repaint(); }
	 */

	/**
	 * 
	 * @param image
	 *            path
	 * 
	 * @return ImageIcon
	 */
	private ImageIcon createImageIcon(String path) {
		if (null != path && !"".equals(path)) {
			// BufferedImage im = ImageIO.read(new File("images/" + path));
			// ImageIcon temp = new ImageIcon(im);
			ImageIcon image = new ImageIcon("images/" + path);
			if (old_width == 0) {
				new_width = old_width = image.getIconWidth();
			}
			if (old_height == 0) {
				new_height = old_height = image.getIconHeight();
			}
			return image;
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	public ImageParam getImage() {
		return image;
	}

	public void setImage(ImageParam image) {
		this.image = image;
	}

	/*
	 * public String getContext() { return context; }
	 */

	/*
	 * public void setContext(String context) { this.context = context; }
	 */

	public void openImage(Graphics g) {
		// TODO Auto-generated method stub

		try {
			// BufferedImage bimg = new BufferedImage(getWidth(), getHeight(),
			// BufferedImage.TYPE_INT_RGB);
			// Graphics2D graphics2d = bimg.createGraphics();
			// paint(graphics2d);// 关键
			File file = new File("D:/workspace/Draw/images/temp.jpg");
			BufferedImage readbimg = ImageIO.read(file);
			g.drawImage(readbimg, 20, 20, getWidth(), getHeight(), null);
			JOptionPane.showMessageDialog(this, "open");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "save fault");
			e.printStackTrace();
		}

	}

}
