package game;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;

public class Ball extends JLabel{

	/**
	 * This is THE BALL!!!! HAHAHAHAHAHA!!
	 */
	private static final long serialVersionUID = 1L;
	static boolean finished = false;
	
	//the move class, handles key events, is in the game class itself.
	
	Ball(){
		//set all the stuff for ball
		this.setBounds(40, 40, 30, 30);//keylistener is in the game class.
	}
	
	//override paintComponent()
	public void paintComponent(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(0,0,30,30);
	}
	
	//get-set method for finished
	public void setFinished(boolean set){finished = set;}
	public boolean getFinished(){return finished;}
	
}
