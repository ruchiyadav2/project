package event;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home extends JFrame {
    JMenuBar mb;
    JMenu menu1, menu2, menu3, menu4;
    JMenuItem addEvent, delEvent, updateEvent, showEvents, searchEvent, todayEvents, help, exit;

    public Home() {
        mb = new JMenuBar();

        
        menu1 = new JMenu("EVENTS");
        addEvent = new JMenuItem("Add Event");
        addEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEvent();
            }
        });

        delEvent = new JMenuItem("Delete Event");
        delEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteEvent();
            }
        });

        updateEvent = new JMenuItem("Update Event");
        updateEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UpdateEvent();
            }
        });

        menu1.add(addEvent);
        menu1.add(delEvent);
        menu1.add(updateEvent);
        mb.add(menu1);

        
        menu2 = new JMenu("VIEW");
        showEvents = new JMenuItem("Show All Events");
        showEvents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowEvent();
            }
        });

        searchEvent = new JMenuItem("Search Event");
        searchEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEvent();
            }
        });

        todayEvents = new JMenuItem("Today's Event");
        todayEvents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TodaysEvent();
            }
        });

        menu2.add(showEvents);
        menu2.add(searchEvent);
        menu2.add(todayEvents);
        mb.add(menu2);

        
        menu3 = new JMenu("HELP");
        help = new JMenuItem("Help");
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Help();
            }
        });
        menu3.add(help);
        mb.add(menu3);

        
        menu4 = new JMenu("EXIT");
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Exit();
                dispose();
            }
        });
        menu4.add(exit);
        mb.add(menu4);

        setJMenuBar(mb);
        JLabel line1 = new JLabel("Welcome to the Event Management System.");
        line1.setBounds(80, 40, 400, 30);
        add(line1);

       

        JLabel line3 = new JLabel("You can add, update, delete, search, or view all events.");
        line3.setBounds(50, 100, 400, 25);
        add(line3);

        JLabel line4 = new JLabel("You can also check events scheduled for today.");
        line4.setBounds(70, 130, 350, 25);
        add(line4);

        JLabel line5 = new JLabel("Use the menu bar above to navigate through options.");
        line5.setBounds(60, 160, 400, 25);
        add(line5);


        setTitle("Events Home Page");
        setLayout(null);
        setSize(500, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Home();
    }
}
