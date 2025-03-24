package com.hotelmanagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener {

	JTable table;
	JButton back, submit;
	Choice typeofcar;
	
	public Pickup() {

		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel text = new JLabel("Pickup Service");
		text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text.setBounds(400, 30, 200, 30);
		add(text);

		JLabel lblcar = new JLabel("Type of Car");
		lblcar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblcar.setBounds(50, 100, 100, 18);
		add(lblcar);
		
		typeofcar = new Choice();
		typeofcar.setBounds(150, 100, 200, 25);
		add(typeofcar);
		
		try {
			
			Conn conn = new Conn();
			ResultSet rs = conn.stmt.executeQuery("select * from driver");
			while(rs.next()) {
				typeofcar.add(rs.getString("brand"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		JLabel l1 = new JLabel("Name");
		l1.setBounds(50, 160, 100, 20);
		add(l1);

		JLabel l2 = new JLabel("Age");
		l2.setBounds(200, 160, 100, 20);
		add(l2);

		JLabel l3 = new JLabel("Gender");
		l3.setBounds(330, 160, 100, 20);
		add(l3);

		JLabel l4 = new JLabel("Company");
		l4.setBounds(450, 160, 100, 20);
		add(l4);

		JLabel l5 = new JLabel("Brand");
		l5.setBounds(630, 160, 100, 20);
		add(l5);
		
		JLabel l6 = new JLabel("Availability");
		l6.setBounds(740, 160, 100, 20);
		add(l6);
		
		JLabel l7 = new JLabel("Location");
		l7.setBounds(890, 160, 100, 20);
		add(l7);

		table = new JTable();
		table.setBounds(0, 200, 1000, 300);
		add(table);

		try {
			Conn conn = new Conn();

			ResultSet rs = conn.stmt.executeQuery("select * from driver");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}

		submit = new JButton("Submit");
		submit.setForeground(Color.white);
		submit.setBackground(Color.black);
		submit.addActionListener(this);
		submit.setBounds(300, 520, 120, 30);
		add(submit);

		back = new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.addActionListener(this);
		back.setBounds(500, 520, 120, 30);
		add(back);

		setBounds(300, 200, 1000, 600);
		setVisible(true);
		setDefaultCloseOperation(1);

	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit) {
			try {

				String query = "select * from driver where brand ='" + typeofcar.getSelectedItem() + "'";
				
				Conn conn = new Conn();
				ResultSet rs;
			
				rs= conn.stmt.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			setVisible(false);
			new Reception();
		}
	}

	public static void main(String[] args) {
		new Pickup();

	}

}
