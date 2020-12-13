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
	
	private static Object[] colNames = {GlobalConstants.brLicKartLab,GlobalConstants.imeLab, GlobalConstants.przLab, GlobalConstants.titulaLab, GlobalConstants.zvanjeLab};
	static DefaultTableModel model;
	static ControllerProfesor controllerProfesor;
	public static TabelaProfesora inst;
	
	public TabelaProfesora() {
		inst = this;
		controllerProfesor = GlavniProzor.getControllerProfesor();
		inst.getTableHeader().setReorderingAllowed(false);
		inst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableInitialize(inst);
		
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

		//Poravnanje :
		NasCellRenderer poravnanje = new NasCellRenderer(NasCellRenderer.profesorRenderer);
		for(int i = 0; i < colNames.length; i++)
			t.getColumnModel().getColumn(i).setCellRenderer(poravnanje);
	}
	
	//Metoda za izlistavanje profesora : 
	
	public static void azurirajTabelu() {
		ArrayList<Profesor> listaProfesora = controllerProfesor.getListaProfesora();
		
		tableInitialize(inst);
		
		String brLicKart,ime,prezime,titula,zvanje;
		Object[] row = {"", "", "", "",""};
		
		for(Profesor p : listaProfesora) {
			brLicKart = p.getBrLicKart();
			ime = p.getIme();
			prezime = p.getPrezime();
			titula = p.getTitula();
			zvanje = p.getZvanje();
			
			row[0] = brLicKart;
			row[1] = ime;
			row[2] = prezime;
			row[3] = titula;
			row[4] = zvanje;
			
			model.addRow(row);
		}
	}
	
	public static void izlistajProfesore(ArrayList<String> foundBrLic) {
		
		ArrayList<Profesor> listaProfesora = controllerProfesor.getListaProfesora();
		
		tableInitialize(inst);
		
		String brLicKart,ime,prezime,titula,zvanje;
		Object[] row = {"", "", "", "",""};
		for(Profesor p : listaProfesora) {
			for(String br : foundBrLic) {
				if(br.equals(p.getBrLicKart())) {
					brLicKart = p.getBrLicKart();
					ime = p.getIme();
					prezime = p.getPrezime();
					titula = p.getTitula();
					zvanje = p.getZvanje();
					
					row[0] = brLicKart;
					row[1] = ime;
					row[2] = prezime;
					row[3] = titula;
					row[4] = zvanje;
					
					model.addRow(row);
				}
					
			}
		}
	}
	
}