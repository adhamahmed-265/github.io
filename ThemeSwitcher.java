import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeSwitcher extends JPanel implements ActionListener {

    private JButton themeButton;
    private Color lightModeBackground;
    private Color darkModeBackground;
    private boolean isDarkMode;
    private JPanel targetPanel; // The panel whose background will be changed

    public ThemeSwitcher(JPanel panelToControl) {
        lightModeBackground = Color.WHITE;
        darkModeBackground = new Color(30, 30, 30);
        isDarkMode = false;
        targetPanel = panelToControl;

        themeButton = new JButton("Dark Mode");
        themeButton.addActionListener(this);
        this.add(themeButton);

        // Set a default background for the switcher panel itself (optional)
        this.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themeButton) {
            isDarkMode = !isDarkMode;
            updateTheme();
        }
    }

    private void updateTheme() {
        if (isDarkMode) {
            targetPanel.setBackground(darkModeBackground);
            themeButton.setText("Light Mode");
        } else {
            targetPanel.setBackground(lightModeBackground);
            themeButton.setText("Dark Mode");
        }
        targetPanel.repaint(); // Ensure the background change is visible
    }

    // Example of how to integrate this into an existing JFrame
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);
            frame.setLayout(new BorderLayout());

            // This is your main content panel (replace with your actual panel)
            JPanel mainContent = new JPanel();
            mainContent.setBackground(Color.WHITE);
            JLabel label = new JLabel("This is the main content area.");
            mainContent.add(label);
            frame.add(mainContent, BorderLayout.CENTER);

            // Create the ThemeSwitcher panel, passing the main content panel
            ThemeSwitcher themeSwitcherPanel = new ThemeSwitcher(mainContent);
            frame.add(themeSwitcherPanel, BorderLayout.NORTH); // Add it to the top

            frame.setVisible(true);
        });
    }
}