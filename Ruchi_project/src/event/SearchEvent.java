package event;

import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SearchEvent extends JFrame {
    JLabel l1, l2;
    JTextField t1;
    JButton b1, back;
    JTextArea area;
    JScrollPane scroll;

    public SearchEvent() {
        l1 = new JLabel("Enter Event Title");
        l2 = new JLabel("Search Event by Title");
        t1 = new JTextField();
        b1 = new JButton("SEARCH");
        back = new JButton("Back");

        area = new JTextArea();  
        scroll = new JScrollPane(area);
        scroll.setBounds(30, 180, 320, 100);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(""); 
                String title = t1.getText();

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepare", "root", "");
                    PreparedStatement ps = con.prepareStatement("select * from events where title=?");
                    ps.setString(1, title);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        area.append("Title: " + rs.getString("title") + "\n");
                        area.append("Date: " + rs.getString("date") + "\n");
                        area.append("Time: " + rs.getString("time") + "\n");
                        area.append("Description: " + rs.getString("description") + "\n");
                        JOptionPane.showMessageDialog(b1, "Event found: " + title);
                    } else {
                        JOptionPane.showMessageDialog(b1, "No event found with title: " + title);
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
        add(t1);
        add(b1);
        add(l2);
        add(back);
        add(scroll);

        l1.setBounds(50, 80, 150, 30);
        t1.setBounds(180, 80, 150, 30);
        b1.setBounds(100, 130, 150, 30);
        l2.setBounds(80, 30, 250, 30);
        back.setBounds(270, 130, 100, 30);

        setLayout(null);
        setSize(400, 350);
        setVisible(true);
        setTitle("Search Event");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SearchEvent();
    }
}
