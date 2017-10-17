package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * attribute of board
 */
public class AttributeDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	/** mainpage */
	private JPanel content;
	// color
	/** color panel */
	private JPanel colorPanel;
	/** background */
	private JButton fgButton;
	// 大小
	/** size of shape */
	private JPanel sizePanel;
	/** setting panel */
	private JPanel utilPanel;
	/** font */
	private JComboBox faceCombox;
	/** text */
	private JComboBox styleCombox;
	/** text size */
	private JComboBox sizeCombox;
	/** position */
	private Position position;
	/** object board */
	private DrawingBoard board;

	private JButton deleteButton;

	private JButton copyButton;

	/*
	 * private final Font font = new Font("Dialog", 0, 12); /** 画笔大小集合
	 */
	/*
	 * private final String STROKES[] = new String[] { "10.0px", "8.0px",
	 * "6.5px", "4.0px", "2.5px", "2.0px" }; /** 文字字体集合
	 */
	/*
	 * private final String FACES[] = new String[] { "楷体", "隶书", "宋体", "华文彩云",
	 * "华文行楷", "微软雅黑" }; /** 文字样式集合
	 */
	/*
	 * private final String STYLE[] = new String[] { "常规", "粗体", "斜体" }; /**
	 * 文字大小集合
	 */
	/*
	 * private final String SIZES[] = new String[] { "20", "22", "24", "26",
	 * "28", "30", "32", "34", "36", "38", "40", "42", "44", "46", "48", "50" };
	 */

	public AttributeDialog(DrawingBoard board) {
		this.board = board;
		initGUI();
	}

	private void initGUI() {
		setModal(true);
		setTitle("delete current diagram");
		setLayout(new GridBagLayout());

		content = new JPanel();
		content.setLayout(new BoxLayout(content, 1));
		//
		GridBagConstraints gridbagconstraints = new GridBagConstraints();
		gridbagconstraints.anchor = 11;
		gridbagconstraints.weightx = 1.0D;
		gridbagconstraints.insets = new Insets(10, 5, 5, 5);
		getContentPane().add(content, gridbagconstraints);

		colorPanel = new JPanel();
		fgButton = new JButton();
		sizePanel = new JPanel();
		utilPanel = new JPanel();
		faceCombox = new JComboBox();
		styleCombox = new JComboBox();
		sizeCombox = new JComboBox();
		deleteButton = new JButton();
		copyButton = new JButton();

		// Color Panel
		colorPanel.setLayout(new FlowLayout(1, 20, 10));
		colorPanel.setBorder(new TitledBorder("color"));
		content.add(colorPanel);

		fgButton.setBackground(board.currentShape.color);
		fgButton.setToolTipText("change color of current shape");
		fgButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		fgButton.setPreferredSize(new Dimension(100, 50));
		fgButton.addActionListener(this);
		colorPanel.add(fgButton);
		deleteButton.setText("delete");
		colorPanel.add(deleteButton);
		deleteButton.addActionListener(this);

		copyButton.setText("copy");
		colorPanel.add(copyButton);
		copyButton.addActionListener(this);

		// Size Panel
		// 区分文字和其他图形
		/*
		 * if (!"text".equals(board.currentShape.getType())) {
		 * sizePanel.setBorder(new TitledBorder("大小"));
		 * sizeCombox.setFont(font); sizeCombox.setPreferredSize(new
		 * Dimension(100, 25)); sizeCombox.setModel(new
		 * DefaultComboBoxModel(STROKES));
		 * sizeCombox.setSelectedItem(String.valueOf(board.currentShape.stroke)
		 * + "px"); sizeCombox.addActionListener(this);
		 * 
		 * utilPanel.setLayout(new BorderLayout(0, 3));
		 * utilPanel.add(sizeCombox, "North"); sizePanel.add(utilPanel);
		 * content.add(sizePanel); } else { sizePanel.setBorder(new
		 * TitledBorder("样式"));
		 * 
		 * faceCombox.setFont(font); faceCombox.setPreferredSize(new
		 * Dimension(120, 25)); faceCombox.setModel(new
		 * DefaultComboBoxModel(FACES)); faceCombox.setSelectedItem(((Text)
		 * board.currentShape).getTextFace());
		 * faceCombox.addActionListener(this);
		 * 
		 * styleCombox.setFont(font); styleCombox.setPreferredSize(new
		 * Dimension(120, 25)); styleCombox.setModel(new
		 * DefaultComboBoxModel(STYLE));
		 * styleCombox.setSelectedItem(String.valueOf(((Text)
		 * board.currentShape).getTextStyle()));
		 * styleCombox.addActionListener(this);
		 * 
		 * sizeCombox.setFont(font); sizeCombox.setPreferredSize(new
		 * Dimension(120, 25)); sizeCombox.setModel(new
		 * DefaultComboBoxModel(SIZES));
		 * sizeCombox.setSelectedItem(String.valueOf(((Text)
		 * board.currentShape).getTextSize()));
		 * sizeCombox.addActionListener(this);
		 * 
		 * utilPanel.setLayout(new BorderLayout(0, 3));
		 * utilPanel.add(faceCombox, "North"); utilPanel.add(styleCombox,
		 * "Center"); utilPanel.add(sizeCombox, "South");
		 * sizePanel.add(utilPanel); content.add(sizePanel); }
		 * 
		 * // Position & Diameter Panel if
		 * (!"line".equals(board.currentShape.getType())) { position = new
		 * Position(board); position.setBorder(new TitledBorder("坐标 & 比例"));
		 * content.add(position); }
		 */

		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == fgButton) {
			Color color = JColorChooser.showDialog(this, "choose color", board.getForeground());
			if (color != null) {

				fgButton.setBackground(color);
				board.setCurrentColor(color);

			}
		}
		if (e.getSource() == deleteButton) {

			board.setCurrentColor(new Color(255, 255, 255));

		}
		if (e.getSource() == copyButton) {

		}
		/*
		 * if (e.getSource() == faceCombox) {
		 * board.setCurrentTxtFontFace(faceCombox.getSelectedItem().toString());
		 * } if (e.getSource() == styleCombox) {
		 * board.setCurrentTxtFontStyle(styleCombox.getSelectedItem().toString()
		 * ); } if (!"text".equals(board.currentShape.getType())) { if
		 * (e.getSource() == sizeCombox) { String temp =
		 * sizeCombox.getSelectedItem().toString();
		 * board.setStrokeSize(Float.parseFloat(temp.substring(0, temp.length()
		 * - 2)), board.currentShape.getType()); } } else { if (e.getSource() ==
		 * sizeCombox) {
		 * board.setCurrentTxtFontSize(sizeCombox.getSelectedItem().toString());
		 * } }
		 */
	}

}
