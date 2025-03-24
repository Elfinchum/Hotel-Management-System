package com.hotelmanagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reception extends JFrame implements ActionListener {

	JButton newCustomer, rooms, 
	department, allEmployee, 
	manager, customerInfo, 
	search, update, 
	roomStatus, pickUp, 
	checkOut, logout;

	Reception() {

		setTitle("Reception");
		getContentPane().setBackground(Color.white);
		setLayout(null);

		newCustomer = new JButton("New Customer Form");
		newCustomer.setBounds(10, 30, 200, 30);
		newCustomer.setBackground(Color.black);
		newCustomer.setForeground(Color.white);
		newCustomer.addActionListener(this);
		add(newCustomer);

		rooms = new JButton("Rooms");
		rooms.setBounds(10, 70, 200, 30);
		rooms.setBackground(Color.black);
		rooms.setForeground(Color.white);
		rooms.addActionListener(this);
		add(rooms);

		department = new JButton("Departments");
		department.setBounds(10, 110, 200, 30);
		department.setBackground(Color.black);
		department.setForeground(Color.white);
		department.addActionListener(this);
		add(department);

		allEmployee = new JButton("All Employees");
		allEmployee.setBounds(10, 150, 200, 30);
		allEmployee.setBackground(Color.black);
		allEmployee.setForeground(Color.white);
		allEmployee.addActionListener(this);
		add(allEmployee);

		customerInfo = new JButton("Customer Info");
		customerInfo.setBounds(10, 190, 200, 30);
		customerInfo.setBackground(Color.black);
		customerInfo.setForeground(Color.white);
		customerInfo.addActionListener(this);
		add(customerInfo);

		manager = new JButton("Manager Info");
		manager.setBounds(10, 230, 200, 30);
		manager.setBackground(Color.black);
		manager.setForeground(Color.white);
		manager.addActionListener(this);
		add(manager);

		checkOut = new JButton("Checkout");
		checkOut.setBounds(10, 270, 200, 30);
		checkOut.setBackground(Color.black);
		checkOut.setForeground(Color.white);
		checkOut.addActionListener(this);
		add(checkOut);

		update = new JButton("Upadate Status");
		update.setBounds(10, 310, 200, 30);
		update.setBackground(Color.black);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);

		roomStatus = new JButton("Room Status");
		roomStatus.setBounds(10, 350, 200, 30);
		roomStatus.setBackground(Color.black);
		roomStatus.setForeground(Color.white);
		roomStatus.addActionListener(this);
		add(roomStatus);

		pickUp = new JButton("Pickup Service");
		pickUp.setBounds(10, 390, 200, 30);
		pickUp.setBackground(Color.black);
		pickUp.setForeground(Color.white);
		pickUp.addActionListener(this);
		add(pickUp);

		search = new JButton("Search Rooms");
		search.setBounds(10, 430, 200, 30);
		search.setBackground(Color.black);
		search.setForeground(Color.white);
		search.addActionListener(this);
		add(search);

		logout = new JButton("Logout");
		logout.setBounds(10, 470, 200, 30);
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		add(logout);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		JLabel image = new JLabel(i1);
		image.setBounds(250, 30, 500, 470);
		add(image);

		setBounds(350, 200, 800, 570);
		setVisible(true);
		setDefaultCloseOperation(1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Customer Form")) {
			setVisible(false);
			new AddCustomer();
		} else if (e.getActionCommand().equals("Rooms")) {
			setVisible(false);
			new Room();
		} else if (e.getActionCommand().equals("Departments")) {
			setVisible(false);
			new Department();
		} else if (e.getActionCommand().equals("All Employees")) {
			setVisible(false);
			new EmployeeInfo();
		} else if (e.getActionCommand().equals("Manager Info")) {
			setVisible(false);
			new ManagerInfo();
		} else if (e.getActionCommand().equals("Customer Info")) {
			setVisible(false);
			new CustomerInfo();
		} else if (e.getSource() == update) {
			setVisible(false);
			new UpdateCheck();
		} else if (e.getSource() == roomStatus) {
			setVisible(false);
			new UpdateRoom();
		} else if (e.getSource() == pickUp) {
			setVisible(false);
			new Pickup();
		}else if (e.getSource() == checkOut) {
			setVisible(false);
			new Checkout();
		}else if (e.getSource() == logout) {
			setVisible(false);
			System.exit(0);
		}
	}

	public static void main(String[] args) {

		new Reception();

	}

}
