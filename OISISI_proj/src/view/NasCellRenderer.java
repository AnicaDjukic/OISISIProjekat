package view;


import java.awt.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class NasCellRenderer extends DefaultTableCellRenderer{
	
	public static final int STUDENT_RENDER = 0;
	public static final int PROFESOR_RENDER = 1;
	public static final int PREDMET_RENDER = 2;
	
	private int mod;
	
	public NasCellRenderer() {
		super();
	}
	
	public NasCellRenderer(int mode) {
		super();
		this.mod = mode;
	}
	
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		
		switch(mod) {
		case NasCellRenderer.STUDENT_RENDER:{
			//ovo ti doimplementiraj samo pazi column brojanje ide od 0
		}
		case NasCellRenderer.PROFESOR_RENDER:{
			if(column == 2 || column == 4 || column == 7)
				this.setHorizontalAlignment(SwingConstants.CENTER);
			else
				this.setHorizontalAlignment(SwingConstants.LEFT);
			break;
		}
		case NasCellRenderer.PREDMET_RENDER:{
			if(column == 2 || column == 3 || column == 4)
				this.setHorizontalAlignment(SwingConstants.CENTER);
			else
				this.setHorizontalAlignment(SwingConstants.LEFT);
			break;
		}
		}
		
		return this;
	}
}
