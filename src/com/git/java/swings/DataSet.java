package com.git.java.swings;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.*;


public class DataSet implements ActionListener
{
	public JFrame frame=new JFrame("GUI Main");	
	public JPanel top=new JPanel();
	public JPanel bottom=new JPanel();
	public JLabel lpid,lpname,ldisease,lrdate,lstage,lage,lzip;
	public JTextField tpid,tpname,tdisease,trdate,tstage,tfage,tfzip;
	public JButton add,add1,clear,exit,update,delete,checkavail;

	Connection con;	
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement ps=null,ps1=null;
	
	public DataSet() 
	{
		 top.setLayout(null);
		 bottom.setLayout(null);
		 topdesign();
		 frame.add(top);
		 frame.setLayout(new GridLayout(1,1));
		 frame.setSize(435,380);
		 frame.setVisible(true);
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 int w = frame.getSize().width;
		 int h = frame.getSize().height;
		 int x = (dim.width-w)/2;
		 int y = (dim.height-h)/2;
		 frame.setLocation(x, y);
		 frame.setResizable(false);
     	 update.setEnabled(false);
     	 delete.setEnabled(false);     	 
	} 

	public void topdesign()
	{
		lpid=new JLabel("Patient ID");
		lpid.setBounds(40,15,100,20);
		top.add(lpid);
			
		lpname=new JLabel("Patient Name");
		lpname.setBounds(40,55,100,20);
		top.add(lpname);
						
		ldisease=new JLabel("Disease");
		ldisease.setBounds(40,95,100,20);
		top.add(ldisease);
			
		lrdate=new JLabel("Rec. Date");
		lrdate.setBounds(40,135,100,20);
		top.add(lrdate);
			
		lstage=new JLabel("Stage");
		lstage.setBounds(40,175,100,20);
		top.add(lstage);
			
		lage=new JLabel("Age");
		lage.setBounds(40,215,100,20);
		top.add(lage);			
			
		lzip=new JLabel("ZIP Code");
		lzip.setBounds(40,255,100,20);
		top.add(lzip);
							
		tpid=new JTextField();
		tpid.setBounds(160,15,100,20);
		//tpid.setText("Auto");
		top.add(tpid);
			
		tpname=new JTextField();
		tpname.setBounds(160,55,200,20);
		top.add(tpname);
						
		tdisease=new JTextField();
		tdisease.setBounds(160,95,180,20);
		top.add(tdisease);
			
		trdate=new JTextField();
		trdate.setBounds(160,135,180,20);
		top.add(trdate);
			
		tstage=new JTextField();
		tstage.setBounds(160,175,100,20);
		top.add(tstage);
			
		tfage=new JTextField();
		tfage.setBounds(160,215,100,20);
		top.add(tfage);			
			
		tfzip=new JTextField();
		tfzip.setBounds(160,255,100,20);
		top.add(tfzip);
			
		add1=new JButton("Generalize");
		add1.setBounds(280,255,120,25);
		top.add(add1);
		
		add=new JButton("k-Anonymous Update");
		add.setBounds(20,305,215,25);
		top.add(add);
			
		update=new JButton("Update");
		update.setBounds(100,305,60,25);
		//top.add(update);
			
		clear=new JButton("Clear");
		clear.setBounds(260,305,60,25);
		top.add(clear);
			
		exit=new JButton("Exit");
		exit.setBounds(340,305,60,25);
		top.add(exit);

		delete=new JButton("Delete");
		delete.setBounds(180,305,60,25);
		//top.add(delete);
			
		checkavail=new JButton("Search");
		checkavail.setBounds(270,13,100,25);
		top.add(checkavail);
						
		add1.addActionListener(this);
		add.addActionListener(this);
		clear.addActionListener(this);
		update.addActionListener(this);
		exit.addActionListener(this);
		delete.addActionListener(this);
		checkavail.addActionListener(this);
		add.setEnabled(false);
		
		tpname.setText("");
	}		
	public void actionPerformed(ActionEvent  ae) 
	{
		try
		{
			if(ae.getSource()==add)
			{
				JOptionPane.showMessageDialog(null,"Anonymous update succeeded.");
				tpname.setText("");
				tdisease.setText("");
				trdate.setText("");
				tstage.setText("");
				tfage.setText("");
				tpid.setText("");
				tfzip.setText("");
				add.setEnabled(false);
			}
			else if(ae.getSource()==add1)
			{
				try
				{
					JOptionPane.showMessageDialog(null,"Operation failed...");				
				}catch(Exception ex2)
				{
				  	System.out.println("excet "+ex2);
				  	JOptionPane.showMessageDialog(null,ex2);
				}
			}
			else if(ae.getSource()==exit)
			{
				frame.setVisible(false);
			}
			else if(ae.getSource()==clear)
			{
				tpname.setText("");
				tdisease.setText("");
				trdate.setText("");
				tstage.setText("");
				tfage.setText("");
				tpid.setText("");
				tfzip.setText("");
			}
			else if(ae.getSource()==update)
			{
				try
				{			   	
					JOptionPane.showMessageDialog(null,"Record Updated Successfully");
				}catch(Exception ex2)
				{
					System.out.println("excet "+ex2);
				}
			}
			else if(ae.getSource()==delete)
			{
				try
				{				
			       	JOptionPane.showMessageDialog(null,"Record Deleted Successfully");
				}catch(Exception ex2)
				{
					System.out.println("excet "+ex2);
				}
		    }
			else if(ae.getSource()==checkavail)
			{
				int rid = Integer.parseInt(tpid.getText());
				if(rid==0)
				{
					JOptionPane.showMessageDialog(null,"Please Enter Resource ID");
				}
			}
		}catch(Exception ac)
		{
			ac.printStackTrace();
		}
	}	
}