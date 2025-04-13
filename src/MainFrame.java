import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton displayButton;
    private JButton shareButton;
    public MainFrame(){
        setTitle("Main Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 4));
        addButton = new JButton("Add a location");
        editButton = new JButton("Edit a location");
        displayButton = new JButton("Display info");
        shareButton = new JButton("Share a location");
        deleteButton = new JButton("Delete a location");

        add(addButton);
        add(deleteButton);
        add(editButton);
        add(displayButton);
        add(shareButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddLocation().setVisible(true);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DeleteOption().setVisible(true);
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EditLocation().setVisible(true);
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Display().setVisible(true);

            }
        });

        shareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ShareOption().setVisible(true);
            }
        });

    }


}
