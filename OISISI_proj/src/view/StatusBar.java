package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.text.*;
import java.util.Calendar;
import javax.swing.Timer;

import javax.swing.*;

public class StatusBar extends JPanel {
	
	public StatusBar() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(10,23));
		
		JLabel lab = new JLabel("  Studentska služba");
		
		
		DateFormat timeFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy  ");
		
		String currentTime = timeFormat.format(Calendar.getInstance().getTime());
		JLabel timeLab = new JLabel(currentTime);
		
		
		ActionListener timerListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date(System.currentTimeMillis());
                String time = timeFormat.format(date);
                timeLab.setText(time);
            }
        };
		
        Timer timer = new Timer(0, timerListener);
        timer.setInitialDelay(0);
        timer.start();
        
		lab.setFont(lab.getFont().deriveFont(16f));
		timeLab.setFont(lab.getFont().deriveFont(16f));		
		
		add(lab,BorderLayout.WEST);
		add(timeLab,BorderLayout.EAST);
		
	}
}
