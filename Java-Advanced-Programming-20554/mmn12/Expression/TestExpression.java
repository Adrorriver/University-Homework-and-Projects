/*
 * class how operates the checks   
 */
import java.security.SecureRandom;
import java.util.ArrayList;

public class TestExpression {
	private static final int EXPRESSION_DEPTH = 5;
	private static final int TYPE_OF_EXPRESSIONS = 3;
	private static final int NUM_POSITIVE = 10;
	private static final int NUM_SCOP = 20;
	private static final int ARRAY_LENGTH = 10;

	// random number generator
	private static final SecureRandom randomNumbers = new SecureRandom();

	private ArrayList<Expression> arr;

	// Constructor
	public TestExpression() {
		super();
		arr = new ArrayList<Expression>(ARRAY_LENGTH);
	}
	
	//checks the methods: toSting, calculate, equals   
	public void test() {
		for (int i = 0; i < ARRAY_LENGTH; i++) {
			arr.add(i, randExpression(EXPRESSION_DEPTH));
		}

		for (int i = 0; i < ARRAY_LENGTH; i++) {
			System.out.println(arr.get(i).toString() + " = " + arr.get(i).calculate());
		}
		System.out.println();
		for (int i = 0; i < ARRAY_LENGTH - 1; i++) {
			for (int j = i + 1; j < ARRAY_LENGTH; j++) {
				if (arr.get(i).equals(arr.get(j))) {
					System.out.println("Expression: " + arr.get(i).toString() + "\t equals: " + arr.get(j).toString());
				}
			}
		}

	}
	
	// calculate random expression recursively
	public Expression randExpression(int count) {
		if (count == 1) { // stopping condition - depth is reach
			return new AtomicExpression(randomNumbers.nextInt(NUM_SCOP) - NUM_POSITIVE);
		} else {
			int rand = randomNumbers.nextInt(TYPE_OF_EXPRESSIONS);
			if (rand == 0) {
				return new AtomicExpression(randomNumbers.nextInt(NUM_SCOP) - NUM_POSITIVE);
			} else if (rand == 1) {
				--count;
				return new AdditionExpression(randExpression(count), randExpression(count));
			} else {
				--count;
				return new SubtractionExpression(randExpression(count), randExpression(count));
			}
		}
	}
}
