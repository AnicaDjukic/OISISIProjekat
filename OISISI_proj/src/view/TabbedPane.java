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
		JScrollPane tabPaneStudent = new JScrollPane();
		this.addTab("Studenti", tabPaneStudent);
		
		TabelaProfesora tabelaProfesora = new TabelaProfesora();
		JScrollPane tabPaneProfesor = new JScrollPane(tabelaProfesora);
		this.addTab("Profesori", tabPaneProfesor);
		
		TabelaPredmeti tabelaPredmeta = new TabelaPredmeti();
		JScrollPane tabPanePredmet = new JScrollPane(tabelaPredmeta);
		this.addTab("Predmeti", tabPanePredmet);		
	}
	
}