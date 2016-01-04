package game;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MakeMaze extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//all the variables
	JButton maze[][] = new JButton[20][20];
	GridLayout g = new GridLayout(20,20);
	int act_maze[][] = new int[20][20];
	JFrame end;
	JTextArea act_maze_label;
	
	//event handler
	class Handler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i != 20; i++){
				for(int j = 0; j != 20; j++){
					if(e.getSource() == maze[i][j]){ 
						if(maze[i][j].getBackground() == Color.black){
							maze[i][j].setBackground(Color.BLUE);
							act_maze[i][j] = 1;
						}
						else{ 
							maze[i][j].setBackground(Color.black);
							act_maze[i][j] = 0;
						}
					}
				}
			}
			//redraw act_maze_label on end
			act_maze_label.setText("");
			for(int i = 0;i != 20;i++){
				act_maze_label.setText(act_maze_label.getText() + "{");
				for(int j = 0;j != 20; j++){
					if(j < 19)
						act_maze_label.setText(act_maze_label.getText() + act_maze[i][j] + ", ");
					else
						act_maze_label.setText(act_maze_label.getText() + act_maze[i][j] + " ");
				}
				if(i < 19)
					act_maze_label.setText(act_maze_label.getText() + "},\n");
				else
					act_maze_label.setText(act_maze_label.getText() + "}");
			}
		}
	}
	
	//constructor
	MakeMaze(){
		
		//initialise all properties and everything
		super("Make the Maze");
		this.setSize(700,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(g);
		Handler h[][] = new Handler[20][20];
		
		//add the buttons
		for(int i = 0; i != 20; i++	){
			for(int j = 0; j != 20; j++){
				maze[i][j] = new JButton();
				this.add(maze[i][j]);
				h[i][j] = new Handler();
				maze[i][j].addActionListener(h[i][j]);
				maze[i][j].setBackground(Color.black);
			}
		}
		
		//initialise act_maze, all to 0
		for(int x = 0; x != 20; x++){
			for(int y = 0; y != 20; y++){
				act_maze[x][y] = 0;
			}
		}
		
		//repaint window
		this.setSize(701,701);
		
		//request focus
		maze[0][0].requestFocus();
		

		//for end
		end = new JFrame();
		//initialise all properties for end
		end.setSize(300,370);
		end.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		end.setVisible(true);
		//add act_maze_label to end
		act_maze_label = new JTextArea();
		end.add(act_maze_label);
		
	}
	
	public static void main(String args[]){
		MakeMaze m = new MakeMaze();
		m.setAlwaysOnTop(false);
	}
	
}
