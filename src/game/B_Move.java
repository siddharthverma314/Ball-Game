package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//handler for the Ball
public class B_Move implements KeyListener{
	
	//a few variables
	int direction = 4;
	mover m = new mover();
	Ball b = new Ball();
	Maze ma = new Maze();
	Thread t = new Thread(m);
	
	//gets the ball and starts the thread run.
	B_Move(Ball ball, Maze mat){
		b = ball;
		t.start();
		ma = mat;
	}
	
	//the functions of KeyListener
	public void keyTyped(KeyEvent e){}		
	public void keyReleased(KeyEvent e){direction = 4;}
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_UP) direction = 0;
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) direction = 1;
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) direction = 2;
		else if (e.getKeyCode() == KeyEvent.VK_LEFT) direction = 3;
	}
	
	class mover implements Runnable{
		/**Direction:
		 * 0 = up
		 * 1 = right
		 * 2 = down
		 * 3 = left
		 */
		//Modify to include not crashing into the walls of maze.
		public void run(){
			try {
				for( ; ; ){
					/**This is how to check if touching wall
					 * Use only the four points at the edges.
					 * detect which box they are in.
					 * if the box is 1, do not let it move.
					 * not using the following anymore.
					int tls[] = {b.getY()/ma.width, b.getX()/ma.width};
					int trs[] = {b.getY()/ma.width, (b.getX()+30)/ma.width};
					int bls[] = {(b.getY()+30)/ma.width, b.getX()/ma.width};
					int brs[] = {(b.getY()+30)/ma.width, (b.getX()+30)/ma.width};
					if(ma.tile[tls[0]][tls[1]] == 2 || ma.tile[trs[0]][trs[1]] == 2 || ma.tile[bls[0]][bls[1]] == 2 || ma.tile[brs[0]][brs[1]] == 2){
						//b.finished = true;
						//System.out.println("Finished!");
					};*/
					
					boolean hit = false;
					
					if (direction == 0){
						int x = b.getX();
						int y = b.getY() - 1;
						int w = ma.width;
						int tl[] = {y/w, x/w};
						int tr[] = {y/w, (x+30)/w};
						if(ma.tile[tl[0]][tl[1]] == 1 || ma.tile[tr[0]][tr[1]] == 1) hit = true;
					}
					else if(direction == 1){
						int x = b.getX() + 1;
						int y = b.getY();
						int w = ma.width;
						int br[] = {(y+30)/w, (x+30)/w};
						int tr[] = {y/w, (x+30)/w};
						if(ma.tile[br[0]][br[1]] == 1 || ma.tile[tr[0]][tr[1]] == 1) hit = true;
					}
					else if(direction == 2){
						int x = b.getX();
						int y = b.getY() + 1;
						int w = ma.width;
						int bl[] = {(y+30)/w, x/w};
						int br[] = {(y+30)/w, (x+30)/w};
						if(ma.tile[bl[0]][bl[1]] == 1 || ma.tile[br[0]][br[1]] == 1) hit = true;
					}
					else if(direction == 3){
						int x = b.getX() - 1;
						int y = b.getY();
						int w = ma.width;
						int tl[] = {y/w, x/w};
						int bl[] = {(y+30)/w, x/w};
						if(ma.tile[tl[0]][tl[1]] == 1 || ma.tile[bl[0]][bl[1]] == 1) hit = true;
					}
					else{};
					
					if (!hit) {
						//this is moving
						if (direction == 0) {
							b.setBounds(b.getX(), b.getY() - 1, b.getWidth(),
									b.getHeight());
						} else if (direction == 1) {
							b.setBounds(b.getX() + 1, b.getY(), b.getWidth(),
									b.getHeight());
						} else if (direction == 2) {
							b.setBounds(b.getX(), b.getY() + 1, b.getWidth(),
									b.getHeight());
						} else if (direction == 3) {
							b.setBounds(b.getX() - 1, b.getY(), b.getWidth(),
									b.getHeight());
						} else {
						}
						;
					}
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {e.printStackTrace(); System.exit(1);}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				b.setFinished(true);
			}
		}
	}	
}

