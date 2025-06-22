package event;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ShowEvent extends JFrame {
	JLabel l1;
	JButton b1, back;
	JTextArea area;
	JScrollPane scroll;

	public ShowEvent() {
		l1 = new JLabel("CLICK BELOW TO SHOW ALL EVENTS");
		l1.setBounds(50, 20, 300, 30);

		b1 = new JButton("SHOW EVENTS");
		b1.setBounds(50, 60, 130, 30);

		back = new JButton("Back");
		back.setBounds(200, 60, 100, 30);

		area = new JTextArea();
		scroll = new JScrollPane(area);
		scroll.setBounds(30, 110, 320, 140);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("");
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepare", "root", "");
					PreparedStatement ps = con.prepareStatement("select * from  events");
					ResultSet rs = ps.executeQuery();

					while (rs.next()) {
						area.append("ID: " + rs.getInt(1) + "\n");
						area.append("User ID: " + rs.getInt(2) + "\n");
						area.append("Title: " + rs.getString(3) + "\n");
						area.append("Date: " + rs.getString(4) + "\n");
						area.append("Time: " + rs.getString(5) + "\n");
						area.append("Description: " + rs.getString(6) + "\n");
						area.append("------------------------------\n");
					}

				} catch (SQLException ex) {
					ex.printStackTrace();

				}
			}
		});

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home();
				dispose();
			}
		});

		add(l1);
		add(b1);
		add(back);
		add(scroll);

		setLayout(null);
		setSize(400, 320);
		setVisible(true);
		setTitle("Show Events");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new ShowEvent();
	}
}
