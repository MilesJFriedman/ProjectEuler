
public class SimpleProblems {
	
	public static void main (String[] args) {
		double answer = 0;
		
		problem1(); //what is the sum of all multiples of 3 and 5 less than 1000 and greater than 0
		
		problem2(); //what is the sum of all even numbers less than 4000000 in the fib sequence 
		
		problem3(961992.0); //what is the largest prime factor of 600851475143?
		
		
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
	}
	
	 
	static void problem3(double number) {
		//define the upper limit for the Sieve
		int upperLimit = 1000;
		
		//create an array that will indicate whether or not a number is prime
		boolean[] isComposite = new boolean[upperLimit];
		isComposite[1] = true;
		
		//Use the Sieve of Eratosthenes to fill the table with composite true values
		for (int i = 2; i < upperLimit; i++) {
			for (int j = i; j*i < upperLimit; j++) {
				isComposite[j*i] = true;
			}
			//System.out.println(i + ": " + isComposite[i]);
		}
		
		//Iterate through the isComposite array, testing each prime number to see if the number
		//is divisible by that prime. If so, pass the new prime number to the recursive function
		double answer = problem3Rec(number, upperLimit, isComposite);
		
		System.out.printf("The answer to problem 3 is: %f", answer);
	}
	
	static double problem3Rec(double number, int upperLimit, boolean[] isComposite) {
		System.out.println("current number to get prime factor of: " + number);
		for (int i = 0; i < upperLimit; i++) {
			//if the current i is a prime number, check to see if it is a prime factor of the
			//number
			if (isComposite[i] == false) {
				if (number % i == 0 && number / i != 1)
					return problem3Rec((number/i), upperLimit, isComposite);
					//break;
			}
		}
		
		return number;
	}
}
