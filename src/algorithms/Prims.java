package algorithms;

import java.util.Random;
import java.util.Vector;

public class Prims {

	int maze[][];
	int w;
	int h;
	int times = 0;
	
	public int[][] createMaze(int width, int height){
		
		Vector<int[]> walls = new Vector<int[]>();
		
		w = width;
		h = height;
		
		maze = new int[height][width];
		//set all cells to 1 unvisited
		for(int i = 0; i != height; i++){
			for (int j = 0; j != width; j++){
				maze[i][j] = 1;
			}
		}
		
		//set borders to 2
		for(int i = 0; i != width; i++){
			maze[0][i] = 2;
			maze[height - 1][i] = 2;
		}
		for(int i = 0; i != height; i++){
			maze[i][0] = 2;
			maze[i][width - 1] = 2;
		}
		
		//start the thing
		maze[1][1] = 0;
		maze[1][2] = 3;
		maze[2][1] = 3;
		
		//theloop
		while(times != height*width){
			
			//get available walls
			walls = findWall(maze);
			Random r = new Random();
			int index = r.nextInt(walls.size());
			
			//check around
			int cell[] = new int[2];
			int y = walls.get(index)[0];
			int x = walls.get(index)[1];
			int no = 0;
			
			//top
			cell[0] = y - 1;
			cell[1] = x;
			if(maze[cell[0]][cell[1]] == 0){
				no++;
				//System.out.println("top");
			}
			
			//right
			cell[0] = y;
			cell[1] = x + 1;
			if(maze[cell[0]][cell[1]] == 0){
				no++;
				//System.out.println("right");
			}
			//bottom
			cell[0] = y + 1;
			cell[1] = x;
			if(maze[cell[0]][cell[1]] == 0){
				no++;
				//System.out.println("bottom");
			}
			//left
			cell[0] = y;
			cell[1] = x - 1;
			if(maze[cell[0]][cell[1]] == 0){
				no++;
				//System.out.println("left");
			}
			
			if(no < 2){
				maze[walls.get(index)[0]][walls.get(index)[1]] = 0;
				times = 0;
			}
			else{
				times++;
				continue;
			}
			
			//walls around
			
			//top
			cell[0] = y - 1;
			cell[1] = x;
			if(maze[cell[0]][cell[1]] == 1)
				maze[cell[0]][cell[1]] = 3;
			
			//right
			cell[0] = y;
			cell[1] = x + 1;
			if(maze[cell[0]][cell[1]] == 1)
				maze[cell[0]][cell[1]] = 3;
			
			//bottom c
			cell[0] = y + 1;
			cell[1] = x;
			if(maze[cell[0]][cell[1]] == 1)
				maze[cell[0]][cell[1]] = 3;
			
			//left
			cell[0] = y;
			cell[1] = x - 1;
			if(maze[cell[0]][cell[1]] == 1)
				maze[cell[0]][cell[1]] = 3;
			
			walls.clear();
		}
		
		//convert the 2 and 3 to 1
		for(int i = 0; i != h; i++){
			for(int j = 0; j != w; j++){
				if(maze[i][j] != 0){
					maze[i][j] = 1;
				}
			}
		}
		
		//convert the two last to 2
		maze[h - 2][w - 1] = 2;
		maze[h - 2][w - 2] = 2;
		
		//print
		for(int a[]:maze){
			for(int b:a){
				System.out.print(b + " ");
			}
			System.out.println();
		}
		
		return maze;
		
	}
	
	private Vector<int[]> findWall(int maze[][]){
		Vector<int[]> walls = new Vector<int[]>();
		walls.clear();
		for(int i = 0; i != h; i++){
			for(int j = 0; j != w; j++){
				if(maze[i][j] == 3){
					int toadd[] = new int[]{i, j};
					walls.add(toadd);
				}
			}
		}
		return walls;
	}
	
}
