package cellule;
// script des cellule


import java.awt.*;
import java.util.Arrays;

public class Cellule{
	private State state = State.DEAD;
	private State nextState;
	private int[] position;

	public Cellule(int[] position){
		this.position = position;

	}
	public void changeState(){

        boolean test = false; 

        for (int pos : position) { 
            /*if (element == toCheckValue) { 
                test = true; 
                break; 
            } */
        }
	}

	public int[] getPosition(){
		return this.position;
	}

	public int getY(){
		return this.position[1];
	}
	public int getX(){
		return this.position[0];
	}

	public State getState(){
		return this.state;
	}

	public void setState(State state){
		this.state = state;
	}

	public void setNextState(State nextState){
		this.nextState = nextState;
	}

	public void print(Graphics g, int w, int h){
		/*g.setColor(Color.blue);
		g.drawRect((this.position[0]-1)*w, (this.position[1]-1)*w, w, h);*/
		if(this.state == State.ALIVE){
			g.setColor(Color.black);
		}else{
			g.setColor(Color.white);
		}
		g.fillRect(((this.position[0]-1)*w)+1, ((this.position[1]/*-1*/)*w)+1, w-1, h-1);

		/*String outputState = (this.state == State.ALIVE) ? "X" : "O";
		System.out.print("|" +  outputState);
		*/
		//System.out.print("|" + Arrays.toString(this.position) + outputState);

	}

	public State goNextGeneration(){
		if(this.nextState != null){
			this.state = this.nextState;
		}
		
		return this.state;
	}
}

enum State{
	ALIVE,
	DEAD,
}