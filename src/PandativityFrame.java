import javax.swing.JFrame;

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
		public static void main(String[] args) {
			JFrame frame = new JFrame();
			int frameWidth = 300;
			int frameHeight = 400;

			frame.setSize(frameWidth, frameHeight);
			frame.setTitle("An Empty Frame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setVisible(true);
		}

	}
