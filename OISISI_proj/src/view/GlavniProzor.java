package view;

//importi :
import javax.swing.*;

import java.awt.*;

public class GlavniProzor extends JFrame {
	
	public GlavniProzor() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height * 3/4;
		int screenWidth = screenSize.width * 3/4;
		
		setSize(screenWidth,screenHeight);
		
		setTitle("Studentska služba");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		
		// Menu Bar:
		JMenuBar menu = new MenuBar();
		setJMenuBar(menu);
	}
	
}
