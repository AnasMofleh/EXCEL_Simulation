package view;

import javax.swing.JTextField;
import java.util.Observable;
import model.CurrentSlot;
import model.SpreadSheet;
import java.util.Observer;
import java.awt.Color;


public class Editor extends JTextField implements Observer{
	private SpreadSheet spreadSheet;
	private CurrentSlot currentSlot;
	
    public Editor(SpreadSheet spreadSheet, CurrentSlot currentSlot) {
        setBackground(Color.WHITE);
        this.spreadSheet = spreadSheet;
        this.currentSlot = currentSlot;
        spreadSheet.addObserver(this);
        currentSlot.addObserver(this);
    }

	@Override
	public void update(Observable arg0, Object arg1) {
    	String addressOfCurrent = currentSlot.getAddress();
    	String contentOfCurrent = spreadSheet.getSlot(addressOfCurrent);
		this.setText(contentOfCurrent);
	}
}
