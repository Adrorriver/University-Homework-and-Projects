
/**
 * test the rational number class
 * 
 * @author (amir dror) 
 * @version (29.2.2016)
 */

import java.util.Scanner;

public class TestRational {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("enter first rational number");
		Rational rat1 = getRational(in);
		System.out.println("enter second rational number");
		Rational rat2 = getRational(in);
		in.close();
		rationalWork(rat1, rat2);
	}

	// test the methods of the Rational class
	private static void rationalWork(Rational rat1, Rational rat2) {
		System.out.println("\n\nfirst number(reduce):  ");
		System.out.println(rat1.reduce().toString());
		System.out.println("second number(reduce):  ");
		System.out.println(rat2.reduce().toString());

		System.out.println("\n\ncheck if equals ");
		System.out.println(rat1.equals(rat2));
		System.out.println("check if first > second  ");
		System.out.println(rat1.greaterThen(rat2));
		System.out.println("first + second(reduce):  ");
		System.out.println(rat1.plus(rat2).reduce().toString());
		System.out.println("first - second(reduce):  ");
		System.out.println(rat1.minus(rat2).reduce().toString());
		System.out.println("first * second(reduce):  ");
		System.out.println(rat1.multiply(rat2).reduce().toString());
	}

	// prompt and scan integers form user, to make a rational number
	private static Rational getRational(Scanner in) {
		int p, q;
		System.out.println("enter numerator: ");
		p = scanInt(in);
		System.out.println("enter denominator: ");
		q = scanInt(in);
		Rational result = new Rational(p, q);
		return result;
	}

	// prompt and scan integers, if non int is typed, ask again for int
	private static int scanInt(Scanner in) {
		if (in.hasNextInt())
			return in.nextInt();
		else
			while (!in.hasNextInt()) {
				System.out.println("invalid value! enter int: ");
				in.next();
			}
		return in.nextInt();
	}

}
