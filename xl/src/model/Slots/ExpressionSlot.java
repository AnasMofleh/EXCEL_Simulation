package model.Slots;

import model.expr.Environment;
import model.XLException;
import model.expr.Expr;

public class ExpressionSlot implements Slot {
	private Expr expr;

	public ExpressionSlot(Expr expr) throws XLException {
		this.expr = expr;
	}

	@Override
	public double value(Environment env) {
		return expr.value(env);
	}

	public String toString() {
		return expr.toString();
	}

	@Override
	public String displayString(Environment env) {
		return Double.toString(expr.value(env));
	}

}
