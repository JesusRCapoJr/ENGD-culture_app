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
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class AddTaskWindowTest extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterTaskName;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextArea taskAreaDescription;
	private Task task;
	private boolean inFolder;
	private DesplayState2 desplayState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					//COMMENTED OUT BY JESUS
					//KieyaAddTaskTestWindow frame = new KieyaAddTaskTestWindow(this.task); 
					//frame.setVisible(true); -----------------------------------------------------
					//COMMENTED OUT BY JESUS
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public AddTaskWindowTest(Task task, boolean inFolder, DesplayState2 desplayState) {
		this.task = task;
		this.desplayState=desplayState;
		this.inFolder =inFolder;
		this.runAddTaskWindow();
	}
	
	public AddTaskWindowTest(Task task, boolean inFolder) {
		this.task = task;
		this.inFolder =inFolder;
		this.runAddTaskWindow();
	}
	
	public void runAddTaskWindow() {
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(17, 180, 750, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Main.getChosenTheme().get(7));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLocationRelativeTo(null);
		setContentPane(contentPane);

		txtEnterTaskName = new JTextField();
		txtEnterTaskName.setHorizontalAlignment(SwingConstants.LEFT);
		txtEnterTaskName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtEnterTaskName.setBackground(Color.LIGHT_GRAY);
		txtEnterTaskName.setForeground(new Color(0, 0, 0));
		txtEnterTaskName.setText(this.task.getTitle());
		txtEnterTaskName.setColumns(10);

		
		String[] folderNames = new String[Main.getAllFolders().size()];
		
		//testing to see if I can access folders
		//System.out.print(Main.getAllFolders().size());
		
		int i = 0;
		
		for (Folder currentFolder : Main.getAllFolders()) {
			folderNames[i] = currentFolder.getTitle();
			System.out.print(currentFolder.getTitle());
			i++;

		}

		JLabel lblNewLabel = new JLabel("Description:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		//Need to bring in stored folders
		comboBox = new JComboBox();
		comboBox.setToolTipText("Select designation folder");
		comboBox.setModel(new DefaultComboBoxModel(folderNames));
		;
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Folder",Main.getAllFolders().get(0).getTitle(),Main.getAllFolders().get(1).getTitle(),Main.getAllFolders().get(2).getTitle(),Main.getAllFolders().get(3).getTitle()}));;
		
		//Need to sbring in stored folders
		comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("Select label");
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { this.task.getLabels() }));

		comboBox_2 = new JComboBox();
		comboBox_2.setToolTipText("Select priority");
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {this.task.getPriorityString(), "Low", "Medium", "High" }));

		

		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		textArea.setLineWrap(true);
		textArea.setText(this.task.getDescription());
		this.taskAreaDescription = textArea;
		
		JButton btnNewButton = new JButton("Done!");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setTaskInformation();
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JCheckBox chckbxNewCheckBox = new JCheckBox("Task Completed");
		chckbxNewCheckBox.setBackground(Main.getChosenTheme().get(8)); //new Color(102, 153, 0)
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Due Date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("YYYY/MM/d");
		
		JLabel lblNewLabel_2 = new JLabel("Time:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JSpinField spinField = new JSpinField();
		spinField.setMaximum(23);
		spinField.setMinimum(00);
		JSpinField spinField_1 = new JSpinField();
		spinField_1.setMaximum(59);
		spinField_1.setMinimum(00);
		
		JLabel lblNewLabel_3 = new JLabel(":");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(chckbxNewCheckBox)
									.addGap(18)
									.addComponent(txtEnterTaskName, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(spinField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(spinField_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)))
					.addGap(17))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(chckbxNewCheckBox)
								.addComponent(txtEnterTaskName, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBox, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
		);
		contentPane.setLayout(gl_contentPane);
	}

	
//	private void checkTaskCompletion() {
//		if(chckbxNewCheckBox.isEnabled()== true) {
//			
//		}
//	}

	private void setTaskInformation() {
		// TODO Auto-generated method stub
		
		Label currentLabel = new Label(comboBox_1.getSelectedItem().toString());

		// how do I access the folderlistfrom the saver, they should have an id right);
		
		// Main.addTaskToFolder(task,//folder  )
		
		if (Main.registerLabel(currentLabel) == false ) {
			Main.addLabelToTask(currentLabel, task);
		}
		
		//Main.addTaskToFolder(task, folder);
		
		task.setDescription(taskAreaDescription.getText());
		task.setDueDate("test");
		task.setLabel(comboBox_1.getSelectedItem().toString());
		task.setTitle(txtEnterTaskName.getText());
		task.setPriority(comboBox_2.getSelectedItem().toString());
		
		
		Integer folderIndex = comboBox.getSelectedIndex();
		
		//If the folder does not already have the task then add it to the folder
		if (!Main.getAllFolders().get(folderIndex-1).getTasks().contains(this.task)) {
			Main.getAllFolders().get(folderIndex-1).addTask(this.task);
		}
		
		//If the task does not exist in the tasks arraylist then add to the tasks arraylist
		if (!Main.getAllTasks().contains(this.task)) {
			Main.getAllTasks().add(task);
		}
		
		//Remove task from folder if the old folder has changed
		if (this.task.getFolder()!=null){
			if (this.task.getFolder().getID()!=folderIndex) {
				System.out.println(folderIndex);
				this.task.getFolder().removeTask(this.task);
			}
		}
		
		task.setFolder(Main.getAllFolders().get(folderIndex-1));
	
		this.setVisible(false);
		
		if (this.inFolder) {
			this.desplayState.runNewFolder();
		}
		
	}
}
