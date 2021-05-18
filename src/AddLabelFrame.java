import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Author: Steven Xia

public class AddLabelFrame extends JFrame{

	private Label label; 
	private Folder folder; 
	
	private JFrame frame; 
	private JLabel labelName; 
	private JTextField textField; 
	private JButton doneBtn; 
	private JComboBox selectFolders; 
	
	/**
	 * Initializes an empty AddLabelFrame. Primarily used for creating a Label. 
	 * Constructors will initialize this.label and this.folder never-the-less. 
	 * They will be initiated as new Objects if not passed in, so Main.registerLabel() can handle that. 
	 */
	public AddLabelFrame() {
		this.label = new Label("word"); 
		this.folder = new Folder("words", 0); 
		initiate(); 
	}
	
	/**
	 * Initializes an AddLabelFrame with specified Folder. Primarily used for creating a Label in a Folder. 
	 * @param folder
	 */
	public AddLabelFrame(Folder folder) {
		if(folder != null) {
			this.folder = folder; 
		}else {
			this.folder = new Folder("words", 0); 
		}
		this.label = new Label("word"); 
		initiate(); 
	}
	
	/**
	 * Initializes an AddLabelFrame with specified Folder and Label. Primarily used to edit a Label. 
	 * @param label
	 * @param folder
	 */
	public AddLabelFrame(Label label, Folder folder) {
		if(label != null) {
			this.label = label; 
		}else {
			this.label = new Label("word"); 
		}
		if(folder != null) {
			this.folder = folder; 
		}else {
			this.folder = new Folder("words", 0); 
		}
		
		initiate(); 
	}

	//Code inspired by Kieya's KieyaAddTaskTestWindow class
	@SuppressWarnings("unchecked")
	public void initiate() {
		//window
		frame = new JFrame(); 
	  	frame.setBounds(Main.getWidth()/2, Main.getHeight()/2, 280, 130);
	  	frame.setBackground(Main.getChosenTheme().get(7));
	  	frame.setLayout(null);
	  	
	  	//Just a String
	  	labelName = new JLabel();
		labelName.setText(Main.getLanguage().get("Label name: ")); 
		labelName.setBounds(10, 10, 160, 20);
		frame.getContentPane().add(labelName);
		labelName.setBackground(new Color(0,0,0,0));
		
		//Where people fills in the name of Label. Will automatically initialize as the Label's text if exists. 
	  	textField = new JTextField();
		textField.setBounds(10, 32, 160, 20);
		frame.getContentPane().add(textField);
		//System.out.println("label"+this.label.getText()); 
		textField.setText(this.label.getText());
		textField.setColumns(1);
		
		//Button for Done. Upon click, it will mutate or create the Label. 
		doneBtn = new JButton(Main.getLanguage().get("Done"));
		doneBtn.setBounds(180, 10, frame.getHeight()-50, frame.getHeight()-50);
		frame.getContentPane().add(doneBtn);
		doneBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setupLabel(); 
				frame.setVisible(false);
				f5();
			}
			
		});
	  	
	  	selectFolders = new JComboBox();
			selectFolders.setToolTipText(Main.getLanguage().get("Select designation folder"));
			selectFolders.setBounds(10, 54, 160, 21);
			selectFolders.setModel(new DefaultComboBoxModel(
					new String[] {"Select Folder",
							Main.getAllFolders().get(0).getTitle(),
							Main.getAllFolders().get(1).getTitle(),
							Main.getAllFolders().get(2).getTitle(),
							Main.getAllFolders().get(3).getTitle()}
					)
				);
			selectFolders.setSelectedIndex(folder.getID());
		frame.getContentPane().add(selectFolders); 
		
		frame.setVisible(true); 
	}
	
	public void setupLabel() {
		//Mutate label. 
		String selected = selectFolders.getSelectedItem().toString(); 
		this.label.setText(textField.getText());
		//Try to register label in Main. If success (label did not exist), add it in the correct Folder. If not, leave as it is mutated already. 
		if(!Main.registerLabel(label)) {
			if(selected.equals(Main.getAllFolders().get(0).getTitle())) {
				Main.getAllFolders().get(0).addLabel(label);
			}else if(selected.equals(Main.getAllFolders().get(1).getTitle())) {
				Main.getAllFolders().get(1).addLabel(label);
			}else if(selected.equals(Main.getAllFolders().get(2).getTitle())) {
				Main.getAllFolders().get(2).addLabel(label);
			}else if(selected.equals(Main.getAllFolders().get(3).getTitle())) {
				Main.getAllFolders().get(3).addLabel(label);
			}else {
				System.out.println("What???");
			}
		}
		
	}
	
	/**
	 * Exactly what a F5 button does... or at least I tried. Did not end up using, may show up in the future. 
	 */
	public void f5() {
		this.repaint();
	}
}
