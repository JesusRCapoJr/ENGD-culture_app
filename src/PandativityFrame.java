import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PandativityFrame extends JFrame implements ComponentListener{
	
//	public final int BG_WIDTH = 300;
//	public final int BG_HEIGHT = 400;
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
			
			frame.setSize(Main.getWidth(), Main.getHeight());
			frame.setTitle("Pandativity");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//frame.setLayout(null);
			
			JPanel world = new JPanel(new BorderLayout()); 
			world.setBounds(0,0,Main.getWidth(),Main.getHeight());
			
			getContentPane().addComponentListener(this);
			
			world.setBackground(Color.CYAN);
			world.setLayout(null);
			
			frame.add(world);
			//frame.getContentPane().setBackground(Color.BLUE);
			frame.setVisible(true);
			//frame.setResizable(false);
			
			//world.add(new HomeOverviewPanel(world)); 
//			add(Box.createGlue()); 
			world.add(new HomeOverviewPanel(world));
			frame.repaint();
		}

		@Override
		public void componentResized(ComponentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Resized"); 
		}

		@Override
		public void componentMoved(ComponentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Moved"); 
		}

		@Override
		public void componentShown(ComponentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Shown"); 
		}

		@Override
		public void componentHidden(ComponentEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Hidden"); 
		}

	}
