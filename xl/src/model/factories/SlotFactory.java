package model.factories;

import model.Slots.Slot;

public interface SlotFactory {
    Slot createSlot(String s) throws Exception;
}
