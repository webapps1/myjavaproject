package com.git.java.swings;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.*;
import java.sql.*;
import java.awt.*;
import org.jvnet.substance.SubstanceLookAndFeel;


public class Login extends JFrame implements ActionListener
{
	public JFrame frame=new JFrame("Privacy Manager - Login Form");
	public JPanel top=new JPanel();
	public JLabel luname,lpass,limage;
	public static JTextField tfuname,tfpass;
	public JButton login,clear,exit;
	Connection con;
	
	public Login() 
	{
		 top.setLayout(null);
		 top.setBorder(BorderFactory.createTitledBorder(""));
		 topdesign();
		 frame.add(top);
		 frame.setLayout(new GridLayout(1,1));
		 frame.setSize(420,200);
		 frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 int w = frame.getSize().width;
		 int h = frame.getSize().height;
		 int x = (dim.width-w)/2;
		 int y = (dim.height-h)/2;
		 frame.setLocation(x, y);
     	 frame.setResizable(false);
	} 

	public void topdesign()
	{
		luname=new JLabel("UserName");
		luname.setBounds(40,40,50,10);
		top.add(luname);
			
		tfuname=new JTextField();
		tfuname.setBounds(120,30,120,25);
		top.add(tfuname);
			
		lpass=new JLabel("Password");
		lpass.setBounds(40,70,50,25);
		top.add(lpass);
			
		tfpass=new JPasswordField();
		tfpass.setBounds(120,70,120,25);
		top.add(tfpass);
			
		limage=new JLabel();
		limage.setIcon(new ImageIcon("images//Users.png"));
		limage.setBounds(270,15,270,135);
		top.add(limage);
						
		login=new JButton("Login");
		login.setBounds(20,120,70,20);
		top.add(login);
			
		clear=new JButton("Clear");
		clear.setBounds(100,120,70,20);
		top.add(clear);
			
		exit=new JButton("Exit");
		exit.setBounds(180,120,70,20);
		top.add(exit);

		login.addActionListener(this);
		clear.addActionListener(this);
		exit.addActionListener(this);
	}
		
	public void actionPerformed(ActionEvent  ae) 
	{
		try
		{
			if(ae.getSource()==login)
			{
				String tuname=tfuname.getText();
				String tpass=tfpass.getText();
				if(tuname.equalsIgnoreCase("") ||tpass.equalsIgnoreCase(""))
				{
					JOptionPane.showMessageDialog(null,"Please fill all the details ","Alert",1);
				}
				else
				{
					AppMain m = new AppMain();
					m.frame.show();
					this.dispose();
				}
			}
			else if(ae.getSource()==exit)
			{
				System.exit(0);
			}
			else if(ae.getSource()==clear)
			{
				tfuname.setText("");
				tfpass.setText("");
			}
		}catch(Exception ac)
		{
			System.out.println(ac.toString());
		}
	}	
	public static void main(String args[])
	{
		try 
		{
	      	SubstanceLookAndFeel.setCurrentTheme("org.jvnet.substance.theme.SubstanceBrownTheme");
			SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceCopperplateEngravingWatermark");
			SubstanceLookAndFeel.setCurrentGradientPainter("org.jvnet.substance.painter.StandardGradientPainter");
	        UIManager.setLookAndFeel(new SubstanceLookAndFeel());
		}
		catch (Exception e)
	    {
	       	e.printStackTrace();
	    }
		try
	    {
	    	new Login();
	    }
		catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    JFrame.setDefaultLookAndFeelDecorated(true);
	}
}