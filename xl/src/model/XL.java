package model;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import view.CurrentLabel;
import view.Editor;
import view.StatusLabel;
import controller.EditorController;
import controller.LabelController;
import view.gui.SheetPanel;
import view.gui.StatusPanel;
import view.gui.menu.XLMenuBar;
import model.Slots.Slot;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private SpreadSheet spreadSheet;
    private XLList xlList;
    private LabelController labelController;
    private EditorController editorController;

    public XL(XL oldXL) {  
        this(oldXL.xlList, oldXL.counter);
    }

    public XL(XLList xlList, XLCounter counter) {
        super("Untitled-" + counter);

        SlotError slotError = new SlotError();
        CurrentSlot currentSlot = new CurrentSlot(slotError);
        spreadSheet = new SpreadSheet(currentSlot, slotError);
        StatusLabel statusLabel = new StatusLabel(slotError);
        CurrentLabel currentLabel = new CurrentLabel(currentSlot);
       
        
        
        Editor editor = new Editor(spreadSheet, currentSlot);
        labelController = new LabelController(spreadSheet, currentSlot);
        editorController = new EditorController(spreadSheet, currentSlot, editor);

        this.xlList = xlList;
        this.counter = counter;
        xlList.add(this);
        counter.increment();

        JPanel statusPanel = new StatusPanel(statusLabel, currentLabel);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, labelController,spreadSheet, currentSlot);

        currentSlot.addObserver(statusLabel);

        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, labelController));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page > 0) return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(g2d);
        return PAGE_EXISTS;
    }

    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    public void loadData(XLBufferedReader reader) {
        labelController.clear();
        spreadSheet.clear();
        reader.load(spreadSheet);
    }

    public Set<Map.Entry<String, Slot>> getData() {
        return spreadSheet.getAllSlots();
    }

    public static void main(String[] args) {
        new XL(new XLList(), new XLCounter());
    }
}
