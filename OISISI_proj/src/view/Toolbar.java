package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.*;

import controller.*;
import model.GlobalConstants;

public class Toolbar  extends JToolBar{
	private JButton btnAdd,btnEdit,btnBin,btnSrch;
	private JTextField srchField;
	
	ControllerProfesor cProf;
	ControllerPredmet cPred;
	ControllerStudent cStud;
	
	public Toolbar() {		
		super(SwingConstants.HORIZONTAL);
		
		btnAdd = new JButton();
		btnAdd.setToolTipText(GlobalConstants.addBtnToolTipTxt);
		btnAdd.setIcon(new ImageIcon(GlobalConstants.addImg));
		btnAdd.addActionListener(new AddButtonListener());
		add(btnAdd);
		
		addSeparator();
		
		btnEdit = new JButton();
		btnEdit.setToolTipText(GlobalConstants.editBtnToolTipTxt);
		btnEdit.setIcon(new ImageIcon(GlobalConstants.editImg));
		add(btnEdit);
		
		addSeparator();
		
		btnBin = new JButton();
		btnBin.setToolTipText(GlobalConstants.delBtnToolTipTxt);
		btnBin.setIcon(new ImageIcon(GlobalConstants.delImg));
		add(btnBin);
		
		add(Box.createHorizontalGlue());
		addSeparator();
		
		srchField = new JTextField(20);
		srchField.setMaximumSize(new Dimension(350,25));
		srchField.setMinimumSize(new Dimension(350,25));
		srchField.setToolTipText(GlobalConstants.srchFieldToolTipTxt);
		add(srchField);	
		addSeparator();
		
		btnSrch = new JButton();
		btnSrch.setToolTipText(GlobalConstants.srchBtnToolTipTxt);
		btnSrch.setIcon(new ImageIcon(GlobalConstants.srcImg));
		add(btnSrch);
	}
}
