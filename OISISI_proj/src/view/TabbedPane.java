package view;

//importi

import javax.swing.*;

import controller.*;
import model.GlobalConstants;

import java.awt.*;

public class TabbedPane extends JTabbedPane{
	
	/**
	 * 
	 */
	
	public TabbedPane(){
		super();
		TabelaStudenti tabelaStudenti = new TabelaStudenti();
		JScrollPane tabPaneStudent = new JScrollPane(tabelaStudenti);
		this.addTab(GlobalConstants.tabStudentName, tabPaneStudent);
		
		TabelaProfesora tabelaProfesora = new TabelaProfesora();
		JScrollPane tabPaneProfesor = new JScrollPane(tabelaProfesora);
		this.addTab(GlobalConstants.tabProfesorName, tabPaneProfesor);
		
		TabelaPredmeti tabelaPredmeta = new TabelaPredmeti();
		JScrollPane tabPanePredmet = new JScrollPane(tabelaPredmeta);
		this.addTab(GlobalConstants.tabPredmetName, tabPanePredmet);
	}
}