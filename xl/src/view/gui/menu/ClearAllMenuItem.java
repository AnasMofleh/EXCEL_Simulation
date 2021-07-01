package view.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import controller.LabelController;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
    private LabelController labelController;

    public ClearAllMenuItem(LabelController labelController) {
        super("Clear all");
        this.labelController = labelController;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        labelController.clearAll();
    }
}