package model.Slots;


import model.expr.Environment;

public interface Slot {

	String displayString(Environment env); //Used for displaying in the view.gui
	
    String toString(); //the actual value as a string

	double value(Environment env); //the value if it exists.
}
