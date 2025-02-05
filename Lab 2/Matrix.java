



public class Matrix {
        

	public static void main (String[] args) {

         //write code of all the methods below and call them here
        double[][] testArray = {{1,2,3}, {4,5,6}, {7,8,9}};
		printValues(testArray);
        
        // transpose copy test
        printValues(transposeCopy(testArray));

        // transpose in place test
        transposeInPlace(testArray);
        printValues(testArray);
        
	}



        public static void printValues(double[][] arrayOfArrays){
            // easier form of printing array of array
            // System.out.println(Arrays.deepToString(arrayOfArrays));


            // loops through array to print each value
            for(int i = 0; i < arrayOfArrays.length; i++){
                for(int j = 0; j < arrayOfArrays[i].length; j++){
                    if(j == arrayOfArrays[i].length - 1){
                        System.out.println(arrayOfArrays[i][j]);
                    }
                    else{
                        System.out.print(arrayOfArrays[i][j] + " ");
                    }
                }
            }
        }

        // method to make transpose copy
        public static double[][] transposeCopy(double[][] matrix){

            // handles transpose if matirx isnt symmetrical
            int rows = matrix.length;
            int cols = matrix[0].length;

            // allocates new memory for new array and tranposes col and row length
            double[][] newArray = new double[cols][rows];

            // loops through given matirx and transposes
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    newArray[i][j] = matrix[j][i];
                }
            }
            return newArray;
        }


        // method to transpose in place
        public static void transposeInPlace(double[][] matrix){

            // loop through array and assign current postion to a temp variable
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){

                    // temp variable to hold value
                    double temp = matrix[i][j];

                    // swap values
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;

                }
            }

        }


}

