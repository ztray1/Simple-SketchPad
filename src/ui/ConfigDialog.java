package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * settings
 */
public class ConfigDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	// mainpage
	private JPanel content;
	// label
	private JLabel backLabel;
	private JLabel ovalLabel;
	private JLabel triaLabel;
	private JLabel lineLabel;
	private JLabel squareLabel;
	private JLabel circleLabel;
	// private JLabel textLabel;
	// button
	private JButton backColor;
	private JButton ovalColor;
	private JButton triaColor;
	private JButton lineColor;
	private JButton squareColor;
	private JButton circleColor;
	// private JButton textColor;
	// combox
	private JComboBox ovalSize;
	private JComboBox triaSize;
	private JComboBox lineSize;
	private JComboBox squareSize;
	private JComboBox circleSize;
	/*
	 * private JComboBox textFace; private JComboBox textStyle; private
	 * JComboBox textSize;
	 */
	// button
	private JButton okButton;
	private JButton quitButton;

	private DrawingBoard board;

	/** 画笔大小集合 */
	private final String STROKES[] = new String[] { "10.0px", "8.0px", "6.5px", "4.0px", "2.5px", "2.0px" };
	/** 文字字体集合 */
	private final String FACES[] = new String[] { "楷体", "隶书", "宋体", "华文彩云", "华文行楷", "微软雅黑" };
	/** 文字样式集合 */
	private final String STYLE[] = new String[] { "常规", "粗体", "斜体" };
	/** 文字大小集合 */
	private final String SIZES[] = new String[] { "20", "22", "24", "26", "28", "30", "32", "34", "36", "38", "40",
			"42", "44", "46", "48", "50" };

	// 全局字体
	private static final Font font = new Font("微软雅黑", Font.PLAIN, 12);

	public ConfigDialog(DrawingBoard board) {
		this.board = board;
		initGUI();
	}

	private void initGUI() {
		setModal(true);
		setSize(480, 800);
		setTitle("setting");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		content = new JPanel();
		content.setLayout(null);
		getContentPane().add(content);

		backLabel = new JLabel("background：");
		backLabel.setBounds(10, 10, 50, 25);
		backLabel.setFont(font);
		content.add(backLabel);

		backColor = new JButton();
		backColor.setBounds(85, 10, 80, 25);
		backColor.setBackground(board.getBackground());
		backColor.setPreferredSize(new Dimension(50, 25));
		backColor.addActionListener(this);
		content.add(backColor);

		ovalLabel = new JLabel("circle：");
		ovalLabel.setBounds(10, 55, 55, 25);
		ovalLabel.setFont(font);
		content.add(ovalLabel);

		ovalColor = new JButton();
		ovalColor.setBackground(board.oval_color);
		ovalColor.setBounds(85, 55, 80, 25);
		ovalColor.setPreferredSize(new Dimension(50, 25));
		ovalColor.addActionListener(this);
		content.add(ovalColor);

		ovalSize = new JComboBox();
		ovalSize.setBounds(190, 55, 80, 25);
		ovalSize.setFont(font);
		ovalSize.setModel(new DefaultComboBoxModel(STROKES));
		ovalSize.setSelectedItem(transToString(board.oval_stroke));
		ovalSize.addActionListener(this);
		content.add(ovalSize);

		triaLabel = new JLabel("traniangle：");
		triaLabel.setBounds(10, 100, 55, 25);
		triaLabel.setFont(font);
		content.add(triaLabel);

		triaColor = new JButton();
		triaColor.setBackground(board.tria_color);
		triaColor.setBounds(85, 100, 80, 25);
		triaColor.setPreferredSize(new Dimension(50, 25));
		triaColor.addActionListener(this);
		content.add(triaColor);

		triaSize = new JComboBox();
		triaSize.setBounds(190, 100, 80, 25);
		triaSize.setFont(font);
		triaSize.setModel(new DefaultComboBoxModel(STROKES));
		triaSize.setSelectedItem(transToString(board.tria_stroke));
		triaSize.addActionListener(this);
		content.add(triaSize);

		lineLabel = new JLabel("line：");
		lineLabel.setBounds(10, 145, 55, 25);
		lineLabel.setFont(font);
		content.add(lineLabel);

		lineColor = new JButton();
		lineColor.setBounds(85, 145, 80, 25);
		lineColor.setBackground(board.line_color);
		lineColor.setPreferredSize(new Dimension(50, 25));
		lineColor.addActionListener(this);
		content.add(lineColor);

		lineSize = new JComboBox();
		lineSize.setBounds(190, 145, 80, 25);
		lineSize.setFont(font);
		lineSize.setModel(new DefaultComboBoxModel(STROKES));
		lineSize.setSelectedItem(transToString(board.line_stroke));
		lineSize.addActionListener(this);
		content.add(lineSize);

		squareLabel = new JLabel("square：");
		squareLabel.setBounds(10, 190, 55, 25);
		squareLabel.setFont(font);
		content.add(squareLabel);

		squareColor = new JButton();
		squareColor.setBounds(85, 190, 80, 25);
		squareColor.setBackground(board.line_color);
		squareColor.setPreferredSize(new Dimension(50, 25));
		squareColor.addActionListener(this);
		content.add(squareColor);

		squareSize = new JComboBox();
		squareSize.setBounds(190, 190, 80, 25);
		squareSize.setFont(font);
		squareSize.setModel(new DefaultComboBoxModel(STROKES));
		squareSize.setSelectedItem(transToString(board.square_stroke));
		squareSize.addActionListener(this);
		content.add(squareSize);

		circleLabel = new JLabel("oval：");
		circleLabel.setBounds(10, 235, 55, 25);
		circleLabel.setFont(font);
		content.add(circleLabel);

		circleColor = new JButton();
		circleColor.setBounds(85, 235, 80, 25);
		circleColor.setBackground(board.oval_color);
		circleColor.setPreferredSize(new Dimension(50, 25));
		circleColor.addActionListener(this);
		content.add(circleColor);

		circleSize = new JComboBox();
		circleSize.setBounds(190, 235, 80, 25);
		circleSize.setFont(font);
		circleSize.setModel(new DefaultComboBoxModel(STROKES));
		circleSize.setSelectedItem(transToString(board.oval_stroke));
		circleSize.addActionListener(this);
		content.add(circleSize);

		/*
		 * textLabel = new JLabel("文   字："); textLabel.setBounds(10, 190, 55,
		 * 25); textLabel.setFont(font); content.add(textLabel);
		 * 
		 * textColor = new JButton(); textColor.setBounds(85, 190, 80, 25);
		 * textColor.setBackground(board.text_color);
		 * textColor.setPreferredSize(new Dimension(50, 25));
		 * textColor.addActionListener(this); content.add(textColor);
		 */

		/*
		 * textFace = new JComboBox(); textFace.setBounds(190, 190, 80, 25);
		 * textFace.setFont(font); textFace.setModel(new
		 * DefaultComboBoxModel(FACES));
		 * textFace.setSelectedItem(board.text_face);
		 * textFace.addActionListener(this); content.add(textFace);
		 * 
		 * textStyle = new JComboBox(); textStyle.setBounds(290, 190, 80, 25);
		 * textStyle.setFont(font); textStyle.setModel(new
		 * DefaultComboBoxModel(STYLE));
		 * textStyle.setSelectedItem(getStyleStr(board.text_style));
		 * textStyle.addActionListener(this); content.add(textStyle);
		 * 
		 * textSize = new JComboBox(); textSize.setBounds(390, 190, 80, 25);
		 * textSize.setFont(font); textSize.setModel(new
		 * DefaultComboBoxModel(SIZES));
		 * textSize.setSelectedItem(String.valueOf(board.text_size));
		 * textSize.addActionListener(this); content.add(textSize);
		 */

		okButton = new JButton("ok");
		okButton.setBounds(85, 585, 80, 30);
		okButton.setFont(font);
		okButton.addActionListener(this);
		content.add(okButton);

		quitButton = new JButton("cancel");
		quitButton.setBounds(290, 585, 80, 30);
		quitButton.setFont(font);
		quitButton.addActionListener(this);
		content.add(quitButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backColor) {
			Color color = JColorChooser.showDialog(this, "color of bacground", board.getBackground());
			backColor.setBackground(color);
		}
		if (e.getSource() == ovalColor) {
			Color color = JColorChooser.showDialog(this, "choose color", board.oval_color);
			ovalColor.setBackground(color);
		}
		if (e.getSource() == triaColor) {
			Color color = JColorChooser.showDialog(this, "choose color", board.tria_color);
			triaColor.setBackground(color);
		}
		if (e.getSource() == lineColor) {
			Color color = JColorChooser.showDialog(this, "choose color", board.line_color);
			lineColor.setBackground(color);
		}
		if (e.getSource() == squareColor) {
			Color color = JColorChooser.showDialog(this, "choose color", board.square_color);
			squareColor.setBackground(color);
		}
		if (e.getSource() == circleColor) {
			Color color = JColorChooser.showDialog(this, "choose color", board.circle_color);
			circleColor.setBackground(color);
		}
		/*
		 * if (e.getSource() == textColor) { Color color =
		 * JColorChooser.showDialog(this, "选择画笔颜色", board.text_color);
		 * textColor.setBackground(color); }
		 */
		if (e.getSource() == okButton) {
			// color
			board.setBackground(backColor.getBackground());
			board.oval_color = ovalColor.getBackground();
			board.tria_color = triaColor.getBackground();
			board.line_color = lineColor.getBackground();
			board.square_color = squareColor.getBackground();
			board.circle_color = circleColor.getBackground();
			/* board.text_color = textColor.getBackground(); */
			// size
			board.oval_stroke = transToFloat(ovalSize);
			board.tria_stroke = transToFloat(triaSize);
			board.line_stroke = transToFloat(lineSize);
			board.square_stroke = transToFloat(squareSize);
			board.circle_stroke = transToFloat(circleSize);
			// text特殊处理
			/*
			 * board.text_face = String.valueOf(textFace.getSelectedItem()); if
			 * (String.valueOf(textStyle.getSelectedItem()).equals("常规")) {
			 * board.text_style = Font.PLAIN; } if
			 * (String.valueOf(textStyle.getSelectedItem()).equals("粗体")) {
			 * board.text_style = Font.BOLD; } if
			 * (String.valueOf(textStyle.getSelectedItem()).equals("斜体")) {
			 * board.text_style = Font.ITALIC; } board.text_size =
			 * Integer.valueOf(String.valueOf(textSize.getSelectedItem())); //
			 * close
			 */
			dispose();
		}
		if (e.getSource() == quitButton) {
			dispose();
		}
	}

	/**
	 * change float to string type
	 * 
	 * @param value
	 * @return
	 */
	private String transToString(float value) {
		String temp = String.valueOf(value);
		return temp + "px";
	}

	/**
	 * 
	 * change string to float
	 * 
	 * @return
	 */
	private float transToFloat(Object object) {
		String temp = ((JComboBox) object).getSelectedItem().toString();
		return Float.parseFloat(temp.substring(0, temp.length() - 2));
	}

}
