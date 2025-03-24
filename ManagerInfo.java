package com.hotelmanagement;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class ManagerInfo extends JFrame  implements ActionListener{

	JTable table;
	JButton back;
	public ManagerInfo() {
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(40, 10, 100, 20);
		add(l1);
		
		JLabel l2 = new JLabel("Age");
		l2.setBounds(170, 10, 100, 20);
		add(l2);
		
		JLabel l3 = new JLabel("Gender");
		l3.setBounds(290, 10, 100, 20);
		add(l3);
		
		JLabel l4 = new JLabel("Department");
		l4.setBounds(400, 10, 100, 20);
		add(l4);
		
		JLabel l5 = new JLabel("Salary");
		l5.setBounds(540, 10, 100, 20);
		add(l5);
		
		JLabel l6 = new JLabel("Phone");
		l6.setBounds(670, 10, 100, 20);
		add(l6);
		
		JLabel l7 = new JLabel("Aadhar");
		l7.setBounds(790, 10, 100, 20);
		add(l7);
		
		JLabel l8 = new JLabel("Email");
		l8.setBounds(910, 10, 100, 20);
		add(l8);
		
		
		back = new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.addActionListener(this);
		back.setBounds(420, 500, 120, 30);
		add(back);
		
		table = new JTable();
		table.setBounds(0, 40, 1000, 400);
		add(table);
		
		try {
			Conn conn = new Conn();
			
			ResultSet rs = conn.stmt.executeQuery("select * from employee where job='Manager'");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setBounds(300, 200, 1000, 600);
		setVisible(true);
		setDefaultCloseOperation(1);		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}
	public static void main(String[] args) {
		new ManagerInfo();

	}

}
