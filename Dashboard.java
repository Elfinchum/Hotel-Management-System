package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Dashboard extends JFrame implements ActionListener {

	JMenuItem addemployee, addroom, adddriver, reception;

	Dashboard() {
		setTitle("Main Dashboard");

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1550, 820, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1550, 820);
		add(image);

		JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("Serif", Font.PLAIN, 50));
		text.setBounds(370, 30, 1000, 80);
		image.add(text);

		JMenuBar mb = new JMenuBar();
		mb.setBounds(0, 0, 1550, 30);
		image.add(mb);

		JMenu hotel = new JMenu("HOTEL MANAGEMENT");
		hotel.setForeground(Color.DARK_GRAY);
		hotel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mb.add(hotel);

		reception = new JMenuItem("RECEPTION");
		reception.addActionListener(this);
		hotel.add(reception);

		JMenu admin = new JMenu("ADMIN");
		admin.setForeground(Color.DARK_GRAY);
		admin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mb.add(admin);

		addemployee = new JMenuItem("ADD EMPLOYEE");
		addemployee.addActionListener(this);
		admin.add(addemployee);

		addroom = new JMenuItem("ADD ROOM");
		addroom.addActionListener(this);
		admin.add(addroom);

		adddriver = new JMenuItem("ADD DRIVER");
		adddriver.addActionListener(this);
		admin.add(adddriver);

		setBounds(0, 0, 1550, 820);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee();
		} else if (e.getActionCommand().equals("ADD ROOM")) {
			new AddRooms();
		} else if (e.getActionCommand().equals("ADD DRIVER")) {
			new AddDriver();
		} else if (e.getActionCommand().equals("RECEPTION")) {
			new Reception();
		}

	}

	public static void main(String[] args) {

		new Dashboard();

	}

}
