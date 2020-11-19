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
	static ControllerPredmet controllerPredmet;
	static TabelaPredmeti inst;
	
	public TabelaPredmeti() {
		inst = this;
		controllerPredmet = GlavniProzor.getControllerPredmet();
		
		azurirajTabelu();
	}
	
	//Inicijalizacija modela tabele :
	public static void tableInitialize(TabelaPredmeti t) {
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
	}

	//Metoda za izlistavanje profesora : 
	
	public static void azurirajTabelu() {
		ArrayList<Predmet> listaPredmeta = controllerPredmet.getListaPredmeta();
		
		tableInitialize(inst);
		
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
	
}
