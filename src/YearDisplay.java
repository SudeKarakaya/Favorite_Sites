import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class YearDisplay extends JFrame {
    private JButton yearButton;
    private JFrame yearFrame;
    private JTextField yearField;
    private JTextArea jTextArea;

    public YearDisplay(){
        setTitle("Year Display Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));
        yearButton = new JButton("Year Display");
        yearFrame = new JFrame("Year:");
        yearField = new JTextField(10);

        add(yearFrame);
        add(yearField);
        add(yearButton);

        yearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from visits where year='"+yearField.getText()+"';");

                    while (resultSet.next()) {

                        String username = resultSet.getString("username");
                        String country_name = resultSet.getString("country_name");
                        String city_name = resultSet.getString("city_name");
                        String year = resultSet.getString("year");
                        String season = resultSet.getString("season");
                        String best_feature = resultSet.getString("best_feature");
                        String comment = resultSet.getString("comment");
                        String rating = resultSet.getString("rating");

                        jTextArea.append(username + "\t" + country_name + "\t" + city_name + "\t" + year +
                                "\t" + season + "\t" + best_feature + "\t" + comment + "\t" + rating + "\n");
                    }
                }catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
