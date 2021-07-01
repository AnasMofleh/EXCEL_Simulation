package model;

import java.util.Observable;

import view.gui.SlotLabel;

public class CurrentSlot extends Observable {
	private SlotLabel slotLabel;
	private String address;
	private SlotError slotError;

	public CurrentSlot(SlotError slotError) {
		this.slotError = slotError;
	}

	public void setCurrent(SlotLabel newLabel) {
		this.slotLabel = newLabel;
		address = slotLabel.getAddress();
		slotError.clear();
		updated();
	}

	public SlotLabel getCurrent() {
		return slotLabel;
	}

	public String getAddress() {
		return address;
	}

	private void updated() {
		setChanged();
		notifyObservers();
	}

}
