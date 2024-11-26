package software.ulpgc.app.windows;

import software.ulpgc.architecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame{
    private final Map<String, Command> commands;
    private JFreeBarchartDisplay display;

    public MainFrame() throws HeadlessException {
        this.setTitle("Kata 3");
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(BorderLayout.NORTH, menu());
        this.add(display = statisticPanel());
        commands = new HashMap<>();
    }

    private JFreeBarchartDisplay statisticPanel() {
        return new JFreeBarchartDisplay();
    }

    public Command put(String key, Command value) {
        return commands.put(key, value);
    }

    public JFreeBarchartDisplay getDisplay() {
        return display;
    }

    private Component menu() {
        JPanel panel = new JPanel();
        panel.add(toogle());
        return panel;
    }

    private Component toogle() {
        JButton button = new JButton("Toogle");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Toogle").execute();
            }
        });
        return button;
    }
}
