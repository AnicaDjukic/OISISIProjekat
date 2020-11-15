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
		
		TabelaStudenti tabelaStudenata = new TabelaStudenti();
		JScrollPane tabPaneStudent = new JScrollPane(tabelaStudenata);
		this.addTab("Studenti", tabPaneStudent);
		
		JPanel tabPaneProfesor = new JPanel();
		this.addTab("Profesori", tabPaneProfesor);
		
		JPanel tabPanePredmet = new JPanel();
		this.addTab("Predmeti", tabPanePredmet);		
	}
	
}
