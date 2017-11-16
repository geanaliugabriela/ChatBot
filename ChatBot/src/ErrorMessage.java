import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ErrorMessage {
	JFrame f ;
	JLabel l1;
	JButton ok  ;
	
	public ErrorMessage() {
		f = new JFrame("Login Window") ;
		f.setBounds(200,200,350,150) ;
		l1 = new JLabel("Invalid Email Address!!! ");
		ok = new JButton("OK") ;
		
		f.add(l1);
		f.add(ok) ;
		f.setLayout(new FlowLayout()) ;
		f.setVisible(true) ;
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ok) {
				f.setVisible(false) ;
			}
			
		});
	}
	
}
