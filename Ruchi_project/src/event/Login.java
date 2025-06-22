package event;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame {
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    public Login() {
        l1 = new JLabel("Name");
        l1.setBounds(50, 90, 120, 30);
        t1 = new JTextField();
        t1.setBounds(150, 90, 150, 30);

        l2 = new JLabel("Password");
        l2.setBounds(50, 140, 120, 30);
        t2 = new JPasswordField();
        t2.setBounds(150, 140, 150, 30);

        b1 = new JButton("LOGIN");
        b1.setBounds(50, 200, 100, 30);

        b2 = new JButton("REGISTER");
        b2.setBounds(200, 200, 120, 30);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String password = new String(t2.getPassword());

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prepare","root","");
                    PreparedStatement ps = con.prepareStatement("select * from event_user where name=? and password=?");
                    ps.setString(1, name);
                    ps.setString(2, password);
                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(b1, "Login Successful!");
                        new Home();  
                        dispose();   
                    } else {
                        JOptionPane.showMessageDialog(b1, "Invalid Credentials. Try again.");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Register();
                dispose();
            }
        });

        add(l1); 
        add(t1);
        add(l2); 
        add(t2);
        add(b1); 
        add(b2);

        setLayout(null);
        setSize(400, 300);
        setVisible(true);
        setTitle("EventEase - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Login();
    }
}
