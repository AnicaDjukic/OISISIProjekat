package view;

import java.awt.Frame;
import javax.swing.JDialog;

import controller.*;

public class AddOrEditDialog extends JDialog{
	
	public static int add_mode = 1;
	public static int edit_mode = 2;
	
	public AddOrEditDialog(ControllerProfesor cp,int mode, GlavniProzor parent) {
		super();
		
		this.setResizable(false);
		
		int tab = GlavniProzor.getTabbedPane().getSelectedIndex();
		
		switch(tab) {
		case 0 : 
			//za studente
			break;
		case 1 :
			//za profesore
			if(mode == add_mode)
				this.setTitle("Dodavanje profesora");
			else
				this.setTitle("Izmena profeosra");
			
			this.setSize(400,500);
			this.setModal(true);
			this.add(new AddOrEditProfesor(cp,mode, this));
			this.setLocationRelativeTo(parent);
			break;
		case 2 :
			//za predmete
			break;
		}
		
		
	}

}
