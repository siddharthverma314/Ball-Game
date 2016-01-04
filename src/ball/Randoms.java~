package ball;
import algorithms.Prims;

import game.Game;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Randoms extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Game g;
	int[][] maze = new int[20][30];
	Prims p;
	
	Randoms(){
		//starting message
		String msg = "\t Welcome to Ball! \n" +
				"This is a ball game, where the ball is controlled \n" +
				"by the arrow keys. Red is the end of maze. The mazes are \n" +
				"randomly generated. When you want to exit, click the close \n" +
				"button in the upper left corner.";
		JOptionPane.showMessageDialog(this, msg, "Welcome", JOptionPane.PLAIN_MESSAGE);
		int rows = Integer.parseInt(JOptionPane.showInputDialog(this, "Set rows of maze. \n Minimum is 4.", "custom properties", JOptionPane.QUESTION_MESSAGE));
		int cols = Integer.parseInt(JOptionPane.showInputDialog(this, "Set columns of maze. \n Minimum is 4.", "custom properties", JOptionPane.QUESTION_MESSAGE));
		//start the game
		for( ; ; ){
			
			p = new Prims();
			g = new Game();
			maze = p.createMaze(cols, rows);
			g.getDisplay().setSize(cols*45,rows*45);
			g.run(maze);
			int chose = JOptionPane.showConfirmDialog(this, "Continue?", "Continue?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(chose == 1)break;
		
		}
		
		System.exit(0);
		
	}
	public static void main(String args[]){new Randoms();}
	
}
