package cellule;
import ui.UI;
import java.util.Arrays;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

//asd
public class CelluleManager{

	private int x_limite;
	private int y_limite;
	private ArrayList<Cellule> cellules;
	private int maxGeneration = Integer.MAX_VALUE;
	
	private int CelluleMorte;
	private State neighbourState;
	private String nextState;
	private int lifeCycle=0;

	private int cellWidth, cellHeight;

	private UI ui;

	private ArrayList<int[]> neighbourPositions;
//init

	public CelluleManager(UI ui, int x,int y){
		this.x_limite=x;
		this.y_limite=y;

		this.ui = ui;

		cellWidth = ui.getWidth()/x;
		cellHeight = ui.getHeight()/y;

		this.neighbourPositions = new ArrayList<int[]>();
		this.neighbourPositions.add(new int[]{-1,-1});
		this.neighbourPositions.add(new int[]{-1,0});
		this.neighbourPositions.add(new int[]{-1,1});
		this.neighbourPositions.add(new int[]{0,-1});
		this.neighbourPositions.add(new int[]{0,1});
		this.neighbourPositions.add(new int[]{1,-1});
		this.neighbourPositions.add(new int[]{1,0});
		this.neighbourPositions.add(new int[]{1,1});
	}

	public void init(){

		cellules = new ArrayList<Cellule>();
		for (int y = 1; y<=y_limite ; y++ ) 
		{
			for (int x = 1; x<=x_limite; x++) 
			{
				Cellule cellule = new Cellule(new int[]{x,y});
				cellules.add(cellule);
			}
		}

		this.lifeCycle=0;

		System.out.println("CelluleManager :: init -> Done");
		this.print();

	}

	public void load(){

		//juste coller une ou deux cellule vivante dans ton tableau :-P
		this.setState(2,2,State.ALIVE);
		this.setState(3,3,State.ALIVE);
		this.setState(3,4,State.ALIVE);
		this.setState(2,4,State.ALIVE);
		this.setState(1,4,State.ALIVE);
/*
		loadState(cellule);

		String state = cellule.getState();
		int[] cellulPos = cellule.getPosition();
		System.out.print(Arrays.toString(cellulPos));

		//System.out.print("["+x+", "+y+"]" + state);
		System.out.print(state);
		System.out.print("|");
		System.out.println();*/

		this.print();
	}

	public void start(){
		this.lifeCycle++ ;
		/*try
		{
			Thread.sleep(200);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}*/

		for(Cellule cell : cellules){
			int[] celluleToCheck = cell.getPosition();//position de la cellule a check(celluleToCheck)
			int nbCelluleVivante = 0;
	
			for(int[] neighbourPosition : neighbourPositions){
				//recherche de la position des voisins

				//addition de celluleToCheck et de neighbour
				int neighbourX = celluleToCheck[0] + neighbourPosition[0];//System.out.println("neibourgX : " + neighbourX);
				int neighbourY = celluleToCheck[1] + neighbourPosition[1];//System.out.println("neibourgY : " + neighbourY);
				/*System.out.print("[" + celluleToCheck[0] + "," + celluleToCheck[1] + "] + [" +neighbourPosition[0] +","+neighbourPosition[1] + "]" );
				System.out.print(" => ");
				System.out.println(neighbourX + "," +neighbourY);*/

				neighbourState = this.getState(neighbourX, neighbourY);

				if(neighbourState == State.ALIVE){
					nbCelluleVivante++;
				}
			}

			// Tester le nombre de cellule vivante autour est définir le nextState
			if(nbCelluleVivante==3){
				//vivante
				cell.setNextState(State.ALIVE);

			}else if(nbCelluleVivante==2){
				//ne change pas
				if(cell.getState()==State.DEAD ){
					cell.setNextState(State.DEAD);
				}else if(cell.getState()==State.ALIVE){
					cell.setNextState(State.ALIVE);
				}
			}else {
			//if(nbCelluleVivante <2 || nbCelluleVivante > 3){
				//mort
				cell.setNextState(State.DEAD);
			}


			/*if(cell.nextState=="O"){
				CelluleMorte++;
			}*/
		}

		boolean stillAlive=false;
		for(Cellule cell : cellules){
			State state = cell.goNextGeneration();
			if(state == State.ALIVE){
				stillAlive = true;
			}
		}

		//verrifier si toute les cellules sont morte=> exit autrement =>print puis re stare
		print();

		if(stillAlive && this.lifeCycle<this.maxGeneration){
			this.start();
		}
	}

//load

	private Cellule getCellule(int x, int y){
		if(x < 1 || x > this.x_limite || y < 1 || y > this.y_limite)
			return new Cellule( new int[]{x,y} );

		///
		int pos = (y-1)*this.x_limite + x;
		///
		return cellules.get(pos-1);
	}

	public void loadState(Cellule celluleToLoad){
		celluleToLoad.changeState(); 
	}

	private void setState(int x, int y, State state){
		this.getCellule(x, y).setState(state);
	}

	private void setNextState(int x, int y, State state){
		this.getCellule(x, y).setState(state);
	}

	private State getState(int x, int y){
		return this.getCellule(x, y).getState();
	}

	public int setLifeCycle(){
		return this.lifeCycle;
	}

	private void print(){
		/*
		System.out.println("-----------------");
		System.out.println("LifeCycle:" + this.lifeCycle);
		System.out.println("-----------------");
*/
		for(Cellule cellule : this.cellules){
			cellule.print(ui.getGraphics(), cellWidth, cellHeight);

			/*if(cellule.getX() == this.x_limite){
				System.out.println("|");
			}*/
		}
		ui.getGraphics().setColor(Color.white);
		try {
			Thread.sleep(150);
		} catch (Exception e) {

		}
		ui.getGraphics().clearRect(70, 0, 150, 10);
		ui.getGraphics().drawString( ""+this.lifeCycle, 150, 10);

		//System.out.println();
	}
	
}