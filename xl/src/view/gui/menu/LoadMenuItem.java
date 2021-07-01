package view.gui.menu;

import view.StatusLabel;
import model.XL;
import model.XLBufferedReader;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {

    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");

    }

    protected void action(String path) throws FileNotFoundException {
        XLBufferedReader xlBufferedReader = new XLBufferedReader(path);
        xl.loadData(xlBufferedReader);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}