package com.hotelmanagement;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener {

	JComboBox comboId;
	JTextField tfnumber, tfname, tfcountry, tfdeposit;
	JRadioButton rmale, rfemale;
	Choice croom;
	JLabel checkintime;
	JButton add, back;

	public AddCustomer() {
		setTitle("Add Customer");
		getContentPane().setBackground(Color.white);
		setLayout(null);

		JLabel text = new JLabel("NEW CUSTOMER FORM");
		text.setBounds(100, 20, 300, 30);
		text.setFont(new Font("Raleway", Font.BOLD, 18));
		add(text);

		JLabel lblid = new JLabel("ID");
		lblid.setBounds(35, 80, 100, 20);
		lblid.setFont(new Font("Raleway", Font.PLAIN, 18));
		lblid.setBackground(Color.white);
		add(lblid);

		String idOption[] = { "Aadhar Card", "Passport", "Driving License", "Voter-id Card", "Raashan Card" };
		comboId = new JComboBox(idOption);
		comboId.setBounds(200, 80, 150, 25);
		comboId.setBackground(Color.white);
		add(comboId);

		JLabel lblnumber = new JLabel("NUMBER");
		lblnumber.setBounds(35, 120, 100, 20);
		lblnumber.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(lblnumber);

		tfnumber = new JTextField();
		tfnumber.setBounds(200, 120, 150, 25);
		add(tfnumber);

		JLabel lblname = new JLabel("NAME");
		lblname.setBounds(35, 160, 100, 20);
		lblname.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(lblname);

		tfname = new JTextField();
		tfname.setBounds(200, 160, 150, 25);
		add(tfname);

		JLabel lblgender = new JLabel("GENDER");
		lblgender.setBounds(35, 200, 100, 20);
		lblgender.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(lblgender);

		rmale = new JRadioButton("Male");
		rmale.setBackground(Color.white);
		rmale.setBounds(200, 200, 60, 25);
		add(rmale);

		rfemale = new JRadioButton("Female");
		rfemale.setBackground(Color.white);
		rfemale.setBounds(270, 200, 70, 25);
		add(rfemale);

		JLabel lblcountry = new JLabel("COUNTRY");
		lblcountry.setBounds(35, 240, 100, 20);
		lblcountry.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(lblcountry);

		tfcountry = new JTextField();
		tfcountry.setBounds(200, 240, 150, 25);
		add(tfcountry);

		JLabel lblroom = new JLabel("Room Number");
		lblroom.setBounds(35, 280, 120, 20);
		lblroom.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(lblroom);

		croom = new Choice();
		try {
			Conn conn = new Conn();
			String query = "select * from room where availability='Available'";
			ResultSet rs = conn.stmt.executeQuery(query);
			while (rs.next()) {
				croom.add(rs.getString("roomnumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		croom.setBounds(200, 280, 150, 25);
		add(croom);

		JLabel lbltime = new JLabel("Checkin Time");
		lbltime.setBounds(35, 320, 120, 20);
		lbltime.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(lbltime);

		Date date = new Date();

		checkintime = new JLabel(" " + date);
		checkintime.setBounds(200, 320, 150, 25);
		checkintime.setFont(new Font("Raleway", Font.PLAIN, 10));
		add(checkintime);

		JLabel lbldeposit = new JLabel("DEPOSIT");
		lbldeposit.setBounds(35, 360, 100, 20);
		lbldeposit.setFont(new Font("Raleway", Font.PLAIN, 18));
		add(lbldeposit);

		tfdeposit = new JTextField();
		tfdeposit.setBounds(200, 360, 150, 25);
		add(tfdeposit);

		add = new JButton("ADD");
		add.setBackground(Color.BLACK);
		add.setForeground(Color.white);
		add.setBounds(50, 410, 120, 30);
		add.addActionListener(this);
		add(add);

		back = new JButton("BACK");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.white);
		back.setBounds(200, 410, 120, 30);
		back.addActionListener(this);
		add(back);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
		Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 50, 300, 400);
		add(image);

		setBounds(350, 200, 800, 550);
		setVisible(true);
		setDefaultCloseOperation(1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add) {

			String id = (String) comboId.getSelectedItem();
			String number = tfnumber.getText();
			String name = tfname.getText();
			String gender = null;

			if (rmale.isSelected()) {
				gender = "Male";
			} else {
				gender = "Female";
			}
			String country = tfcountry.getText();
			String room = croom.getSelectedItem();
			String time = checkintime.getText();
			String deposit = tfdeposit.getText();

			try {
				String query1 = "insert into customer values('" + id + "','" + number + "','" + name + "','" + gender
						+ "','" + country + "','" + room + "','" + time + "','" + deposit + "')";
				
				String query2 = "update room set availability ='Occupied' where roomnumber = '"+room+"'";
				
				Conn conn = new Conn();
				
				conn.stmt.executeUpdate(query1);
				conn.stmt.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
				setVisible(false);
				new Reception();
				

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} else if (e.getSource() == back) {
			setVisible(false);
			new Reception();
		}

	}

	public static void main(String[] args) {
		new AddCustomer();
	}

}
