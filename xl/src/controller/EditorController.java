package controller;

import view.Editor;
import model.SpreadSheet;
import model.CurrentSlot;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditorController implements KeyListener {
	private SpreadSheet spreadSheet;
	private CurrentSlot currentSlot;
	private Editor editor;

	public EditorController(SpreadSheet spreadSheet, CurrentSlot currentSlot, Editor editor) {
		this.spreadSheet = spreadSheet;
		this.editor = editor;
		this.currentSlot = currentSlot;
		editor.addKeyListener(this);
	}



	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			spreadSheet.clearSlotError();
			String editorContent = editor.getText();
			if (!editorContent.isEmpty()) {
				spreadSheet.put(currentSlot.getAddress(), editorContent);
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

}