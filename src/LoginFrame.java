
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame{


    private static JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel nameLabel, passwordLabel;
    private JButton loginButton;
    private javax.swing.JTextArea textArea;

    public LoginFrame() {

        setTitle("Login Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));
        nameLabel = new JLabel("Name:");
        usernameField = new JTextField(10);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(10);
        textArea = new JTextArea();
        loginButton = new JButton("Login");

        add(nameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(textArea);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    login();
            }
        });

    }

    private void login(){
        dispose();
        new MainFrame().setVisible(true);
    }

    public static String getUserName(){
        return usernameField.getText();
    }


}
