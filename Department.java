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

public class Department extends JFrame implements ActionListener {

	JTable table;
	JButton back;

	public Department() {

		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel l1 = new JLabel("Department");
		l1.setBounds(180, 10, 100, 20);
		add(l1);

		JLabel l2 = new JLabel("Budget");
		l2.setBounds(450, 10, 100, 20);
		add(l2);

		table = new JTable();
		table.setBounds(0, 50, 700, 350);
		add(table);

		try {
			Conn conn = new Conn();

			ResultSet rs = conn.stmt.executeQuery("select * from department");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e) {
			e.printStackTrace();
		}

		back = new JButton("Back");
		back.setForeground(Color.white);
		back.setBackground(Color.black);
		back.addActionListener(this);
		back.setBounds(280, 400, 120, 30);
		add(back);

		setBounds(400, 200, 700, 480);
		setVisible(true);
		setDefaultCloseOperation(1);

	}

	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) {
		new Department();

	}

}
