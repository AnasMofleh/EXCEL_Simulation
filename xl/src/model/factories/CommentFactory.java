package model.factories;

import model.Slots.CommentSlot;
import model.Slots.Slot;

public class CommentFactory implements SlotFactory{

    @Override
    public Slot createSlot(String content) {
        return new CommentSlot(content);
    }
}
