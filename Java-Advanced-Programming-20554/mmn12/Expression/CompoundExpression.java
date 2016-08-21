/*
 * class represent a CompoundExpression, 
 * CompoundExpression include 2 Expression
 */
public abstract class CompoundExpression extends Expression{
	protected Expression firstExp;
	protected Expression secondExp;
	
	public CompoundExpression (Expression first, Expression second){
		super();
		this.firstExp = first;
		this.secondExp = second;
	}
}