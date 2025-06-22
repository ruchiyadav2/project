package event;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class AddEvent extends JFrame {
    JLabel l1, l2, l3, l4, heading;
    JTextField t1, t2, t3, t4;
    JButton b1,back;

    public AddEvent() {
        heading = new JLabel("ADD NEW EVENT DETAILS BELOW");
        heading.setBounds(80, 30, 300, 30);

        l1 = new JLabel("Title");
        l1.setBounds(50, 80, 120, 30);
        t1 = new JTextField();
        t1.setBounds(150, 80, 200, 30);

        l2 = new JLabel("Date (YYYY-MM-DD)");
        l2.setBounds(50, 130, 120, 30);
        t2 = new JTextField();
        t2.setBounds(200, 130, 150, 30);

        l3 = new JLabel("Time (HH:MM)");
        l3.setBounds(50, 180, 120, 30);
        t3 = new JTextField();
        t3.setBounds(150, 180, 200, 30);

        l4 = new JLabel("Description");
        l4.setBounds(50, 230, 120, 30);
        t4 = new JTextField();
        t4.setBounds(150, 230, 200, 30);

        b1 = new JButton("ADD EVENT");
        b1.setBounds(130, 300, 150, 30);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = t1.getText();
                String date = t2.getText();
                String time = t3.getText();
                String description = t4.getText();

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepare","root","");
                    PreparedStatement ps = con.prepareStatement("insert into events (title, date, time, description) values (?, ?, ?, ?)");
                    ps.setString(1, title);
                    ps.setString(2, date);
                    ps.setString(3, time);
                    ps.setString(4, description);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(b1, "Event Added Successfully!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(b1, "Error while adding event!");
                }
            }
        });
        back = new JButton("Back");
        back.setBounds(300, 300, 150, 30);
        back.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();  
                dispose();    
            }
        });

        add(heading);
        add(l1); 
        add(t1);
        add(l2); 
        add(t2);
        add(l3); 
        add(t3);
        add(l4);
        add(t4);
        add(b1);
        add(back);

        setLayout(null);
        setSize(450, 400);
        setVisible(true);
        setTitle("Add Event");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AddEvent();
    }
}

