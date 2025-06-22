package event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class DeleteEvent extends JFrame {
	JLabel l1, l2;
	JTextField t1;
	JButton d1, back;

	public DeleteEvent() {
		l1 = new JLabel("Event Title");
		l2 = new JLabel("DELETE THE EVENT BY TITLE");
		t1 = new JTextField();
		d1 = new JButton("DELETE");
		d1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String title = t1.getText();

				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepare", "root", "");
					PreparedStatement ps = con.prepareStatement("delete from events where title=?");
					ps.setString(1, title);
					ps.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		back = new JButton("Back");
		back.addActionListener((ActionListener) new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Home();
				dispose();
			}
		});

		add(l1);
		add(l2);
		add(t1);
		add(d1);
		add(back);

		l1.setBounds(50, 100, 200, 40);
		l2.setBounds(50, 160, 300, 40);
		t1.setBounds(150, 100, 200, 40);
		d1.setBounds(150, 200, 300, 40);
		back.setBounds(500, 200, 300, 40);

		setLayout(null);
		setSize(400, 400);
		setVisible(true);
		setTitle("Delete Event");
	}

	public static void main(String[] args) {
		new DeleteEvent();
	}
}
