import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PandativityFrame extends JFrame{

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
			int frameWidth = 300;
			int frameHeight = 400;

			frame.setSize(frameWidth, frameHeight);
			frame.setTitle("Pandativity");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			
			frame.add(new HomeOverviewPanel(this),BorderLayout.NORTH); 
			add(Box.createGlue()); 
			frame.add(new HomeOverviewPanel(this),BorderLayout.SOUTH); 
			
			frame.repaint();
		}

	}
