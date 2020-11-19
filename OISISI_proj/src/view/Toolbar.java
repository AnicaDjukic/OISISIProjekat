package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.*;

import controller.*;

public class Toolbar  extends JToolBar{
	private JButton btnAdd,btnEdit,btnBin,btnSrch;
	private JTextField srchField;
	
	ControllerProfesor cProf;
	ControllerPredmet cPred;
	ControllerStudent cStud;
	
	public Toolbar() {		
		super(SwingConstants.HORIZONTAL);
		
		btnAdd = new JButton();
		btnAdd.setToolTipText("Add");
		btnAdd.setIcon(new ImageIcon("images/add_button.png"));
		btnAdd.addActionListener(new AddButtonListener());
		add(btnAdd);
		
		addSeparator();
		
		btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("images/edit_button.png"));
		add(btnEdit);
		
		addSeparator();
		
		btnBin = new JButton();
		btnBin.setToolTipText("Delete");
		btnBin.setIcon(new ImageIcon("images/bin_button.png"));
		add(btnBin);
		
		add(Box.createHorizontalGlue());
		addSeparator();
		
		srchField = new JTextField(20);
		srchField.setMaximumSize(new Dimension(350,25));
		srchField.setMinimumSize(new Dimension(350,25));
		add(srchField);	
		addSeparator();
		
		btnSrch = new JButton();
		btnSrch.setToolTipText("Search");
		btnSrch.setIcon(new ImageIcon("images/search_button.png"));
		add(btnSrch);
	}
}
