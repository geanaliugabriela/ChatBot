import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class LoginWindow
{
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	static boolean loged = false;
	JFrame f ;
	JTextField t ;
	JTextField p ;
	JLabel l1 , l2;
	JButton ok ;
	ArrayList<ArrayList<String>> date = new ArrayList<>();
	LoginWindow(ArrayList<ArrayList<String>> date)
	{
		this.date = date;
		f = new JFrame("Login Window") ;
		f.setBounds(200,200,350,150) ;
		t = new JTextField(20) ;
		p = new JTextField(20) ;
		l1 = new JLabel("Username : ");
		l2 = new JLabel("e-mail : ");
		ok = new JButton("OK") ;
		f.add(l1);
		f.add(t) ;
		f.add(l2);
 		f.add(p) ;
		f.add(ok) ;
		f.setLayout(new FlowLayout()) ;
		f.setVisible(true) ;
		
		
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent ok) {
				boolean result = true;
				if(validate(p.getText())) {
					f.setVisible(false);
					String name = t.getText();
					System.out.println(name);
					new Bot(name,date);
					loged = true;
				}
				else {
					new ErrorMessage();
				}
			}
			
			
		});
	
	}

	public boolean getLogStatus() {
		return loged;
	}
	
	public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
        return matcher.find();
	}
	
}
