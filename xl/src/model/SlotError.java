package model;

import java.util.Observable;

public class SlotError extends Observable{
	private String errorMessage;

    public SlotError() {
    	errorMessage = "";
    }
    
    public void clear() {
    	errorMessage = "";
    	updated();
    }
    
    public void setSlotError(String errorMessage){
    	this.errorMessage = errorMessage;
    	updated();
    }
    
    public String getSlotError() {
    	return errorMessage;
    }
    
	private void updated() {
		setChanged();
		notifyObservers();
	}

}
