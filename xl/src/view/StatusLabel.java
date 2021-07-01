package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import view.gui.ColoredLabel;
import model.SlotError;

public class StatusLabel extends ColoredLabel implements Observer {
    private SlotError slotError;
    
    public StatusLabel(SlotError slotError) {
        super("", Color.WHITE);
        this.slotError = slotError;
        slotError.addObserver(this);
    }

    public void update(Observable observable, Object object) {
    	setText(slotError.getSlotError());
    }
}