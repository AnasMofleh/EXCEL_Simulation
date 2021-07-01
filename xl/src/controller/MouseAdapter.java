package controller;

import java.awt.event.MouseEvent;
import model.CurrentSlot;
import view.gui.SlotLabel;

public class MouseAdapter extends java.awt.event.MouseAdapter {
    private CurrentSlot currentSlot;
    private SlotLabel slotLabel;

    public MouseAdapter(SlotLabel slotLabel, CurrentSlot currentSlot) {
        this.currentSlot = currentSlot;
        this.slotLabel = slotLabel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        currentSlot.setCurrent(slotLabel);
    }

}