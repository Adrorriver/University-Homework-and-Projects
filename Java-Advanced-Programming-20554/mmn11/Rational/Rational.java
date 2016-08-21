
/**
 * Represents a rational number with relevant methods
 * 
 * @author (amir dror) 
 * @version (29.2.2016)
 */
 
public class Rational 
{
	private int _P;// the numerator in p/q
	private int _Q;// the denominator in p/q
	
    /**
     * Constructs a rational number
     */
	public Rational(int p,int q)
	{
		// Initialize instance variables
		this._P = p; 
		if (q > 0)	// valid assignment 
		{
			this._Q = q;
		}
		else // not valid
		{
			this._P = 0;
			this._Q = 1;
		}
	}
	
	/**
     * Returns the Numerator of the num. 
     *
     * @return    The _P value of the num
     */
	public int getNumerator()
	{
		return _P;
	}
	
	/**
     * Returns the Denominator of the num. 
     *
     * @return    The _Q value of the num
     */
	public int getDenominator()
	{
		return _Q;
	}
	
	/**
     * Check if this rational is greater then other rational
     * 
     * @param  other  The rational to check if this rational is greater of
     * @return   True if this rational is greater then other rational
     */
	public boolean greaterThen (Rational otherRat){
		return ((_P*otherRat.getDenominator()) > (_Q*otherRat.getNumerator()));	
	}
	
	/**
     * Check if this rational is equals to other rational
     * 
     * @param  other  The rational to check if this rational is equal to
     * @return   True if this rational is equal to other rational
     */
	public boolean equals (Rational otherRat){
		if ((_P*otherRat.getDenominator()) == (_Q*otherRat.getNumerator())) return true;
		else return false;
	}
	
	/**
     * add 2 rationals 
     * 
     * @param  other  The rational to add
     * @return   Rational result, the sum of 2 rationals
     */
	public Rational plus (Rational other)
	{
		int p_res = _P*other.getDenominator() + _Q*other.getNumerator();
		int q_res = _Q*other.getDenominator();
		Rational result = new Rational(p_res,q_res);
		return result;
	}
	
	/**
     * subtract 2 rationals 
     * 
     * @param  other  The rational to subtract from this
     * @return   Rational result, the subtraction of 2 rationals
     */
	public Rational minus (Rational other)
	{
		int p_res = _P*other.getDenominator() - _Q*other.getNumerator();
		int q_res = _Q*other.getDenominator();
		Rational result = new Rational(p_res,q_res);
		return result;
	}
	
	/**
     * multiply 2 rationals 
     * 
     * @param  other  The rational to multiply  this
     * @return   Rational result, the multiplication of 2 rationals
     */
	public Rational multiply (Rational other)
	{
		int p_res = _P*other.getNumerator();
		int q_res = _Q*other.getDenominator();
		Rational result = new Rational(p_res,q_res);
		return result;
	}
	
	/**
     * Return a string representation of this rational. i.e. 3/4 
     * 
     * 
     * @return   String representation of this rational
     */
    public String toString()
    {
        return (_P+"/"+_Q);
    }
    
    
   
    /**
     * Return the reduce value of this rational: 8/4 -> 2/1 
     * 
     *
     * @return   the reduce value of this rational: 8/4 -> 2/1
     */
    public Rational reduce()
    {
        int P = _P;
        int Q = _Q;
    	int gcdResult = gcd(P,Q);// call to recursive function gcd()
        
    	int p_res = _P/gcdResult;
    	int q_res = _Q/gcdResult;
    	Rational result = new Rational(p_res, q_res);
    	return result;
    }

	private int gcd(int x, int y) 
	{
		if (y == 0) 
			return x;
		return gcd(y,x%y); 
	}
}
