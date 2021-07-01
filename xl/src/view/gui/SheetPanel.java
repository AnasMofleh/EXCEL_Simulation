package view.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import controller.LabelController;
import view.SlotLabels;
import model.CurrentSlot;
import model.SpreadSheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, LabelController labelController, SpreadSheet spreadSheet, CurrentSlot currentSlot) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, labelController, spreadSheet, currentSlot));
    }
}