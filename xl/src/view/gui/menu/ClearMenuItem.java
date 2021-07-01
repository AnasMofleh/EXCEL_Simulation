package view.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import controller.LabelController;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private LabelController labelController;

    public ClearMenuItem(LabelController labelController) {
        super("Clear");
        this.labelController = labelController;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        labelController.clear();

    }
}