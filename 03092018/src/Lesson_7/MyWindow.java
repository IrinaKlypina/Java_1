package Lesson_7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MyWindow extends JFrame {

    private JLabel lbl;
    
    public MyWindow() {
        setTitle("SWING_DZ");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        lbl = new JLabel();

        JButton jbt = new JButton("INSERT");

        setLayout(new BorderLayout());

        add(lbl, BorderLayout.NORTH);
        add(jbt, BorderLayout.SOUTH);

        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertDataWindow(MyWindow.this);
            }
        });

        setBounds(300, 300, 400, 400);
        setVisible(true);
    }
    
    public void setLabel(String text){
        lbl.setText(text);
    }
}

class InsertDataWindow extends JFrame{
    public InsertDataWindow(MyWindow window){
        setTitle("INSERT_DATA");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(3, 2));
        
        JTextField surname = new JTextField();
        JTextField name = new JTextField();
        JTextField patronymic = new JTextField();
        
        panel.add(new JLabel("Surname:"));
        panel.add(surname);
        panel.add(new JLabel("Name:"));
        panel.add(name);
        panel.add(new JLabel("Patronymic:"));
        panel.add(patronymic);
        
        JButton jbt = new JButton("Ok");

        setLayout(new BorderLayout());

        add(panel, BorderLayout.NORTH);
        add(jbt, BorderLayout.SOUTH);

        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setLabel(surname.getText() + " " + name.getText() + " " + patronymic.getText());
                dispose();
            }
        });

        setBounds(400, 200, 400, 400);
        setVisible(true);
    }

}

class MainClassWindow {

    public static void main(String[] args) {
        new MyWindow();
    }
}
