package Bank_Management_System1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JButton b1, b2;
    JLabel l1;
    
    MiniStatement(String pin){
    	
        setTitle("Bank Account Statement");
        
        setLayout(null);

        l1 = new JLabel();
        l1.setBounds(20, 140, 400, 200);
        add(l1);
        
        JLabel bank = new JLabel(" National Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        
        
        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(400,600);
        setLocation(30,20);
        
       
        
       
     
     
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardno").substring(0, 5) + "XXXXXXX" + rs.getString("cardno").substring(12));
            }
        }catch(Exception e){        	
        	System.out.println(e);
        	
        }
        	 
        try{
            int balance = 0;
            Conn c1  = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
            while(rs.next()){
                l1.setText(l1.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
            l4.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
        	System.out.println(e);
        }
        
        
        
        
        
        b1 = new JButton("Exit");
        add(b1);    
        b1.addActionListener(this);
        b1.setBounds(20, 500, 100, 25);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new MiniStatement("").setVisible(true);
    }
    
}