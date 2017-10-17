package main;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import ui.ConfigDialog;
import ui.DrawingBoard;
import ui.Shape;

/**
 * mainpage
 * 
 */
public class AppFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	/** toolbar */
	private JToolBar toolbar;
	/** circle button */
	private JButton ovalButton;
	/** rectangele button */
	private JButton squareButton;
	/** freeline button */
	private JButton freelineButton;
	/** oval button */
	private JButton circleButton;
	/** exit button */
	private JButton exitButton;
	/** clear button */
	private JButton clearButton;
	/** trianglebutton */
	private JButton triangleButton;
	/** 文字按钮 */
	private JButton textButton;
	/** line button */
	private JButton lineButton;
	/** undo button */
	private JButton cancelButton;
	/** redo button */
	private JButton backButton;
	/** save picture */
	private JButton pictureButton;
	/** open picture */
	private JButton openButton;
	/** delete picture **/
	private JButton deleteButton;
	/** copy picture **/
	private JButton copyButton;

	/** config */
	private JButton configButton;
	/** draw board */
	private DrawingBoard board;

	private int i = 0;

	private static final Font font = new Font("微软雅黑", 0, 12);

	private JButton testButton1;
	private JButton testButton2;
	private JButton testButton3;

	public AppFrame() {
		initGUI();
	}

	private void initGUI() {
		setSize(1300, 868);
		setTitle("JAVA draw board");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Button
		freelineButton = new JButton();
		squareButton = new JButton();
		circleButton = new JButton();
		ovalButton = new JButton();
		exitButton = new JButton();
		clearButton = new JButton();
		lineButton = new JButton();
		triangleButton = new JButton();
		textButton = new JButton();
		cancelButton = new JButton();
		backButton = new JButton();
		pictureButton = new JButton();
		openButton = new JButton();
		configButton = new JButton();
		deleteButton = new JButton();
		copyButton = new JButton();

		testButton1 = new JButton();
		testButton2 = new JButton();
		testButton3 = new JButton();

		// add ToolBar
		toolbar = new JToolBar();
		toolbar.add(configButton);
		toolbar.add(ovalButton);
		toolbar.add(circleButton);
		toolbar.add(squareButton);
		toolbar.add(triangleButton);
		toolbar.add(freelineButton);
		toolbar.add(lineButton);
		// toolbar.add(textButton);
		toolbar.add(clearButton);
		toolbar.add(cancelButton);
		toolbar.add(backButton);
		toolbar.add(pictureButton);
		toolbar.add(openButton);
		toolbar.add(exitButton);
		toolbar.add(deleteButton);
		toolbar.add(copyButton);

		toolbar.add(testButton1);
		// toolbar.add(testButton2);
		// toolbar.add(testButton3);

		// borad
		board = new DrawingBoard();

		configButton.setFont(font);
		configButton.setText("setting");
		configButton.addActionListener(this);

		ovalButton.setFont(font);
		ovalButton.setText("circle");
		ovalButton.addActionListener(this);

		circleButton.setFont(font);
		circleButton.setText("oval");
		circleButton.addActionListener(this);

		squareButton.setFont(font);
		squareButton.setText("square");
		squareButton.addActionListener(this);

		triangleButton.setFont(font);
		triangleButton.setText("triangle");
		triangleButton.addActionListener(this);

		freelineButton.setFont(font);
		freelineButton.setText("freeline");
		freelineButton.addActionListener(this);

		lineButton.setFont(font);
		lineButton.setText("line");
		lineButton.addActionListener(this);

		clearButton.setFont(font);
		clearButton.setText("clear");
		clearButton.addActionListener(this);

		cancelButton.setFont(font);
		cancelButton.setText("undo");
		cancelButton.addActionListener(this);

		backButton.setFont(font);
		backButton.setText("redo");
		backButton.addActionListener(this);

		pictureButton.setFont(font);
		pictureButton.setText("save");
		pictureButton.addActionListener(this);

		openButton.setFont(font);
		openButton.setText("open");
		openButton.addActionListener(this);

		exitButton.setFont(font);
		exitButton.setText("exit");
		exitButton.addActionListener(this);

		deleteButton.setFont(font);
		deleteButton.setText("delete");
		deleteButton.addActionListener(this);

		copyButton.setFont(font);
		copyButton.setText("copy");
		copyButton.addActionListener(this);

		testButton1.setFont(font);
		testButton1.setText("pic 1");
		testButton1.addActionListener(this);

		testButton2.setFont(font);
		testButton2.setText("pic 2");
		testButton2.addActionListener(this);

		testButton3.setFont(font);
		testButton3.setText("pic3");
		testButton3.addActionListener(this);

		getContentPane().add(toolbar, "North");
		getContentPane().add(board, "Center");
	}

	/**
	 *
	 * 
	 * @param path
	 * 
	 * @return ImageIcon
	 */
	private ImageIcon createImage(String path) {
		if (null != path && !"".equals(path)) {
			return new ImageIcon("images/" + path);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	/**
	 * @param type
	 * 
	 */
	private void drawAll(int type, String name) {
		board.setTool(type);
		DrawingBoard.cursor = 1;
		board.setCursor(new Cursor(1));
		/*
		 * if (type == 3 && null != name) { board.setContext(name); }
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ovalButton) {
			drawAll(0, null);
			i = 1;
		} else if (e.getSource() == circleButton) {
			drawAll(4, null);
			i = 1;
		} else if (e.getSource() == squareButton) {
			drawAll(5, null);
			i = 1;
		} else if (e.getSource() == freelineButton) {
			drawAll(6, null);
			i = 1;
		} else if (e.getSource() == triangleButton) {
			drawAll(1, null);
			i = 1;
		} else if (e.getSource() == lineButton) {
			drawAll(2, null);
			i = 1;
		} /*
			 * else if (e.getSource() == textButton) { String roadName =
			 * JOptionPane.showInputDialog("请输入文字名称!"); if (roadName == null ||
			 * "".equals(roadName)) { JOptionPane.showMessageDialog(null,
			 * "文字不能为空", "ERROR", JOptionPane.ERROR_MESSAGE); return; }
			 * drawAll(3, roadName); }
			 */else if (e.getSource() == clearButton) {
			board.clearBoard();
			// clear record
			board.shapes.clear();
			board.cancel_shapes.clear();
		} else if (e.getSource() == cancelButton) {
			if (board.shapes.size() < 1) {
				JOptionPane.showMessageDialog(null, "no undo operation！");
				return;
			}
			// get the component before
			int my_index = board.shapes.indexOf(board.currentShape);
			Shape before = my_index > 0 ? board.shapes.get(my_index - 1) : null;
			if (!board.cancel_shapes.contains(board.currentShape)) {
				// delete from arraylist
				board.shapes.remove(board.currentShape);
				// record delete shape
				board.cancel_shapes.add(board.currentShape);
				// change currentshape
				board.currentShape = before;
			}
			board.repaint();
		} else if (e.getSource() == backButton) {
			if (board.cancel_shapes.size() < 1) {
				JOptionPane.showMessageDialog(null, "no redo operation！");
				return;
			}

			Shape shape = board.cancel_shapes.get(board.cancel_shapes.size() - 1);
			if (!board.shapes.contains(shape)) {
				// delete redo arraylist
				board.cancel_shapes.remove(shape);
				board.shapes.add(shape);
				board.currentShape = shape;
			}
			board.repaint();
		} else if (e.getSource() == openButton) {
			board.path = "temp.jpg";
			board.repaint();
			// openImage(getGraphics());
		} else if (e.getSource() == pictureButton) {
			board.saveImage();
		} else if (e.getSource() == exitButton) {
			System.exit(0);
		} else if (e.getSource() == configButton) {
			ConfigDialog config = new ConfigDialog(board);
			config.setLocationRelativeTo(null);
			config.setVisible(true);
		} else if (e.getSource() == deleteButton) {
			if (i == 1) {
				if (board.shapes.size() < 1) {
					JOptionPane.showMessageDialog(null, "no shape to delete！");
					return;
				}
				// get the component before
				int my_index = board.shapes.indexOf(board.currentShape);
				Shape before = my_index > 0 ? board.shapes.get(my_index - 1) : null;
				if (!board.cancel_shapes.contains(board.currentShape)) {
					// delete record shape
					board.shapes.remove(board.currentShape);
					// record redo shape
					board.cancel_shapes.add(board.currentShape);
					// change currentshape
					board.currentShape = before;
				}
				board.repaint();
				i = 0;
			}

			// openImage(getGraphics());

		} else if (e.getSource() == copyButton) {

			board.cursor = 1;
		} else if (e.getSource() == testButton1) {

			board.path = "temp.jpg";
			board.repaint();

		} else if (e.getSource() == testButton2) {
			board.path = "test2.jpg";
			board.repaint();
		} else if (e.getSource() == testButton3) {
			board.path = "test1.jpg";
			board.repaint();
		}

	}

	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				AppFrame inst = new AppFrame();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}

}
