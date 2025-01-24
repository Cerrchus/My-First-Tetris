package main;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class StartWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartWindow frame = new StartWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public StartWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 497, 337);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null); // Use absolute positioning
        setContentPane(contentPane);

        // Set the background image
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setBounds(0, 0, 497, 337);
        ImageIcon backgroundIcon = new ImageIcon(StartWindow.class.getResource("/images/imgInicio.jpg"));
        Image scaledImage = backgroundIcon.getImage().getScaledInstance(497, 337, Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(scaledImage));
        contentPane.add(backgroundLabel);

        // Create the "Play" button with an image
        ImageIcon playIcon = new ImageIcon(StartWindow.class.getResource("/images/imgPlay.png"));
        Image scaledPlayIcon = playIcon.getImage().getScaledInstance(100, 40, Image.SCALE_SMOOTH);
        JButton playButton = new JButton(new ImageIcon(scaledPlayIcon));
        playButton.setBounds(200, 250, 100, 40);
        playButton.setBorderPainted(false); // Remove button border
        playButton.setContentAreaFilled(false); // Make the button background transparent
        contentPane.add(playButton);

        // Add ActionListener to the button
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.main(new String[]{}); // Call the main method of Main
                dispose(); // Close the current window
            }
        });

        // Ensure the background label is drawn behind other components
        contentPane.add(backgroundLabel);
    }
}
