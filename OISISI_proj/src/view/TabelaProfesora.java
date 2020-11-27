package view;

//Importi : 

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.GlobalConstants;
import model.Profesor;
import controller.ControllerProfesor;

import java.awt.Color;
import java.util.*;

public class TabelaProfesora extends JTable { 
	
	private static Object[] colNames = {GlobalConstants.imeLab, GlobalConstants.przLab, GlobalConstants.titulaLab, GlobalConstants.zvanjeLab};
	static DefaultTableModel model;
	static ControllerProfesor controllerProfesor;
	static TabelaProfesora inst;
	
	public TabelaProfesora() {
		inst = this;
		controllerProfesor = GlavniProzor.getControllerProfesor();
		
		tableInitialize(inst);
		
		//Poravnanje :
		NasCellRenderer poravnanje = new NasCellRenderer(NasCellRenderer.profesorRenderer);
		for(int i = 0; i < colNames.length; i++)
			getColumnModel().getColumn(i).setCellRenderer(poravnanje);
		//Test primer!
		
		azurirajTabelu();
	}
	
	//Inicijalizacija modela tabele :
	public static void tableInitialize(TabelaProfesora t) {
		model = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.setColumnIdentifiers(colNames);
		t.setModel(model);
		
		t.setRowHeight(35);
		t.setAutoCreateRowSorter(true);
		t.setFont(t.getFont().deriveFont(16F));
	}
	
	//Metoda za izlistavanje profesora : 
	
	public static void azurirajTabelu() {
		ArrayList<Profesor> listaProfesora = controllerProfesor.getListaProfesora();
		
		tableInitialize(inst);
		
		String ime,prezime,titula,zvanje;
		Object[] row = {"", "", "", ""};
		
		for(Profesor p : listaProfesora) {
			ime = p.getIme();
			prezime = p.getPrezime();
			titula = p.getTitula();
			zvanje = p.getZvanje();
			
			row[0] = ime;
			row[1] = prezime;
			row[2] = titula;
			row[3] = zvanje;
			
			model.addRow(row);
		}
	}
	
}
