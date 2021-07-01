package view.gui.menu;

import view.StatusLabel;
import model.XL;
import model.XLPrintStream;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

class SaveMenuItem extends OpenMenuItem {

    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {

        XLPrintStream writer = new XLPrintStream(path);
        writer.save(xl.getData());

    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}