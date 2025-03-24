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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JTextField username;
	JPasswordField password;
	JButton login, cancel;
	
	Login(){
		
		setTitle("Login ");
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel user = new JLabel("Username");
		user.setBounds(40, 20, 100, 30);
		add(user);
		
		username = new JTextField();
		username.setBounds(150, 25, 150, 20);
		add(username);
		
		JLabel pass = new JLabel("Password");
		pass.setBounds(40, 70, 100, 30);
		add(pass);
		
		password = new JPasswordField();
		password.setBounds(150, 75, 150, 20);
		add(password);
		
		login = new JButton("Login ");
		login.setForeground(Color.WHITE);
		login.setBackground(Color.DARK_GRAY);
		login.setBounds(40, 150, 100, 30);
		login.addActionListener(this);
		add(login);
		
		cancel = new JButton("Cancel ");
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(Color.DARK_GRAY);
		cancel.setBounds(180, 150, 100, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 10, 200, 200);
		add(image);
		
		setBounds(500, 200, 600, 250);
		setVisible(true);
		setDefaultCloseOperation(1);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == login) {
			String user = username.getText();
			String pass = password.getText();
			
			try {
				Conn conn = new Conn();
				
				String query = "select * from login where username = '" +user+"' and password = '"+pass+ "'";
				
				ResultSet rs = conn.stmt.executeQuery(query);
				
				if(rs.next()) {
					
					setVisible(false);
					new Dashboard();
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid username or password");
					setVisible(false);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(ae.getSource() == cancel) {
			setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		new Login();

	}
}
