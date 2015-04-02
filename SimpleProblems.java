import java.util.ArrayList;


public class SimpleProblems {
	
	public static void main (String[] args) {
		double answer = 0;
		
		problem1(); //what is the sum of all multiples of 3 and 5 less than 1000 and greater than 0
		
		problem2(); //what is the sum of all even numbers less than 4000000 in the fib sequence 
		
		problem3(600851475143.0); //what is the largest prime factor of 600851475143?
		
		problem4(); //find the largest palindrome made from the product of two 3-digit numbers
		
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
		int upperLimit = 10000;
		
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
		
		System.out.printf("The answer to problem 3 is: %f\n", answer);
	}
	
	static double problem3Rec(double number, int upperLimit, boolean[] isComposite) {
		//System.out.println("current number to get prime factor of: " + number);
		
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
	
	static void problem4 () {
		int i = 0;
		int j = 0;
		int largest = 0;
		
		//loop through all three digit numbers and check each to see if it is a palindrome. If
		//so, check that palindrome against the current largest.
		for (i = 100; i < 999; i++) {
			for (j = 100; j < 999; j++) {
				if (isPalindrome(i*j) && (i*j) > largest)
					largest = i*j;
			}
		}
		
		System.out.println("The answer to problem 4 is: " + largest);
	}
	
	static boolean isPalindrome (int product) {
		//create an array list to hold each integer value in a possible palindrome
		ArrayList<Integer> digits = new ArrayList<Integer>();
		
		//divide the given integer by 10. The remainder will be the last digit in the original
		//number. Add this number to the beginning of the arraylist, then divide the original
		//number by 10 to create the new number to use this process on. Each time, the remainder
		//of the number will be added to the beginning of the arraylist, until the digit is less
		//than 0 (every digit has been accounted for).
		while(product/10 >= 1) {
			digits.add(0, product%10);
			product = product/10;
		}
		//Add the final remainder, which will be the first digit, to the beginning of the arraylist.
		digits.add(0, product);
		
		digits.trimToSize();
		
		//check the first element of the array against the last, then the second first against
		//the second last, and so forth until the elements overlap. If each test is a match, the
		//number is a palindrome and return true. Otherwise return false, the number is not a 
		//palindrome.
		int start = 0;
		int end = digits.size() - 1;
		while (start <= end) {
			if (digits.get(start) == digits.get(end)) {
				start++;
				end--;
			} else
				return false;
		}
		
		return true;
	}
}
