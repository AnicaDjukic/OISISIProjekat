package view;

import java.awt.Frame;
import javax.swing.JDialog;

import controller.*;

public class AddOrEditDialog extends JDialog{
	
	public static int add_mode = 1;
	public static int edit_mode = 2;
	
	public AddOrEditDialog(int mode) {
		super();
		
		this.setResizable(false);
	
	}
	public AddOrEditDialog(ControllerProfesor cp, int mode) {
		super();
		
		this.setResizable(false);
		
		if(mode == add_mode)
			this.setTitle("Dodavanje profesora");
		else
			this.setTitle("Izmena profeosra");
		
		this.setSize(400,500);
		this.setLocationRelativeTo(null);
		this.add(new AddOrEditProfesor(cp,mode));
	}

}
