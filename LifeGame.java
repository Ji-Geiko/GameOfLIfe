//java lifeGame 7 7 initialState.txt 1000
import ui.StartInterface;
import ui.*;
import cellule.*;
import java.awt.event.*;
import java.awt.event.ActionListener;;

public class LifeGame{// implements ActionListener{

	public static void main(String[] params){
		
	//	StartInterface start= new StartInterface(300, 300);
       	//addActionListener(new BoutonListener());
			//Redéfinition de la méthode actionPerformed()
			//public  actionPerformed(ActionEvent arg0) {	
				
				UI ui = new UI(300, 300);

				CelluleManager manager = new CelluleManager(ui, 30, 30);
				

//**********************************************************************************
				manager.init();
							
				manager.load();

				manager.start();
//**********************************************************************************
			//}		  
	}
}