/*
 * class represent a AdditionExpression, 
 * AdditionExpression include 2 Expression with + operator 
 */
public class SubtractionExpression extends CompoundExpression {

	//Constructor 
	public SubtractionExpression(Expression first, Expression second) {
		super(first, second);
	}

	@Override
	public double calculate() {
		return (super.firstExp.calculate() - super.secondExp.calculate());
	}
	
	@Override
	public String toString(){
		return "("+super.firstExp.toString()+"-"
				+ super.secondExp.toString()+")";
				
	}

}
