import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ThemeSwitcherApp extends JFrame implements ActionListener {

    private JButton themeButton;
    private JPanel contentPane;
    private Color lightModeBackground = Color.WHITE;
    private Color lightModeForeground = Color.BLACK;
    private Color darkModeBackground = new Color(30, 30, 30); // Dark gray
    private Color darkModeForeground = new Color(220, 220, 220); // Light gray
    private boolean isDarkMode = false;

    public ThemeSwitcherApp() {
        setTitle("Theme Switcher App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
        setContentPane(contentPane);

        themeButton = new JButton("Switch to Dark Mode");
        themeButton.addActionListener(this);
        contentPane.add(themeButton);

        // Set initial light mode
        applyTheme(lightModeBackground, lightModeForeground, "Switch to Dark Mode");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == themeButton) {
            isDarkMode = !isDarkMode;
            if (isDarkMode) {
                applyTheme(darkModeBackground, darkModeForeground, "Switch to Light Mode");
            } else {
                applyTheme(lightModeBackground, lightModeForeground, "Switch to Dark Mode");
            }
        }
    }

    private void applyTheme(Color background, Color foreground, String buttonText) {
        contentPane.setBackground(background);
        contentPane.setForeground(foreground);
        themeButton.setForeground(foreground);
        themeButton.setBackground(UIManager.getColor("Button.background")); // Use default button background for consistency
        themeButton.setText(buttonText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ThemeSwitcherApp::new);
    }
}