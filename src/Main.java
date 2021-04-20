//package ballworlds;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

//import util.Random;

/**
 * The starting point for the Pandativty application. It opens the pandativity frame.
 * 
 * This app is created by Nathan Atkinson, Jesus Capo, John Chung, Steven Xia, and Kieya McClung.
 */
public class Main {
//	private static final int NUMBER_OF_SIMULATIONS = 2;
//	private static final int MIN_WIDTH = 200;
//	private static final int MAX_WIDTH = 600;
//	private static final int MIN_HEIGHT = 100;
//	private static final int MAX_HEIGHT = 300;
//	private static final Color[] BACKGROUND_COLORS = { Color.RED,
//			Color.BLUE, Color.GREEN };

	/**
	 * Starts the application.
	 * 
	 * @param args
	 *            ignored
	 */
	public static void main(String[] args) {
		//ArrayList<SimulationPanel> worlds = constructSimulations();
		//JFrame frame = new BallWorldsFrame(worlds);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setVisible(true);
		
		JFrame pandativityFrame = new PandativityFrame();
		pandativityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pandativityFrame.setSize(new Dimension(1920,1080));
		pandativityFrame.setVisible(true);
		
		
	}

	/**
	 * This helper method constructs a list of simulation objects that will each
	 * simulate a world of bouncing balls.
	 * 
	 * @return a list of worlds
	 */
//	private static ArrayList<SimulationPanel> constructSimulations() {
//		ArrayList<SimulationPanel> result = new ArrayList<SimulationPanel>();
//		for (int i = 0; i < NUMBER_OF_SIMULATIONS; i++) {
//			int width = Random.randRange(MIN_WIDTH, MAX_WIDTH);
//			int height = Random.randRange(MIN_HEIGHT, MAX_HEIGHT);
//			Color c = BACKGROUND_COLORS[i % BACKGROUND_COLORS.length];
//			SimulationPanel sp = new SimulationPanel(width, height, c);
//			result.add(sp);
//		}
//		return result;
//	}

}
