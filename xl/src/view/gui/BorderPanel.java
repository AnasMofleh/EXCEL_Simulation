package view.gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;

public class BorderPanel extends JPanel {
    protected BorderPanel() {
        super(new BorderLayout(2, 2));
        setBackground(Color.BLACK);
    }
}
