package view;

//importi

import javax.swing.*;
import java.awt.*;

public class TabbedPane extends JTabbedPane{
	
	/**
	 * 
	 */
	
	TabbedPane(){
		super();
		this.setSize(500,500);
		JPanel tabPaneStudent = new JPanel();
		this.addTab("Studenti", tabPaneStudent);
		
		JPanel tabPaneProfesor = new JPanel();
		this.addTab("Profesori", tabPaneProfesor);
		
		JPanel tabPanePredmet = new JPanel();
		this.addTab("Predmeti", tabPanePredmet);		
	}
	
}
