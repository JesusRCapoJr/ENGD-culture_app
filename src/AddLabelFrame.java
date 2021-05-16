import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class AddLabelFrame extends JFrame{

	private Label label; 
	
	public AddLabelFrame() {
		this.label = new Label("lemon"); 
		initiate(); 
	}
	
	public AddLabelFrame(Label label) {
		this.label = label; 
		initiate(); 
	}

	public void initiate() {
		JFrame frame = new JFrame(); 
	  	frame.setBounds(Main.getWidth()/2, Main.getHeight()/2, 280, 130);
	  	frame.setBackground(Main.getChosenTheme().get(7));
	  	frame.setLayout(null);
	  	
	  	JTextPane txtpnLabelName = new JTextPane();
		txtpnLabelName.setText("Label name: ");
		txtpnLabelName.setBounds(10, 10, 160, 20);
		frame.getContentPane().add(txtpnLabelName);
		txtpnLabelName.setBackground(new Color(0,0,0,0));
	  	
	  	JTextField textField = new JTextField();
		textField.setBounds(10, 32, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(1);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.setBounds(180, 10, frame.getHeight()-50, frame.getHeight()-50);
		frame.getContentPane().add(btnNewButton);
	  	
	  	JComboBox comboBox = new JComboBox();
			comboBox.setToolTipText("Select designation folder");
			comboBox.setBounds(10, 54, 160, 21);
			comboBox.setModel(new DefaultComboBoxModel(
					new String[] {"Select Folder",Main.getAllFolders().get(0).getTitle(),
							Main.getAllFolders().get(1).getTitle(),
							Main.getAllFolders().get(2).getTitle(),
							Main.getAllFolders().get(3).getTitle()}
					)
				);
			frame.getContentPane().add(comboBox); 
			
			frame.setVisible(true);
			
			//ActionListenter and all fun stuff
	}
}
