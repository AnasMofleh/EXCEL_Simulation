package view.gui.menu;

import view.StatusLabel;
import model.XL;
import model.XLList;
import controller.LabelController;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class XLMenuBar extends JMenuBar {
        public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, LabelController labelController) {
            JMenu file = new JMenu("File");
            JMenu edit = new JMenu("Edit");
            file.add(new PrintMenuItem(xl, statusLabel));
            file.add(new SaveMenuItem(xl, statusLabel));
            file.add(new LoadMenuItem(xl, statusLabel));
            file.add(new NewMenuItem(xl));
            file.add(new CloseMenuItem(xl, xlList));
            edit.add(new ClearMenuItem(labelController));
            edit.add(new ClearAllMenuItem(labelController));
            add(file);
            add(edit);
            add(new WindowMenu(xlList));
        }
    }
