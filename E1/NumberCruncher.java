/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/

public class NumberCruncher {

	/**
	* This method returns true if input1 and input2 are coprimes
	*/

	public static boolean isCoprime(int input1, int input2) {

		/* 
		* Uses the min Math.method to find the lower of the 2 numbers
		* the lowest number is stored and set to be the limit of the count
		*/

		int lowestNumber = Math.min(input1, input2);

		/* 
		* loops to the lowestNumber starting with 2 using mod operator
		* because everything is divisible by 1 with no remainder
		* if there is no remainder, the values are not co primes
		*/ 

		for (int count = 2; count <= lowestNumber; count++) {
			if((input1 % count == 0) && (input2 % count == 0)) {
				return false;
			}
		}
		return true;
	}




	/**
	* This method returns true if the number is both a prime and a fibonaci number
	*/

	public static boolean isFibonacciPrime(long input) {

		// for specific case of 0 and 1
		// I asked the professor and he said edge cases dont count as hard coding.

		if (input < 2){
			return false;
		}

		/*
		* calculates for the fibonacci sequence non-recursive.
		* continues calculating until result reaches or exceeds input.
		*/

		long prev = 0; 
		long next = 1;
		long result = 0;

		while(result < input){

			result = prev + next;
			prev = next;
			next = result;
			
		}
		
		// test to see if the input is a fibonnaci number, if not, returns false 

		if (result != input){
			return false;
		}

		/* 
		*  checks to see if the number is prime, if not a prime returns false.
		*  Uses the square root of the inpput to check against.
		*  this is because there is no factor that can be multiplied
		*  against itself greater than the square root as the
		*  multiple would be greater than the input.
		*/

		for (long i = 2; i <= Math.sqrt(input); i++) {
			if(input % i == 0){
				return false;
			}
		}
	
		// returns true if both, a prime and a fibonacci

		return true;

	}




	/**
	 * This method returns the number of steps it takes to get to 1
	 * following the collatz game rules starting at the input
	 */
	public static int countCollatzSteps(int input){
		
		// variable to count number of steps

		int stepCount = 0;

		// while the input does not equal 1

		while (input != 1){

			//checks of a number is even, then divides by 2

			if (input % 2 == 0){
				input = input / 2;
				stepCount++;
			}

			//checks if the number is odd then multiplies by 3 and adds 1

			else if (input % 2 != 0){
				input = input * 3 + 1;
				stepCount++;
			}
		}
		// returns number of steps

		return stepCount;
	}




	/**
	 * This method marks off all the spots in the input array
	 * corresponding to composite numbers, leaving only the
	 * prime numbers as true.
	 */
	public static void sieveOfEratosthenes(boolean[] array){
		
		// sets all values of the boolean array to true

		for (int i = 0; i < array.length; i++){
			array[i] = true;
		}

		/*
		* parses through array
		*
		*/

		for (int i = 0; i < array.length; i++) {

			// for edge case 1 and 0
			if (i < 2){
				array[i] = false;
			}

			/* 
			* had to add guard condition because i kept getting out of bounds exceptions
			* for accessing elements outside of the array.
			*/

			else if (array[i]){

				/*
				* uses the sieve of erathosthenes methods of multiplying primes
				* to set to set multiples of the prime indices equal to false.
				*/
				for(int j = i * i; j < array.length; j += i){
					array[j] = false;
				}
			}
		}
	}




	/**
	 * Modifies a two-dimensional array in-place. Every occurrence of item
	 * is replaced by replacement.
	 */
	public static void replaceItem(int[][] array, int item, int[] replacement){
		
			//parse though array to match item
			for(int i = 0; i < array.length; i++){

				// to set the new row length
				int newRowLength = 0;

				for(int j = 0; j < array[i].length; j++){

					// if the item matches an elemnt in the array
					if(array[i][j] == item){

						// creates a copy of the array and adds the length of the replacement
						// assigns it to the orginal array
						newRowLength = newRowLength + replacement.length;
					}

					//increases the row index by 1 if no match is found
					else{
						newRowLength++;
					}
				}
			

				//expands array
				int[] newRow = new int[newRowLength];

				// creat value for indexes placeholder
				int rowIndex = 0;

				//replace item with new items
				for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == item) {
                    // if item is found, replace it with the replacement array
                    for (int r : replacement) {
                        newRow[rowIndex++] = r;
                    }
                } else {
                    // copy the original element elements
                    newRow[rowIndex++] = array[i][j];
                }
            }
            
            // assign the new row back to the original array
            array[i] = newRow;

			}





	}

	/**
	 * Main method. Is not tested by the tester, create your own tests here!
	 */
	public static void main(String[] args){

		/*

		//test 1

		int[] a = {3, 2, 7, 17, 30};
		int[] b = {5, 4, 15, 257, 11};

		for (int i = 0; i < a.length; i++) {
			System.out.println(NumberCruncher.isCoprime(a[i], b[i]));
		}

		//test 2

		long[] c = {2,3,5,7,8,13};
		for(int i = 0; i < c.length; i++){
			System.out.println(NumberCruncher.isFibonacciPrime(c[i]));
		}

		// test 3

		int[] d = {9, 97, 27, 1, 7};
		for(int i = 0; i < d.length; i++){
			System.out.println(NumberCruncher.countCollatzSteps(d[i]));
		}

		// test 4

		boolean[] e = {false, false, false, false, false, false};
		sieveOfEratosthenes(e);
		System.out.println(Arrays.toString(e));

		// test 5

		int[][] f = {{1,2,3,4,5},{6,7,8,9}};
		int[] g = {0,-1};
		System.out.println(f);
		replaceItem(f, 2, g);
		System.out.println(Arrays.deepToString(f));
		System.out.println(f);

		*/
	}

}
