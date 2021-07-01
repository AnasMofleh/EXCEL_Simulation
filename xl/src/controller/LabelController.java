package controller;

import java.util.List;

import view.gui.SlotLabel;
import model.SpreadSheet;
import model.CurrentSlot;

public class LabelController{
	private SpreadSheet spreadSheet;
	private CurrentSlot currentSlot;
	private List<SlotLabel> labelList;
	
	
	public LabelController(SpreadSheet spreadSheet, CurrentSlot currentSlot){
		this.spreadSheet = spreadSheet;
		this.currentSlot = currentSlot;
	}

	public void setLabelList(List<SlotLabel> labelList) {
		this.labelList = labelList;
		labelList.forEach(x -> {
			x.addMouseListener(new MouseAdapter(x, currentSlot));
		});
	}


	
	public void clear(){
		spreadSheet.remove();
	}
	
	public void clearAll(){
		labelList.forEach(x -> x.setText(""));
		spreadSheet.clear();
	}



}
