package Bank_Management_System1;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


import java.sql.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import javax.swing.*;
import javax.swing.JFrame;


public class Deposit extends JFrame implements ActionListener {

	   
    JTextField t1,t2;
    JButton deposit,back,b3;
    JLabel text,l2;//13
    String pin;
    
	Deposit(String pin){
		
        setLayout(null);

        this.pin = pin;
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
        
//        JLabel l3 = new JLabel(i3);
//        l3.setBounds(0, 0, 960, 1080);
//        add(l3);
		
        text = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
//        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190,150,400,35);
        add(text);
        
        
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        t1.setBounds(190,220,320,25);
        add(t1);
        
        deposit = new JButton("DEPOSIT");        
        deposit.setBounds(300,300,150,35);
        add(deposit);
        
        
        back = new JButton("BACK");
        back.setBounds(500,300,150,35);
        add(back);
            
        deposit.addActionListener(this);
        back.addActionListener(this);
        
        setSize(800,800);
//      setUndecorated(true);
        setLocation(300,10);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();

            if(ae.getSource()==deposit){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                }
                else{
                	
                    Conn c1 = new Conn();
                    //'"+date+"',
                    c1.s.executeUpdate("insert into bank values('"+pin+"' , '"+date+"' ,'Deposit', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }
            else if(ae.getSource()==back){
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
            
        }catch(Exception e){

        	System.out.println(e);
        }
            
    }

	
	
	   public static void main(String[] args){
	        new Deposit("").setVisible(true);
	   }

	
}
