package game;
import javax.swing.*;
import java.awt.*;
//import java.util.Random;

public class Maze extends JLabel{
	
	/**For the tiles**
	 * Make the tile array later. Right now,
	 * I am using a normal random tiles thing,
	 * just to check and finish program.
	 * 
	 * tiles is a 2d int array
	 * 0 : nothing
	 * 1 : tile
	 */
	private static final long serialVersionUID = -8739368981781414702L;

	//the variables
	int[][] tile = new int[20][20];
	/*{
			{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1 },
			{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
			{0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2 },
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0 }
	};*/
	int width = 35;
	
	//constructor, set properties
	Maze(){
		this.setSize(1500, 1500);
		
		/**DISCLAIMER:JUST A TEST
		 * this is just randomly generated tiles
		Random r = new Random();
		for(int x = 0;x != 20; x++){
			for(int y = 0;y != 20; y++){
				if(r.nextInt(1000) % 3 == 0) tile[x][y] = 1;
			}
		}*/
	}
	
	
	
	//override paintComponent()
	public void paintComponent(Graphics g){
		
		//background
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//the tiles
		int X = 0;
		int Y = 0;
		
		for(int x[] : tile){
			for(int y : x){
				if(y == 1) {
					g.setColor(Color.blue);
					g.fillRect(X*width, Y*width, width, width);
				}
				else if(y == 2){
					g.setColor(Color.red);
					g.fillRect(X*width, Y*width, width, width);
				}
				X++;
			}
			Y++;
			X = 0;
		}
		X = 0;
		
	}
	
}
