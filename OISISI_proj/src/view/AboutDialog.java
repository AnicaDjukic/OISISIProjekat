package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog {
	
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
	private JPanel panel;
	
	public AboutDialog() {
		label1 = new JLabel("\t Aplikacija \"Studentska slu�ba\"");
		label2 = new JLabel("\t Verzija: 1.0");
		label3 = new JLabel();
		label4 = new JLabel("\t Aplikacija \"Studentska slu�ba\" omogu�ava evidenciju studenata, profesora i predmeta,\t ");
		label5 = new JLabel("\t kako bi olak�ala rad �alterskim radnicima studentske slu�be Fakulteta tehni�kih nauka,\t ");
		label6 = new JLabel("\t Univerziteta u Novom Sadu.");
		label7 = new JLabel();
		label8 = new JLabel("\t Autori: Anica �uki� i Nikola Milosavljevi�");
		label9 = new JLabel("\t Studenti 3. godine smera \"Ra�unarstvo i automatika\" Fakulteta tehni�kih nauka,");
		label10 = new JLabel("\t Univerziteta u Novom Sadu.");
		
		JLabel[] labels = {label1, label2, label3, label4, label5, label6, label7, label8, label9, label10};
		
		Font font = new Font("Arial", Font.ITALIC, 16);
		
		for(JLabel l : labels) {
			l.setFont(font);
		}
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(0,1));
		for(JLabel l : labels)
			panel.add(l);
		
		add(panel, BorderLayout.CENTER);
	    setTitle("About");
		
			
	}
}