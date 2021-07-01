package view;

import model.XLException;
import view.gui.ColoredLabel;
import view.gui.GridPanel;
import view.gui.SlotLabel;
import controller.LabelController;
import javax.swing.SwingConstants;
import java.util.Observable;
import java.util.ArrayList;
import model.CurrentSlot;
import java.util.Observer;
import model.SpreadSheet;
import java.util.List;
import java.awt.*;


public class SlotLabels extends GridPanel implements Observer {
    private CurrentSlot currentSlot;
    private SlotLabel firstLabel;
    private SpreadSheet spreadSheet;
    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols,
                      LabelController labelController,
                      SpreadSheet spreadSheet,
                      CurrentSlot currentSlot) {

        super(rows + 1, cols);
        this.currentSlot = currentSlot;
        this.spreadSheet = spreadSheet;
        currentSlot.addObserver(this);
        spreadSheet.addObserver(this);

        labelList = new ArrayList<>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY, SwingConstants.CENTER));
        }

        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel("" + ch + row);
                add(label);
                labelList.add(label);
            }
        }

        firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
        labelController.setLabelList(labelList);
        currentSlot.setCurrent(firstLabel);
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        changeColors();
        updateText();
    }

    private void updateText() {
        for (SlotLabel sl : labelList) {
            String address = sl.getAddress();
            if (spreadSheet.hasKey(address)) {
                try {
                    String content = spreadSheet.getDisplayContent(address);
                    sl.setText(content);
                } catch (XLException xl){
                    spreadSheet.put(address, "0");

                }
            } else {
                sl.setText("                    ");
            }
        }
    }

    private void changeColors() {
        firstLabel.setBackground(Color.WHITE);
        int index = labelToIndex(currentSlot.getCurrent());
        SlotLabel currLabel = labelList.get(index);
        currLabel.setBackground(Color.YELLOW);
        firstLabel = currLabel;
    }

    private int labelToIndex(SlotLabel slotLabel) {
        return labelList.indexOf(slotLabel);
    }
}
