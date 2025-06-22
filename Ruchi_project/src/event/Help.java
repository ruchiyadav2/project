package event;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Help extends JFrame {
    JLabel l1;
    JButton back;

    public Help() {
        l1 = new JLabel("Help: Use this app to manage your personal events like meetings and birthdays.");
        l1.setBounds(20, 100, 1000, 30);
        back = new JButton("Back");
        back.setBounds(20, 20, 80, 30);
        back.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Home();  
                dispose();    
            }
        });
        add(l1);
        add(back);

        setSize(450, 300);
        setLayout(null);
        setVisible(true);
        setTitle("Help");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Help();
    }
}

