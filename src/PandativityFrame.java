import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PandativityFrame extends JFrame{

	/**
	 * The simplest Java graphics program. From Ch. 2 of Big Java.
	 * 
	 * Adapted from code by @author Cay Horstmann
	 */

		public PandativityFrame() {
			JFrame frame = new JFrame();
			
			frame.setSize(Main.WIDTH, Main.HEIGHT);
			frame.setTitle("Pandativity");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel world = new JPanel(); 
			world.setBounds(0,0,Main.WIDTH,Main.HEIGHT);
			world.setBackground(Color.CYAN);
			frame.add(world);
			//frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			frame.setResizable(false);
			
			//world.add(new HomeOverviewPanel(world)); 
//			add(Box.createGlue()); 
			world.add(new HomeOverviewPanel(world));
			frame.repaint();
		}

	}
