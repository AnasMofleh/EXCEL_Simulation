package model.Slots;

import model.expr.Environment;

public class CommentSlot implements Slot {
    private String stringValue;

    public CommentSlot(String stringValue) {
        if (stringValue.charAt(0) == '#') this.stringValue = stringValue;
        else throw new IllegalArgumentException(" Invalid input that doesnt start with #");
    }

    @Override
    public String displayString(Environment env) {
        return stringValue.substring(1);
    }

    @Override
    public double value(Environment env){
        return 0;
    }

    @Override
    public String toString() {
        return stringValue;
    }

}
