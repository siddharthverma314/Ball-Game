package game;

import javax.swing.*;

public class Game {
	
	//all the stuff required for the game
	private JFrame display = new JFrame();
	Ball ball = new Ball();
	Maze maze = new Maze();
	B_Move bmove = new B_Move(ball, maze);
	
	//constructor
	public Game(){
		
		//set all the stuff for display.
		getDisplay().setVisible(true);
		getDisplay().setTitle("Ball!");
		getDisplay().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getDisplay().setSize(1200,738);
		getDisplay().setLayout(null);
		
		//add the handlers
		getDisplay().addKeyListener(bmove);
		
		//add all the stuff
		getDisplay().add(ball);
		getDisplay().add(maze);
		
	}
	
	//main method required in the actual thing.
	public void run(int themazetiles[][]){

		//set the maze
		maze.tile = themazetiles;
		ball.setFinished(false);
		
		//do while not finished
		for( ; ; ){
			if(ball.getFinished()){
				//JOptionPane.showMessageDialog(getDisplay(), "You Finished!", "You Finished", JOptionPane.PLAIN_MESSAGE);
				break;
			}
		}
		display.setVisible(false);
	}

	public void setDisplay(JFrame display) {
		this.display = display;
	}

	public JFrame getDisplay() {
		return display;
	}
	
}
