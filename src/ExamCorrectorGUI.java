import java.awt.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ExamCorrectorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private final JComboBox<Integer> comboBox = new JComboBox<Integer>();
	private JTextField curveCorrect;
	private JTextField curveTotal;
	// private JLabel output = new JLabel("");
	JCheckBox chckbxCurve;
	private int pointValue = 1;
	private boolean curve = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamCorrectorGUI frame = new ExamCorrectorGUI();
					// frame.setSize(new Dimension(600, 450));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExamCorrectorGUI() {
		setTitle("Chemistry Exam Scores Generator");
		setResizable(false);
		setForeground(Color.WHITE);
		// setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStudentsScore = new JLabel("Number Correct:");
		lblStudentsScore.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStudentsScore.setBounds(39, 66, 101, 27);
		contentPane.add(lblStudentsScore);

		textField = new JTextField();
		textField.setBounds(168, 69, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblTotalScore = new JLabel("Possible Correct:");
		lblTotalScore.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotalScore.setBounds(39, 107, 101, 14);
		contentPane.add(lblTotalScore);

		textField_1 = new JTextField();
		textField_1.setBounds(168, 104, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblCorrectCurve = new JLabel("Add Correct:");
		lblCorrectCurve.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCorrectCurve.setBounds(39, 230, 101, 14);
		// contentPane.add(lblCorrectCurve);

		curveCorrect = new JTextField();
		curveCorrect.setBounds(168, 230, 86, 20);
		// contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblTotalCurve = new JLabel("Add Total:");
		lblTotalCurve.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTotalCurve.setBounds(39, 260, 101, 14);
		// contentPane.add(lblCorrectCurve);

		curveTotal = new JTextField();
		curveTotal.setBounds(168, 260, 86, 20);
		// contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel(new ImageIcon(("chemistry.png")));
		lblNewLabel.setBounds(291, 62, 143, 110);
		contentPane.add(lblNewLabel);

		chckbxCurve = new JCheckBox("Curve Scores");
		chckbxCurve.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxCurve.setBounds(20, 174, 135, 23);
		contentPane.add(chckbxCurve);
		comboBox.setModel(new DefaultComboBoxModel(new Integer[] { 1, 2, 3, 4, 5 }));
		comboBox.setToolTipText("");
		comboBox.setBounds(200, 135, 54, 25);
		contentPane.add(comboBox);
		/* Number Listener */
		ActionListener comboBoxListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pointValue = (int) comboBox.getSelectedItem();

			}
		};

		/*
		 * ItemListener oneListener = new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) {
		 * comboBox.setSelectedIndex(1); } }; ItemListener twoListener = new
		 * ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) {
		 * comboBox.setSelectedIndex(2); } }; ItemListener threeListener = new
		 * ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) { pointValue = 3; } };
		 * ItemListener fourListener = new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) { pointValue = 4; } };
		 * ItemListener fiveListener = new ItemListener() {
		 * 
		 * @Override public void itemStateChanged(ItemEvent e) { pointValue = 5; } };
		 */
		comboBox.addActionListener(comboBoxListener);
		// comboBox.addItemListener(twoListener);
		// comboBox.addItemListener(threeListener);
		// comboBox.addItemListener(fourListener);
		// comboBox.addItemListener(fiveListener);

		JLabel lblNewLabel_1 = new JLabel("Exam Grade Calculator");
		lblNewLabel_1.setFont(new Font("Orange LET", Font.PLAIN, 28));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(61, 14, 323, 44);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Points Per Question:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(20, 140, 120, 14);
		contentPane.add(lblNewLabel_2);

		JLabel output = new JLabel("");
		output.setHorizontalAlignment(SwingConstants.LEADING);
		output.setBounds(94, 226, 25500, 84);
//		output.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(output);

		JToggleButton tglbtnSaveInDocument = new JToggleButton("Save In Document");
		tglbtnSaveInDocument.setBounds(291, 174, 143, 23);
		contentPane.add(tglbtnSaveInDocument);

		JButton btnCalculateScore = new JButton("Calculate Score");
		btnCalculateScore.setBounds(94, 226, 255, 34);
		contentPane.add(btnCalculateScore);

		btnCalculateScore.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					output.setText(calculate() + "% Correct                 " + (score(curve, pointValue)));
					// updateCalc();
//					System.out.println(calculate() + "% Correct");
//					System.out.println(score(curve, pointValue));
				} catch (NumberFormatException exc) {
					output.setText(("                    Please Enter Numbers"));
				}
			}
		});
		ActionListener curveListener = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (chckbxCurve.isSelected()) {
					setBounds(100, 100, 450, 390);
					btnCalculateScore.setBounds(94, 296, 255, 34);
					contentPane.add(lblCorrectCurve);
					contentPane.add(curveCorrect);
					contentPane.add(lblTotalCurve);
					contentPane.add(curveTotal);
					curve = true;
					output.setBounds(94, 296, 25500, 84);
				} else {
					setBounds(100, 100, 450, 320);
					btnCalculateScore.setBounds(94, 226, 255, 34);
					contentPane.remove(lblCorrectCurve);
					contentPane.remove(curveCorrect);
					contentPane.remove(lblTotalCurve);
					contentPane.remove(curveTotal);
					curve = false;
					output.setBounds(94, 226, 25500, 84);
				}
			}
		};
		chckbxCurve.addActionListener(curveListener);
	}

	private double calculate() {
		double curveC = 0;
		double curveT = 0;
		if (chckbxCurve.isSelected()) {
			curveC = Double.parseDouble(curveCorrect.getText());
			curveT = Double.parseDouble(curveTotal.getText());
		}
		DecimalFormat numberFormat = new DecimalFormat("#.0");
		double correctsP = Double.parseDouble(textField.getText()) * (int) comboBox.getSelectedItem() + curveC;
		double totalP = Double.parseDouble(textField_1.getText()) * (int) comboBox.getSelectedItem() + curveT;
		double percent = correctsP / totalP * 100;
		return Double.parseDouble(numberFormat.format(percent));
	}

	private String score(boolean curve, int pointValue) {
		double corrects = Double.parseDouble(textField.getText());
		double total = Double.parseDouble(textField_1.getText());
		if (curve) {
			double curveC = Double.parseDouble(curveCorrect.getText());
			double curveT = Double.parseDouble(curveTotal.getText());
			return "Score: " + (corrects * pointValue + curveC) + " out of " + (total * pointValue + curveT);
		} else {
			return "Score: " + corrects * pointValue + " out of " + total * pointValue;
		}

	}
}
