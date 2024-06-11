package Bank_Management_System1;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class  Transactions extends JFrame  implements ActionListener{

	    JLabel l1;
	    JButton deposit,cashwith,fastcash,ministatement,pinchange,Balance,exit;
	    String pin;
	    
	    Transactions( String pin){
	    	
	        setLayout(null);

	        this.pin = pin;
	        
//	        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/im.jpg"));
//	        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//	        ImageIcon i3 = new ImageIcon(i2);
//	        
//	        JLabel l2 = new JLabel(i3);
//	        l2.setBounds(0, 0, 960, 1080);
//	        add(l2);
//	        
	        l1 = new JLabel("Please Select Your Transaction ");
	        l1.setFont(new Font("System", Font.BOLD, 16));
	        l1.setBounds(235,200,700,35);
	        add(l1);
	        
	        
	       
	        deposit = new JButton("DEPOSIT");
	        deposit.setBounds(170,299,150,35);
	        add(deposit);
	        deposit.addActionListener(this);

	        
	        
	        cashwith = new JButton("CASH WITHDRAWL");
	        cashwith.setBounds(390,299,150,35);
	        add(cashwith);
	        cashwith.addActionListener(this);
	     
	    
	        
	        fastcash = new JButton("FAST CASH");
	        fastcash.setBounds(170,343,150,35);
	        add(fastcash);
	        fastcash.addActionListener(this);
	       
	        ministatement = new JButton("MINI STATEMENT");
	        ministatement.setBounds(390,343,150,35);
	        add(ministatement);
	        ministatement.addActionListener(this);
	       
	        
	        
	        pinchange = new JButton("PIN CHANGE");
	        pinchange.setBounds(170,390,150,35);
	        add(pinchange);
	        pinchange.addActionListener(this);
	       
	        
	        Balance = new JButton("BALANCE ENQUIRY");	        
	        Balance.setBounds(390,390,150,35);
	        add(Balance);
	        Balance.addActionListener(this);
	       
	        
	        
	        exit = new JButton("EXIT");
	        exit.setBounds(390,450,150,35);
	        add(exit);
	        exit.addActionListener(this);    
	        
	        
	   
	        setSize(800,800);
	        setLocation(300,20);	        
//	        setUndecorated(true);
	        setVisible(true);
	        
	       	        
	    }
	    
	    public void actionPerformed(ActionEvent ae) {
			
	    	   if(ae.getSource()== deposit){ 
	               setVisible(false);     
	             new Deposit(pin).setVisible(true);
	               
	           }else if(ae.getSource()==cashwith){ 
                setVisible(false);
	             new Withdrawl(pin).setVisible(true);
               
	           }else if(ae.getSource()== fastcash ){ 
	               setVisible(false);
	               new FastCash(pin).setVisible(true);
	               
	           }else if(ae.getSource()== ministatement ){ 
	        	   setVisible(false);
	               new MiniStatement(pin).setVisible(true);
	               
	           }else if(ae.getSource()== pinchange ){ 
	               setVisible(false);
	               new PinChange(pin).setVisible(true);
	               
	           }else if(ae.getSource()== Balance ){ 
	               this.setVisible(false);
	               new BalanceEnquiry(pin).setVisible(true);
	        
	               
	           }else if(ae.getSource()== exit ){ 
	               System.exit(0);
	           }
	       }
	public static void main(String args[]) {
		
		new Transactions("")
		.setVisible(true);
	}




	
}
