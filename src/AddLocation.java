import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class AddLocation extends JFrame{

    private JTextField countryField, cityField, yearField, seasonField, bestField, commentField, rateField;
    private JLabel countryLabel, cityLabel, yearLabel, seasonLabel, bestLabel, commentLabel, rateLabel;
    private JButton addButton;
    public AddLocation(){

        setTitle("Add Location Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 4));

        countryLabel = new JLabel("Country Name:");
        cityLabel = new JLabel("City Name:");
        yearLabel = new JLabel("Year:");
        seasonLabel = new JLabel("Season Visited:");
        bestLabel = new JLabel("Best Feature:");
        commentLabel = new JLabel("Comments:");
        rateLabel = new JLabel("Rating:");
        addButton = new JButton("Add The Location");

        countryField = new JTextField(10);
        cityField = new JTextField(10);
        yearField = new JTextField(10);
        seasonField = new JTextField(10);
        bestField = new JTextField(10);
        commentField = new JTextField(10);
        rateField = new JTextField(10);

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

        add(addButton);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addLocation();
            }
        });
    }

    private void addLocation(){
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
            Statement statement = connection.createStatement();
            statement.executeUpdate("Insert into visits values(default, '"
                    +countryField.getText()+ "', '" +cityField.getText() + "', '" +yearField+ "', '"
                    +seasonField+ "', '" +bestField+ "', '" +commentField+ "', '" +rateField+ "');" );

        } catch (Exception e) {
            new SqlException();
        }

    }
}
