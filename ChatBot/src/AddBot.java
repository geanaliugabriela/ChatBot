import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AddBot {
	JFrame f ;
	JLabel l1;
	JButton ok  ;
	ArrayList<ArrayList<String>> date = new ArrayList<>();
	
	public AddBot(ArrayList<ArrayList<String>> date) {
		this.date = date;

		f = new JFrame("New Bot") ;
		f.setBounds(200,200,350,150) ;
		l1 = new JLabel("Add new Bot? ");
		ok = new JButton("OK") ;
		
		f.add(l1);
		f.add(ok) ;
		f.setLayout(new FlowLayout()) ;
		f.setVisible(true) ;
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ok) {
				new LoginWindow(date);
			}
			
		});
		
	}
}
