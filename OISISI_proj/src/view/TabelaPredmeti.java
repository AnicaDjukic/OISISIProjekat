package view;

//Importi : 

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import model.GlobalConstants;
import model.Predmet;
import model.Profesor;
import controller.ControllerPredmet;

import java.awt.Color;
import java.util.*;

public class TabelaPredmeti extends JTable { 
	
	private static Object[] colNames = {GlobalConstants.spr, GlobalConstants.npr, GlobalConstants.espb,GlobalConstants.god, GlobalConstants.sem};
	static DefaultTableModel model;
	static DefaultTableModel modelProf;
	static ControllerPredmet controllerPredmet;
	public static TabelaPredmeti inst;
	public static TabelaPredmeti instProf;
	
	private static Object[] colNamesProf = {GlobalConstants.spr, GlobalConstants.npr, GlobalConstants.god, GlobalConstants.sem};
	
	public TabelaPredmeti(boolean isProf) {
		if(!isProf)
			inst = this;
		else
			instProf = this;
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		controllerPredmet = GlavniProzor.getControllerPredmet();
		
		azurirajTabelu();
	}
	
	//Inicijalizacija modela tabele :
	public static void tableInitialize(TabelaPredmeti t, boolean isProf) {
		if(!isProf) {
			model = new DefaultTableModel() {
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
			NasCellRenderer poravnanje = new NasCellRenderer(NasCellRenderer.PREDMET_RENDER);
				for(int i = 0; i < colNames.length; i++)
					t.getColumnModel().getColumn(i).setCellRenderer(poravnanje);
		} else {
			modelProf = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			modelProf.setColumnIdentifiers(colNamesProf);
			t.setModel(modelProf);
			t.setRowHeight(20);
			t.setAutoCreateRowSorter(true);
			
			//Poravnanje : 
			NasCellRenderer poravnanje = new NasCellRenderer(NasCellRenderer.PREDMET_RENDER);
			for(int i = 0; i < colNamesProf.length; i++)
				t.getColumnModel().getColumn(i).setCellRenderer(poravnanje);
		}
	}

	//Metoda za izlistavanje profesora : 
	
	public static void azurirajTabelu() {
		ArrayList<Predmet> listaPredmeta = controllerPredmet.getListaPredmeta();
		
		tableInitialize(inst,false);
		
		String sifra,naziv,espb,godina,semestar;
		Object[] row = {"", "", "", "", ""};
		
		for(Predmet p : listaPredmeta) {
			sifra = p.getSif_pred();
			naziv = p.getNaziv();
			espb = ""+p.getEspb_bod();
			godina = ""+p.getGodIzv();
			semestar = ""+p.getSemestar();
			
			row[0] = sifra;
			row[1] = naziv;
			row[2] = espb;
			row[3] = godina;
			row[4] = semestar;
			
			model.addRow(row);
		}
	}
	
	//Metode za ispis predmeta jednog profesora :
	public static void azurirajTabeluProf(Profesor p) {
		
		tableInitialize(instProf,true);
		
		String sifra,naziv,godina,semestar;
		Object[] row = {"","","","",""};
		for(Predmet pr : p.getSpisPred()) {
			sifra = pr.getSif_pred();
			naziv = pr.getNaziv();
			godina = ""+pr.getGodIzv();
			semestar = ""+pr.getSemestar();
			
			row[0] = sifra;
			row[1] = naziv;
			row[2] = godina;
			row[3] = semestar;
			
			modelProf.addRow(row);
		}
	}
	
}
