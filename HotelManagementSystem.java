package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

	public HotelManagementSystem() {
		setTitle("Hotel Management System");
		setSize(1366, 565);
		setLocation(100, 80);
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(0, 0, 1366, 565);
		add(image);

		JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
		text.setForeground(Color.white);
		text.setFont(new Font("SERIF", Font.PLAIN, 30));
		text.setBounds(20, 470, 500, 30);
		image.add(text);

		JButton next = new JButton("Next ");
		next.setBounds(1170, 470, 100, 30);
		next.setBackground(Color.LIGHT_GRAY);
		next.addActionListener(this);
		add(next);
		

		setVisible(true);
		setDefaultCloseOperation(1);

		while (true) {
			text.setVisible(false);
			try {

				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			text.setVisible(true);
			
			try {

				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		new Login();
		
	}

	public static void main(String[] args) {

		new HotelManagementSystem();

	}
}
