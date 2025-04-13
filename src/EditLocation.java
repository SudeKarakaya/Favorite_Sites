import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class EditLocation extends JFrame {

    private JTextField visitField;
    private JLabel visitLabel;
    private JButton editButton;

    private JTextField countryField, cityField, yearField, seasonField, bestField, commentField, rateField;
    private JLabel countryLabel, cityLabel, yearLabel, seasonLabel, bestLabel, commentLabel, rateLabel;
    private JTextArea jTextArea;
    public EditLocation(){

        setTitle("Edit Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        visitLabel = new JLabel("Id Of Location:");
        visitField = new JTextField(10);
        countryLabel = new JLabel("Country Name:");
        cityLabel = new JLabel("City Name:");
        yearLabel = new JLabel("Year:");
        seasonLabel = new JLabel("Season Visited:");
        bestLabel = new JLabel("Best Feature:");
        commentLabel = new JLabel("Comments:");
        rateLabel = new JLabel("Rating:");
        countryField = new JTextField(10);
        cityField = new JTextField(10);
        yearField = new JTextField(10);
        seasonField = new JTextField(10);
        bestField = new JTextField(10);
        commentField = new JTextField(10);
        rateField = new JTextField(10);
        jTextArea = new JTextArea();

        editButton = new JButton();

        add(visitLabel);
        add(visitField);

        add(countryLabel);
        add(countryField);

        add(cityLabel);
        add(cityField);

        add(yearLabel);
        add(yearField);

        add(seasonLabel);
        add(seasonField);

        add(bestLabel);
        add(bestField);

        add(commentLabel);
        add(commentField);

        add(rateLabel);
        add(rateField);

        add(jTextArea);
        add(editButton);


        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from visits where visit_id='"+visitField.getText()+"';");

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

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("Update visits set country_name = '" +countryField.getText() + "', city_name = '"
                            +cityField.getText()+ "', year = '" +yearField.getText()+ "', season = '"+seasonField.getText()+
                            "', best_feature = '"+bestField.getText()+ "', comment = '"+commentField.getText()+
                            "', rating = '"+rateField.getText()+
                            "'where visit_id = '" +visitField.getText()+ "');" );


                } catch (Exception ex) {
                    new SqlException();
                }
            }
        });

    }
}

