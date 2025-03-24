package com.hotelmanagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddEmployee extends JFrame implements ActionListener {

	JTextField tfname, tfage, tfsalary, tfphone, tfemail, tfaadhar;
	JButton submit;
	JComboBox cbjob;
	JRadioButton rbmale, rbfemale;

	public AddEmployee() {
		setTitle("New Employees");
		setLayout(null);

		JLabel lblname = new JLabel("NAME");
		lblname.setFont(new Font("Serif", Font.PLAIN, 17));
		lblname.setBounds(60, 30, 120, 30);
		add(lblname);

		tfname = new JTextField();
		tfname.setBounds(200, 30, 150, 30);
		add(tfname);

		JLabel lblage = new JLabel("AGE");
		lblage.setFont(new Font("Serif", Font.PLAIN, 17));
		lblage.setBounds(60, 70, 120, 30);
		add(lblage);

		tfage = new JTextField();
		tfage.setBounds(200, 70, 150, 30);
		add(tfage);

		JLabel lblgender = new JLabel("GENDER");
		lblgender.setFont(new Font("Serif", Font.PLAIN, 17));
		lblgender.setBounds(60, 110, 120, 30);
		add(lblgender);

		rbmale = new JRadioButton("Male");
		rbmale.setBounds(200, 115, 70, 20);
		rbmale.setBackground(Color.WHITE);
		add(rbmale);

		rbfemale = new JRadioButton("Female");
		rbfemale.setBounds(280, 115, 70, 20);
		rbfemale.setBackground(Color.WHITE);
		add(rbfemale);

		JLabel lbljob = new JLabel("JOB");
		lbljob.setFont(new Font("Serif", Font.PLAIN, 17));
		lbljob.setBounds(60, 150, 120, 30);
		add(lbljob);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rbmale);
		bg.add(rbfemale);

		String str[] = { "Front Desk Clerks", "Porters", "Kitchen", "Room Servie", "Chefs", "Waiter/Waitress",
				"Manager", "Accountant" };
		cbjob = new JComboBox(str);
		cbjob.setBackground(Color.WHITE);
		cbjob.setBounds(200, 150, 150, 30);
		add(cbjob);

		JLabel lblsalary = new JLabel("SALARY");
		lblsalary.setFont(new Font("Serif", Font.PLAIN, 17));
		lblsalary.setBounds(60, 190, 120, 30);
		add(lblsalary);

		tfsalary = new JTextField();
		tfsalary.setBounds(200, 190, 150, 30);
		add(tfsalary);

		JLabel lblphone = new JLabel("PHONE");
		lblphone.setFont(new Font("Serif", Font.PLAIN, 17));
		lblphone.setBounds(60, 230, 120, 30);
		add(lblphone);

		tfphone = new JTextField();
		tfphone.setBounds(200, 230, 150, 30);
		add(tfphone);

		JLabel lblemail = new JLabel("EMAIL");
		lblemail.setFont(new Font("Serif", Font.PLAIN, 17));
		lblemail.setBounds(60, 270, 120, 30);
		add(lblemail);

		tfemail = new JTextField();
		tfemail.setBounds(200, 270, 150, 30);
		add(tfemail);

		JLabel lblaadhar = new JLabel("AADHAR");
		lblaadhar.setFont(new Font("Serif", Font.PLAIN, 17));
		lblaadhar.setBounds(60, 310, 120, 30);
		add(lblaadhar);

		tfaadhar = new JTextField();
		tfaadhar.setBounds(200, 310, 150, 30);
		add(tfaadhar);

		submit = new JButton("SUBMIT");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.WHITE);
		submit.setBounds(200, 420, 150, 20);
		submit.addActionListener(this);
		add(submit);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(380, 50, 450, 370);
		add(image);

		getContentPane().setBackground(Color.WHITE);
		setBounds(350, 200, 850, 540);
		setVisible(true);
		setDefaultCloseOperation(1);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String name = tfname.getText();
		String age = tfage.getText();
		String salary = tfsalary.getText();
		String phone = tfphone.getText();
		String email = tfemail.getText();
		String aadhar = tfaadhar.getText();

		String gender = null;
		if (rbmale.isSelected()) {
			gender = "Male";
		} else if (rbfemale.isSelected()) {
			gender = "Female";
		}

		String job = (String) cbjob.getSelectedItem();

		try {
			Conn c = new Conn();

			String query = "insert into employee values('" + name + "','" + age + "','" + gender + "','" + job + "','"
					+ salary + "','" + phone + "','" + email + "','" + aadhar + "')";

			c.stmt.executeUpdate(query);

			JOptionPane.showMessageDialog(null, "Employee added successfully");
			setVisible(false);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new AddEmployee();
	}
}
