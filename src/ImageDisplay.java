import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageDisplay extends JFrame {

    private JTextField visitField;
    private JLabel visitLabel;
    private JButton imageButton;
    private JLabel imageLabel;
    public ImageDisplay(){
        setTitle("Image Display Frame");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10, 2));

        visitLabel = new JLabel("Id Of Location:");
        visitField = new JTextField(10);
        imageLabel = new JLabel("Image");

        imageButton = new JButton();

        add(visitLabel);
        add(visitField);
        add(imageButton);

        imageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ImageIcon icon = new ImageIcon(Images.getImagePath());
                Image images = icon.getImage();
                Image scaledImage = images.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Images.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(String.valueOf(scaledImage)));
                imageLabel.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
            }
        });
    }


}
