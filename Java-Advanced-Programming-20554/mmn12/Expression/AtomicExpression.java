/*
 * class represent an AtomicExpression e.g. 7.3 or 2
 */
public class AtomicExpression extends Expression {
	private double atoExp;

	//Constructor 
	public AtomicExpression(double atoExp) {
		super();
		this.atoExp = atoExp;
	}

	@Override
	public double calculate() {
		return atoExp;
	}

	@Override
	public String toString() {
		return "("+atoExp+")";
	}
	
	
	
}
