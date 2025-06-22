package event;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Register extends JFrame {
    JLabel l1, l2, l3, l4;
    JTextField t1, t2, t3, t4;
    JButton b1,b2;

    public Register() {
        l1 = new JLabel("Name");
        l1.setBounds(50, 90, 120, 30);
        t1 = new JTextField();
        t1.setBounds(150, 90, 150, 30);

        l2 = new JLabel("Contact");
        l2.setBounds(50, 140, 120, 30);
        t2 = new JTextField();
        t2.setBounds(150, 140, 150, 30);

        l3 = new JLabel("Password");
        l3.setBounds(50, 190, 120, 30);
        t3 = new JTextField();
        t3.setBounds(150, 190, 150, 30);

        l4 = new JLabel("Email");
        l4.setBounds(50, 240, 120, 30);
        t4 = new JTextField();
        t4.setBounds(150, 240, 150, 30);

        b1 = new JButton("REGISTER");
        b1.setBounds(120, 300, 120, 30);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                long contact = Long.parseLong(t2.getText());
                String password = t3.getText();
                String email = t4.getText();
                if (name.equals("") || password.equals("") || email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                    return;
                }

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepare","root","");
                    PreparedStatement ps = con.prepareStatement("insert into event_user(name, contact, password, email) values (?, ?, ?, ?)");
                    ps.setString(1, name);
                    ps.setLong(2, contact);
                    ps.setString(3, password);
                    ps.setString(4, email);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(b1, "Registration Successful!");
                    new Login();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        b2 = new JButton("RESET");
        b2.setBounds(250, 300, 120, 30);
        b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				
				
			}
		});

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(l4); add(t4);
        add(b1); add(b2);

        setLayout(null);
        setSize(400, 400);
        setVisible(true);
        setTitle("Event Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Register();
    }
}
