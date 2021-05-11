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
import javax.swing.DropMode;

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
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(17, 180, 741, 438);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtEnterTaskName = new JTextField();
		txtEnterTaskName.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterTaskName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterTaskName.setBackground(Color.LIGHT_GRAY);
		txtEnterTaskName.setForeground(new Color(0, 0, 0));
		txtEnterTaskName.setText("Enter Task Name");
		txtEnterTaskName.setColumns(10);

		String[] folderNames = new String[Main.getAllFolers().size()];

		int i = 0;
		for (Folder currentFolder : Main.getAllFolers()) {
			folderNames[i] = currentFolder.getTitle();
			i++;

		}

		JLabel lblNewLabel = new JLabel("Description:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("Select designation folder");
		comboBox.setModel(new DefaultComboBoxModel(folderNames));
		;
		// comboBox.setModel(new DefaultComboBoxModel(new String[] {"Folder"}));;

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Select label");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Label" }));

		comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Select priority");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Priority", "Low", "Medium", "High" }));

		txtAddDueDate = new JTextField();
		txtAddDueDate.setBackground(Color.LIGHT_GRAY);
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
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		textArea.setLineWrap(true);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Task Completed");
		chckbxNewCheckBox.setBackground(new Color(102, 153, 0));
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setBackground(new Color(51, 102, 51));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addGap(17).addComponent(textArea))
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addGap(27)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(chckbxNewCheckBox_1))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup().addGap(15)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addGap(121).addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 128,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING,
								gl_contentPane.createSequentialGroup().addGap(15)
										.addComponent(chckbxNewCheckBox, GroupLayout.PREFERRED_SIZE, 160,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(txtEnterTaskName, GroupLayout.PREFERRED_SIZE, 395,
												GroupLayout.PREFERRED_SIZE)
										.addGap(38).addComponent(txtAddDueDate, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(48, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(38)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(14).addComponent(chckbxNewCheckBox))
						.addComponent(txtEnterTaskName, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(7).addComponent(txtAddDueDate,
								GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)))
				.addGap(21)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(2).addComponent(chckbxNewCheckBox_1)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE).addGap(44)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(comboBox_2,
								GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(btnNewButton,
								GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))));
		contentPane.setLayout(gl_contentPane);
	}
}
