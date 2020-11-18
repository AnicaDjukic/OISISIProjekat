package view;

//importi

import javax.swing.*;

import controller.ControllerPredmet;
import controller.ControllerProfesor;

import java.awt.*;

public class TabbedPane extends JTabbedPane{
	
	/**
	 * 
	 */
	
	public TabbedPane(ControllerProfesor cProf, ControllerPredmet cPred){
		super();
		TabelaStudenti tabelaStudenti = new TabelaStudenti();
		JScrollPane tabPaneStudent = new JScrollPane(tabelaStudenti);
		this.addTab("Studenti", tabPaneStudent);
		
		TabelaProfesora tabelaProfesora = new TabelaProfesora(cProf);
		JScrollPane tabPaneProfesor = new JScrollPane(tabelaProfesora);
		this.addTab("Profesori", tabPaneProfesor);
		
		TabelaPredmeti tabelaPredmeta = new TabelaPredmeti(cPred);
		JScrollPane tabPanePredmet = new JScrollPane(tabelaPredmeta);
		this.addTab("Predmeti", tabPanePredmet);
	}
}