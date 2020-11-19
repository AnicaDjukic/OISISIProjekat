package view;

import javax.swing.*;

public class ErrorDialog{
	
	public ErrorDialog(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message, "Error" ,JOptionPane.ERROR_MESSAGE);
	}
}
