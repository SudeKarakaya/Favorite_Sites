import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShareOption extends JFrame {

    JLabel fUsernameLabel, visitLabel, usernameLabel;
    JTextField fUsernameField, visitField, usernameField;
    JButton shareButton, displayButton;
    private JTextArea jTextArea;
    public ShareOption(){
        setTitle("Share Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));
        fUsernameLabel = new JLabel("Friend Username:");
        fUsernameField = new JTextField(10);
        visitLabel = new JLabel("Visit ID:");
        visitField = new JTextField(10);
        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(10);
        shareButton = new JButton("Share");
        displayButton = new JButton("Display");
        jTextArea = new JTextArea();

        add(fUsernameLabel);
        add(fUsernameField);

        add(visitLabel);
        add(visitField);

        add(usernameLabel);
        add(usernameField);

        add(shareButton);
        add(displayButton);

        add(jTextArea);

        shareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("Insert into shared_visits values('"
                            +fUsernameField.getText()+ "', '" +visitField.getText() + "', '" +usernameField+ "');" );

                } catch (Exception ex) {
                    new SqlException();
                }

            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("Select country_name, city_name, season, " +
                            "best_feature from visits, shared_visits where username='"+usernameField.getText()+ "' and friend_username='"
                            +fUsernameField.getText()+ "' and visit_id= '" +visitField.getText()+"' " +
                            "and visits.username = shared_visits.username;");
                    while (resultSet.next()) {

                        String countryName = resultSet.getString("country_name");
                        String cityName = resultSet.getString("city_name");
                        String season = resultSet.getString("season");
                        String Bestfeature = resultSet.getString("best_feature");

                        jTextArea.append(countryName+"\t"+cityName+"\t"+season+"\t"+Bestfeature+"\n");

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
