	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JPanel;
	import javax.swing.JOptionPane;

	public class AddLabelButton extends Button {
		private JPanel world;
		public static final double ADD_TASK_PANEL_X_RATIO = 0.3;
		public static final double ADD_TASK_PANEL_Y_RATIO = 0.5;  
		private Color BGC = new Color(255,0,0,0); 
		
		public AddLabelButton(JPanel world, double upperX, double upperY, double width, double height) {
			this.world = world;
		}
		
		public void createAction() {                  // Action
			ActionListener al = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					this.addLabel();// what it does goes here
					}
				};
				addActionListener(al); 
		}
		 public void addLabel() {
			 final String labelName= JOptionPane.showInputDialog("What does the porridge taste like? ");
			 Label newLabel = Label(labelName);
			 
			 
		 }
		
		


}