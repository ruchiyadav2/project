package event;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class TodaysEvent extends JFrame {
    JLabel l1, l2;
    JTextField t1;
    JButton b1, back;
    JTextArea area;
    JScrollPane scroll;

    public TodaysEvent() {
        l1 = new JLabel("Enter Today's Date (YYYY-MM-DD)");
        l2 = new JLabel("CLICK TO SHOW TODAY'S EVENTS");
        t1 = new JTextField();
        b1 = new JButton("SHOW EVENTS");
        back = new JButton("Back");

        area = new JTextArea(); 
        scroll = new JScrollPane(area);
        scroll.setBounds(30, 170, 380, 100);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(""); 
                String date = t1.getText();

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepare", "root", "");
                    PreparedStatement ps = con.prepareStatement("select * from events where date=?");
                    ps.setString(1, date);
                    ResultSet rs = ps.executeQuery();

                    boolean found = false;
                    while (rs.next()) {
                        area.append("Title: " + rs.getString("title") + "\n");
                        area.append("Date: " + rs.getString("date") + "\n");
                        area.append("Time: " + rs.getString("time") + "\n");
                        area.append("Description: " + rs.getString("description") + "\n");
                        area.append("------------------------------\n");
                        found = true;
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(b1, "No events found for date: " + date);
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    area.setText("Error while fetching events.");
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
        add(t1);
        add(b1);
        add(l2);
        add(back);
        add(scroll);

        l1.setBounds(50, 60, 250, 30);
        t1.setBounds(280, 60, 100, 30);
        b1.setBounds(100, 120, 150, 30);
        l2.setBounds(80, 20, 300, 30);
        back.setBounds(280, 120, 100, 30);

        setLayout(null);
        setSize(460, 330);
        setVisible(true);
        setTitle("Today's Events");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TodaysEvent();
    }
}
