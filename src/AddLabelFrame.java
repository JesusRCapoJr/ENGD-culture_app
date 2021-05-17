import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class AddLabelFrame extends JFrame{

	private Label label; 
	private Folder folder; 
	
	private JFrame frame; 
	private JLabel labelName; 
	private JTextField textField; 
	private JButton doneBtn; 
	private JComboBox selectFolders; 
	
	public AddLabelFrame() {
		this.label = new Label(""); 
		this.folder = new Folder("words", -1); 
		initiate(); 
	}
	
	public AddLabelFrame(Label label, Folder folder) {
		this.folder = folder; 
		this.label = label; 
		initiate(); 
	}

	//Code inspired by Kieya's code
	@SuppressWarnings("unchecked")
	public void initiate() {
		frame = new JFrame(); 
	  	frame.setBounds(Main.getWidth()/2, Main.getHeight()/2, 280, 130);
	  	frame.setBackground(Main.getChosenTheme().get(7));
	  	frame.setLayout(null);
	  	
	  	labelName = new JLabel();
		labelName.setText("Label name: ");
		labelName.setBounds(10, 10, 160, 20);
		frame.getContentPane().add(labelName);
		labelName.setBackground(new Color(0,0,0,0));
		
	  	textField = new JTextField();
		textField.setBounds(10, 32, 160, 20);
		frame.getContentPane().add(textField);
		textField.setText(this.label.getText());
		textField.setColumns(1);
		
		doneBtn = new JButton("Done");
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
			selectFolders.setToolTipText("Select designation folder");
			selectFolders.setBounds(10, 54, 160, 21);
			selectFolders.setModel(new DefaultComboBoxModel(
					new String[] {"Select Folder",
							Main.getAllFolders().get(0).getTitle(),
							Main.getAllFolders().get(1).getTitle(),
							Main.getAllFolders().get(2).getTitle(),
							Main.getAllFolders().get(3).getTitle()}
					)
				);
			selectFolders.setSelectedIndex(folder.getID()+1);
		frame.getContentPane().add(selectFolders); 
		
		frame.setVisible(true); 
	}
	
	public void setupLabel() {
		String selected = selectFolders.getSelectedItem().toString(); 
		this.label.setText(textField.getText());
		if(Main.registerLabel(label)) {
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
	
	public void f5() {
		this.setVisible(false);
		this.setVisible(true);
	}
}
