package model;

import controller.LabelController;
import model.factories.ExpressionFactory;
import model.factories.CommentFactory;
import java.util.Observable;
import model.Slots.CommentSlot;
import java.util.HashMap;
import model.expr.Environment;

import java.util.Map;
import java.util.Set;
import model.Slots.Slot;

public class SpreadSheet extends Observable implements Environment {
    private Map<String, Slot> spreadSheet;
	private CurrentSlot currentSlot;
	private SlotError slotError;

	public SpreadSheet(CurrentSlot currentSlot, SlotError slotError) {
		this.spreadSheet = new HashMap<String, Slot>();
		this.slotError = slotError;
		this.currentSlot = currentSlot;
	}

	public void put(String address, String content) {
		try {
			Slot tempSlot = createSlot(content);
			testCircularDependency(address, tempSlot); //test if there is a circular dependency.
			
			spreadSheet.put(address, tempSlot);
			testValidExpression(address); // Tests if the entered expression a valid arithmetic expression.
			
			changed();

		} catch (XLException inputException) {
			slotError.setSlotError("  " + inputException.getMessage());
		}

	}

	
	private void testCircularDependency(String address, Slot slot) throws XLException{

		if(address.equalsIgnoreCase(slot.toString())) {
			throw new XLException("Invalid reference, reference to itself.");
		}

		String referencedSlot = slot.toString();

		if( spreadSheet.get(referencedSlot)!= null) {
			testCircularDependency(address, spreadSheet.get(referencedSlot));
		}
		

	}
	
	private void testValidExpression(String address) throws XLException {
		try {
			getContent(address);
			getDisplayContent(address);
		} catch (XLException expressionException) {
			spreadSheet.remove(address);
			throw expressionException;
		}
	}
	
	private Slot createSlot(String content) throws XLException {
		if (content.charAt(0) == '#')
			return new CommentFactory().createSlot(content);
		else {
			return new ExpressionFactory().createSlot(content);
		}
	}

	public void changed() {
		setChanged();
		notifyObservers();
	}

	public void remove() {
		spreadSheet.remove(currentSlot.getAddress());
		changed();
	}

	public void clear() {
		spreadSheet.clear();
		changed();
	}

	public boolean hasKey(String address) {
		return spreadSheet.containsKey(address);
	}

	public String getContent(String address) {
		Slot slot = spreadSheet.get(address);
		if (slot == null) {
			return "";

		} else if (slot instanceof CommentSlot) {
			return slot.toString();
		} else {
			return Double.toString(slot.value(this));
		}

	}

	public String getDisplayContent(String address) {
		Slot slot = spreadSheet.get(address);
		if (slot == null) {
			return "";
		} else {
			return slot.displayString(this);
		}

	}

	@Override
	public double value(String name) {
		try {
			return spreadSheet.get(name).value(this);
		} catch (Exception e) {
			return 0;

		}
	}


	public String getSlot(String content){
		Slot s = spreadSheet.get(content);
		if (s != null){
			return s.toString();
		} else return "";
	}

	public void clearSlotError() {
		slotError.clear();
	}

	public Set<Map.Entry<String, Slot>> getAllSlots() {
		return spreadSheet.entrySet();
	}
}
