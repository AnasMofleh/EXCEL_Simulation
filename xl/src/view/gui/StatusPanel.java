package view.gui;

import view.CurrentLabel;
import view.StatusLabel;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

public class StatusPanel extends BorderPanel {
    public StatusPanel(StatusLabel statusLabel, CurrentLabel currentLabel) {
        add(WEST, currentLabel);
        add(CENTER, statusLabel);
    }
}