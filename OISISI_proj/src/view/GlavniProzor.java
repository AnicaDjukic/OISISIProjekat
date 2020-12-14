package view;

//importi :
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import controller.*;
import model.GlobalConstants;

public class GlavniProzor extends JFrame {
	
	private Toolkit kit;
	static view.MyMenuBar menu;
	static Toolbar toolbar;
	static JPanel statusBar;
	static TabbedPane tabbedPane;
	static GlavniProzor inst;
	
	static ControllerProfesor cProf;
	static ControllerPredmet cPred;
	static ControllerStudent cStud;
	
	public GlavniProzor() {
		inst = this;
		kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height * 3/4;
		int screenWidth = screenSize.width * 3/4;
		
		setSize(screenWidth,screenHeight);
		setTitle(GlobalConstants.mfName);
		setLocationRelativeTo(null);
		addWindowListener(new MyWindowListener());
		
		//Incijalizacija kontrolera:
		cPred = new ControllerPredmet();
		cProf = new ControllerProfesor();
		cStud = new ControllerStudent();
		
		//Menu bar :
	    menu = new MyMenuBar();
	    setJMenuBar(menu);
		
		//Toolbar :
		toolbar = new Toolbar();
		add(toolbar,BorderLayout.NORTH);
		
		// Status bar
		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		
		//Sminkanje :
		Dimension d = statusBar.getSize();
		
		JPanel separatorEast = new JPanel();
		separatorEast.setSize(d.height,200);
		add(separatorEast,BorderLayout.EAST);
		
		JPanel separatorWest = new JPanel();
		separatorWest.setSize(d.height,200);
		add(separatorWest,BorderLayout.WEST);
		
		//Tabbed pane:		
		tabbedPane = new TabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
	}
	//Geteri : 
	public static TabbedPane getTabbedPane() {
		if(tabbedPane == null)
			tabbedPane = new TabbedPane();
		return tabbedPane;
	}
	public static GlavniProzor getGlavniProzor() {
		if(inst == null)
			inst = new GlavniProzor();
		return inst;
	}
	
	//Geteri za kontrolere :
	public static ControllerProfesor getControllerProfesor() {
		return cProf;
	}
	public static ControllerPredmet getControllerPredmet() {
		return cPred;
	}
	public static ControllerStudent getControllerStudent() {
		return cStud;
	}
	
	//Window listeneri : 
	public class MyWindowListener implements WindowListener{

		@Override
		public void windowOpened(WindowEvent e) {}

		@Override
		public void windowClosing(WindowEvent e) {
		
			JFrame mainFrame = (JFrame) e.getComponent();
			String [] options = {GlobalConstants.yesOpt,GlobalConstants.noOpt};
			int code = JOptionPane.showOptionDialog(mainFrame, GlobalConstants.upitZatvaranjeMF, GlobalConstants.upitZatvaranjeTitle, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
			
			if(code == JOptionPane.YES_OPTION) {
				serialize();
				mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			} else
				mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
		@Override
		public void windowClosed(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}
	}
	
	public static void serialize() {
		try {
			cProf.serialize();
			cPred.serialize();
			cStud.serialize();
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
}
