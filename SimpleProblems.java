
public class SimpleProblems {
	
	public static void main (String[] args) {
		
		problem1();
		
		problem2();
		
		
	}
	
	static void problem1 () {
		int sum = 0;
		
		//iterate through 1000 numbers, creating a sum of the multiples of 3 and 5 that occur
		//which increases as the iterations do until all 1000 numbers have been checked.
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		
		System.out.printf("The answer to problem 1 is: %d\n", sum);
	}
	
	static void problem2() {
		int newi = 0;
		int sum = 2;
		int i = 2;
		int prevFib = 1;
		
		while (i <= 4000000) {
			newi = prevFib + i;
			prevFib = i;
			i = newi;
			
			//add every odd fib to the total sum
			if (newi % 2 == 0)
				sum += i;
		}
		
		System.out.printf("The answer to problem 2 is: %d\n", sum);
		
		/*//Recursively iterate through the Fibonacci sequence starting at 4000 and create an
		//increasing sum to keep track of the sum of all of the fib numbers under 4000
		if (fib == 1) {
			return 1;
		} else if (fib == 2) {
			return 2;
		} else 
			return problem2(fib - 1) + problem2(fib - 2);*/
	}
}
