import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KieyaAddTaskTestWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterTaskName;
	private JComboBox comboBox_2;
	private JTextField txtAddDueDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KieyaAddTaskTestWindow frame = new KieyaAddTaskTestWindow();
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
	public KieyaAddTaskTestWindow() {
		setResizable(false);
		setBounds(17, 180, 831, 573);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtEnterTaskName = new JTextField();
		txtEnterTaskName.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterTaskName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterTaskName.setBackground(Color.WHITE);
		txtEnterTaskName.setForeground(Color.BLACK);
		txtEnterTaskName.setText("Enter Task Name");
		txtEnterTaskName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Description:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Select designation folder");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Folder"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Select label");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Label"}));
		
		comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Select priority");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Priority", "Low", "Medium", "High"}));
		
		txtAddDueDate = new JTextField();
		txtAddDueDate.setText("Add Due Date");
		txtAddDueDate.setColumns(10);
		
		JButton btnNewButton = new JButton("Done!");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		textArea.setLineWrap(true);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Task Completed");
		chckbxNewCheckBox.setBackground(Color.LIGHT_GRAY);
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SpringLayout sl_contentPane = new SpringLayout();
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 1, SpringLayout.NORTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 582, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -159, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, textArea);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_2, 0, SpringLayout.EAST, txtEnterTaskName);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_2, 12, SpringLayout.EAST, comboBox_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtEnterTaskName, 8, SpringLayout.EAST, chckbxNewCheckBox);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtEnterTaskName, -20, SpringLayout.WEST, txtAddDueDate);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtAddDueDate, 23, SpringLayout.NORTH, chckbxNewCheckBox);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtAddDueDate, 524, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtAddDueDate, 0, SpringLayout.EAST, textArea);
		sl_contentPane.putConstraint(SpringLayout.NORTH, chckbxNewCheckBox, 22, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, chckbxNewCheckBox, -31, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, textArea, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, textArea, -36, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtEnterTaskName, 18, SpringLayout.NORTH, chckbxNewCheckBox);
		sl_contentPane.putConstraint(SpringLayout.WEST, chckbxNewCheckBox, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, chckbxNewCheckBox, -520, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_2, 0, SpringLayout.NORTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_2, 0, SpringLayout.SOUTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox_1, 1, SpringLayout.NORTH, comboBox);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox_1, 6, SpringLayout.EAST, comboBox);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox_1, 381, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox_1, 286, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 113, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, 300, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, comboBox, 355, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, comboBox, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, comboBox, 382, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, comboBox, 156, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, textArea, 143, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textArea, 336, SpringLayout.NORTH, contentPane);
		contentPane.setLayout(sl_contentPane);
		contentPane.add(textArea);
		contentPane.add(comboBox);
		contentPane.add(comboBox_1);
		contentPane.add(chckbxNewCheckBox);
		contentPane.add(txtEnterTaskName);
		contentPane.add(comboBox_2);
		contentPane.add(btnNewButton);
		contentPane.add(txtAddDueDate);
		contentPane.add(lblNewLabel);
	}
}


