import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PandativityFrame extends JFrame{

	public final int BG_WIDTH = 300;
	public final int BG_HEIGHT = 400;
	/**
	 * The simplest Java graphics program. From Ch. 2 of Big Java.
	 * 
	 * Adapted from code by @author Cay Horstmann
	 */

		/**
		 * Draws a frame.
		 * 
		 * @param args
		 *            ignored
		 */
		public PandativityFrame() {
			JFrame frame = new JFrame();
			
			frame.setSize(BG_WIDTH, BG_HEIGHT);
			frame.setTitle("Pandativity");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JPanel world = new JPanel(); 
			world.setBounds(0,0,BG_WIDTH,BG_HEIGHT);
			world.setBackground(Color.CYAN);
			frame.add(world);
			//frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			
			//world.add(new HomeOverviewPanel(world)); 
//			add(Box.createGlue()); 
			world.add(new HomeOverviewPanel(world));
			frame.repaint();
		}

	}
