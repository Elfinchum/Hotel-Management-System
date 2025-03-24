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

public class CustomerInfo extends JFrame  implements ActionListener{

	JTable table;
	JButton back;
	public CustomerInfo() {
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel l1 = new JLabel("Document Type");
		l1.setBounds(20, 10, 100, 20);
		add(l1);
		
		JLabel l2 = new JLabel("Number");
		l2.setBounds(150, 10, 100, 20);
		add(l2);
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(290, 10, 100, 20);
		add(l3);
		
		JLabel l4 = new JLabel("Gender");
		l4.setBounds(420, 10, 100, 20);
		add(l4);
		
		JLabel l5 = new JLabel("Country");
		l5.setBounds(540, 10, 100, 20);
		add(l5);
		
		JLabel l6 = new JLabel("Room Number");
		l6.setBounds(650, 10, 100, 20);
		add(l6);
		
		JLabel l7 = new JLabel("Checkin Time");
		l7.setBounds(770, 10, 100, 20);
		add(l7);
		
		JLabel l8 = new JLabel("Deposit");
		l8.setBounds(900, 10, 100, 20);
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
			
			ResultSet rs = conn.stmt.executeQuery("select * from customer");
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
		new CustomerInfo();

	}

}
