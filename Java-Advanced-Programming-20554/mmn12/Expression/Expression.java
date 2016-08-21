/*
 * class represent an Expression
 */
public abstract class Expression {
	
	public abstract double calculate();

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Expression) {
			Expression exp = (Expression) obj;
			return (calculate() == exp.calculate());
		}
		return false;
	}

}
