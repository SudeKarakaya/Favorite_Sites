import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteOption extends JFrame {

    private JTextField visitField;
    private JLabel visitLabel;
    private JButton deleteButton;
    private JTextArea jTextArea;
    public DeleteOption(){
        setTitle("Delete Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        visitLabel = new JLabel("Id Of Location:");
        visitField = new JTextField(10);
        jTextArea = new JTextArea();

        deleteButton = new JButton();

        add(visitLabel);
        add(visitField);
        add(jTextArea);
        add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/project", "root", "12345678");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("Delete from visits where visit_id = '" +visitField.getText()+ "');" );

                    jTextArea.append("Row has been deleted.");

                } catch (Exception ex) {
                    new SqlException();
                }
            }
        });

    }
}

