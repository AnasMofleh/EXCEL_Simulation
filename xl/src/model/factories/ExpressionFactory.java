package model.factories;

import model.Slots.ExpressionSlot;
import java.io.IOException;
import model.XLException;
import model.expr.ExprParser;
import model.Slots.Slot;
import model.expr.Expr;

public class ExpressionFactory implements SlotFactory{

    @Override
    public Slot createSlot(String content) throws XLException {
        try {
            Expr exprParser = new ExprParser().build(content);
            return new ExpressionSlot(exprParser);
        } catch (IOException e) {
            throw new XLException(" invalid address");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
