package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import view.gui.ColoredLabel;
import model.CurrentSlot;

public class CurrentLabel extends ColoredLabel implements Observer {
	private String currentAddress = "A1";
	private CurrentSlot currentSlot;

	public CurrentLabel(CurrentSlot currentSlot) {
		super("A1", Color.WHITE);
		this.currentSlot = currentSlot;
		currentSlot.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		currentAddress = currentSlot.getAddress();
		setText(currentAddress);
	}
}
