import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Display extends JFrame{

    private JButton foodButton;
    private JButton imageButton;
    private JButton yearButton;
    private JButton mostButton;
    private JButton springButton;

    private JTextArea jTextArea, jTextArea1, jTextArea2;
    public Display(){
        setTitle("Display Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));
        foodButton = new JButton("Best features are food Display");
        imageButton = new JButton("Image Display");
        yearButton = new JButton("Year Display");
        mostButton = new JButton("Most Visited Display");
        springButton = new JButton("Spring Display");

        add(foodButton);
        add(imageButton);
        add(yearButton);
        add(mostButton);
        add(springButton);

        foodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("Select country_name from visits where best_feature = food " +
                            "order by rating" );
                    while (resultSet.next()) {

                        String countryName = resultSet.getString("country_name");

                        jTextArea.append(countryName+"\n");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ImageDisplay().setVisible(true);
            }
        });

        yearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new YearDisplay().setVisible(true);
            }
        });

        mostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("Select country_name from visits where username = ' " +
                            LoginFrame.getUserName() +"' and country_name = max(country_name)");
                    while (resultSet.next()) {

                        String countryName = resultSet.getString("country_name");

                        jTextArea1.append(countryName+"\n");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        springButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("Select country_name from visits where season =spring");
                    while (resultSet.next()) {

                        String countryName = resultSet.getString("country_name");

                        jTextArea2.append(countryName+"\n");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
