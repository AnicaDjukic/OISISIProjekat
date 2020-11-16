package view;


//Importi :

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;

public class TableButtonRenderer implements TableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		JButton button = (JButton)value;
		return button;
	}
}
