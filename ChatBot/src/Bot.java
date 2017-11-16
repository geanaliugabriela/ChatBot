import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bot extends JFrame{

    private JTextField txtEnter = new JTextField();

    private JTextArea txtChat = new JTextArea();
    
    private JTextField t = new JTextField(20);
    private JTextField m = new JTextField(40);
    
    private JButton cancel = new JButton("Stop");
    
    List<String> hello = Arrays.asList(new String[]{"BUNA", "SALUT"});
    List<String> domnitori = Arrays.asList(new String[]{"VLAD TEPES","STEFAN CEL MARE", "MIRCEA CEL BATRAN"});
    String name;
    boolean close = false;
    ArrayList<ArrayList<String>> date = new ArrayList<>();
    
    public Bot(String name,ArrayList<ArrayList<String>> date) {
    	this.date = date;
    	this.name = name;
        //Frame Attributes:
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLayout(null);
        this.setTitle("Bot");
        this.add(t);
        this.add(m);
        

        txtEnter.setLocation(2, 520);
        txtEnter.setSize(570, 30);
       
        txtChat.append("Bot:  Buna ziua, " + name + "! " + "Cu ce te pot ajuta?\n");

        txtEnter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String uText = txtEnter.getText();
                txtChat.append("You: " + uText + "\n");
                txtEnter.setText("");
                
                if(uText.toUpperCase().contains("BUNA") || uText.toUpperCase().contains("SALUT")){
                	
                } else if(uText.toUpperCase().contains("UNDE ") ||
                		uText.toUpperCase().contains("CAND ") ||
                		uText.toUpperCase().contains("CARE ") ||
                		uText.toUpperCase().contains("?") ||
                		uText.toUpperCase().contains("CE")){
                	System.out.println("s-a pus o intrebare");
                	for(int i =0; i < domnitori.size();i++) {
                		
                		if(uText.toUpperCase().contains(domnitori.get(i))) {
                			if(uText.toUpperCase().contains("UNDE ")) {
                				txtChat.append("Bot: " + date.get(i).get(2) + "\n");
                			} else if(uText.toUpperCase().contains("CAND ")) {
                				txtChat.append("Bot: " + date.get(i).get(1) + "\n");
                			}
                			else {
                				txtChat.append("Bot: Nu stiu sa raspund.\n");
                			}
                		}
                	}
                } else {
                	txtChat.append("Bot: Nu inteleg intrebarea.\n");
                }
            }
        });
        
        cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				   close = true;
				
			}
		});
        
       

        txtChat.setLocation(15, 5);
        txtChat.setSize(560, 510);
        txtChat.setEditable(false);
       

        this.add(txtEnter);
        this.add(txtChat);
    }
}
