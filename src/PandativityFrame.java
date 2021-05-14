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
	private static JPanel world; 
	private static JFrame frame; 
	
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
			frame = new JFrame();
			
			frame.setSize(Main.getWidth(), Main.getHeight());
			frame.setTitle("Pandativity");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			  
			world = new JPanel(); 
			world.setBounds(0,0,Main.getWidth(),Main.getHeight());
			world.setLayout(null);
			world.setBackground(Color.CYAN);
		
			frame.add(new HomeOverviewPanel((int)(Main.getWidth()*0.75), 0, (int)(Main.getWidth()*0.25), (int)(Main.getHeight()*0.66))); 
		
			world.repaint();
			
			getContentPane().addComponentListener(this);
			
			frame.getContentPane().add(world);
			frame.setVisible(true);
			frame.setResizable(true);
			frame.repaint();
			
			test(); 
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
		
		/**
		 * Erases the world
		 */
		public static void reborn() {
			frame.getContentPane().removeAll();
			frame.setBounds(0, 0, Main.getWidth(), Main.getHeight());
			frame.setVisible(true);
			frame.repaint();
			frame.add(world);
			
			world.removeAll();
			world.repaint();
			world.setBounds(0, 0, Main.getWidth(), Main.getHeight());
			world.setBackground(Color.MAGENTA); 
		}
		
		public static JPanel getWorld() {
			return world; 
		}
		/**
		 * For test only
		 */
		public void test() {
			FolderButton btn = new FolderButton(new Folder("Bruh"), frame); 
			btn.setBounds(20, 20, 100, 50);
			world.add(btn);  
		}
	}
