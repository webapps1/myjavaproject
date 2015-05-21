package com.git.java.swings;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


import org.jvnet.substance.SubstanceLookAndFeel;

class AppMain  implements ActionListener
{ 
	public JFrame frame=new JFrame("Privacy Preserver - Main UI");	
	public JPanel top=new JPanel();
	public JLabel limage;
	public JButton node,route,exit,trafficgenerator;
	
	public AppMain() 
	{
		 top.setLayout(null);	 
		 top.setBorder(BorderFactory.createTitledBorder(""));
		 topdesign();
		 frame.add(top);
		 frame.setLayout(new GridLayout(1,1));
		 frame.setSize(680,330);
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
		limage=new JLabel("");
		limage.setIcon(new ImageIcon("images//mobile-network.jpg"));
		limage.setForeground(new Color(0,0,0));
		limage.setBounds(180,10,489,285);
		top.add(limage);
						
		node=new JButton("Resource");
		node.setBounds(30,50,120,25);
		top.add(node);
			
		trafficgenerator=new JButton("Analytics");
		trafficgenerator.setBounds(30,110,120,25);
		top.add(trafficgenerator);
			
		exit=new JButton("Exit");
		exit.setBounds(30,170,120,25);
		top.add(exit);			

		node.addActionListener(this);
		exit.addActionListener(this);
		trafficgenerator.addActionListener(this);
	}		
			
	public void actionPerformed(ActionEvent  ae) 
	{
		try
		{
			if(ae.getSource()==node)
			{
				
				System.out.println("in node");
				DataSet n =new DataSet();
				n.frame.show();
			}
			else if(ae.getSource()==exit)
			{
				System.out.println("in exit");
				System.exit(0);
			}
			else if(ae.getSource()==trafficgenerator)
			{
				System.out.println("in traffic generator");
				DataSet tg =new DataSet();
				tg.frame.show();
			}
		}catch(Exception ac)
		{
			ac.printStackTrace();
		}
	}
}