package event;


import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateEvent extends JFrame {
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4;
    JButton b1,back;

    public UpdateEvent() {
        l1 = new JLabel("Title");
        l2 = new JLabel("Date (YYYY-MM-DD)");
        l3 = new JLabel("Time (HH:MM)");
        l4 = new JLabel("Description");
        l5 = new JLabel("UPDATE EVENT DETAILS BASED ON TITLE");

        t1 = new JTextField(); 
        t2 = new JTextField(); 
        t3 = new JTextField(); 
        t4 = new JTextField(); 

        b1 = new JButton("UPDATE");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = t1.getText();
                String date = t2.getText();
                String time = t3.getText();
                String description = t4.getText();

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepare","root","");

                    PreparedStatement d = con.prepareStatement("update events set date=? where title=?");
                    d.setString(1, date);
                    d.setString(2, title);
                    d.executeUpdate();

                    PreparedStatement t = con.prepareStatement("update events set time=? where title=?");
                    t.setString(1, time);
                    t.setString(2, title);
                    t.executeUpdate();

                    PreparedStatement des = con.prepareStatement("update events set description=? where title=?");
                    des.setString(1, description);
                    des.setString(2, title);
                    des.executeUpdate();

                    JOptionPane.showMessageDialog(b1, "Event Updated Successfully!");

                } catch (SQLException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(b1, "Error while updating.");
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
        add(t1);
        add(l2); 
        add(t2);
        add(l3); 
        add(t3);
        add(l4); 
        add(t4);
        add(l5);
        add(b1);
        add(back);

        
        l1.setBounds(50, 50, 200, 30);
        t1.setBounds(180, 50, 200, 30);
        l2.setBounds(50, 100, 200, 30);
        t2.setBounds(180, 100, 200, 30);
        l3.setBounds(50, 150, 200, 30);
        t3.setBounds(180, 150, 200, 30);
        l4.setBounds(50, 200, 200, 30);
        t4.setBounds(180, 200, 200, 30);
        l5.setBounds(50, 10, 400, 30);
        b1.setBounds(150, 270, 120, 30);
        back.setBounds(320, 270, 120, 30);
        

        setLayout(null);
        setSize(450, 400);
        setVisible(true);
        setTitle("Update Event");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new UpdateEvent();
    }
}

