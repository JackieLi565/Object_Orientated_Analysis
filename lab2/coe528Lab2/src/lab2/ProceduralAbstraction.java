/*
    *by Jackie Li
    *COE528 Lab2 ProceduralAbstraction
    *Section 10 for Luella Marcos
*/
package lab2;

public class ProceduralAbstraction {
    public static void main(String[] args) {
        int result = reverseFactorial(659);
        int expected = 6;
        if (result == expected) {
            System.out.println("Factorial Test Passed " + result);
        } else {
            System.out.println("Factorial Test Failed " + result);
        }

        int[][] matrix = { { 2, 7, 6 },
                { 9, 5, 1 },
                { 4, 3, 8 } };
        if (isMatrixNice(matrix)) {
            System.out.println("Matrix Test Passed");
        } else {
            System.out.println("Matrix Test Failed");
        }
    }

    // Requires: None
    // Modifies: None
    // Effects: Returns the smallest positive integer n for which n!
    // (i.e. 1*2*3*...*n) is greater than or equal to x, for positive
    // integer x. Otherwise returns 1.
    public static int reverseFactorial(int x) {
        int currentProduct = 1;
        int setCurrentNumber = 0;

        // checks if number is negative, which returns 1
        if (x <= 0) {
            return 1;
        }
        // finds number where factorial is >= to x
        for (int i = 1; i < x; i++) {
            currentProduct *= i;
            if (currentProduct >= x) {
                setCurrentNumber = i;
                break;
            }
        }
        return setCurrentNumber;
    }

    // Requires: None
    // Modifies: None
    // Effects: If the matrix arr satisfies Nice property, prints the sum and
    // returns true. Otherwise returns false.
    public static boolean isMatrixNice(int[][] arr) {
        int arrayLength = arr.length;
        int row = 0, col = 0, dia = 0;
        int trow = 0, tcol = 0, tdia = 0;

        // check if matrix is square
        for (int i = 0, l = arrayLength; i < l; i++) {
            if (arr[i].length != l) {
                return false;
            }
        }
        // get check conditions
        for (int i = 0; i < arrayLength; i++) {
            row += arr[0][i];
            col += arr[i][0];
            dia += arr[i][i];
        }

        // check rows
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                trow += arr[i][j];
            }
            if (trow != row) { // check if sum is equal to base condition
                System.out.println("F " + trow + " != " + row);
                return false;
            }
            trow = 0;
        }
        // check col
        for (int i = 0; i < arrayLength; i++) {
            for (int j = 0; j < arrayLength; j++) {
                tcol += arr[j][i];
            }
            if (tcol != col) { // check if sum is equal to base condition
                System.out.println("F " + tcol + " != " + col);
                return false;
            }
            tcol = 0;
        }

        // check dia
        int rowCounter = 0;
        for (int i = arrayLength - 1; i >= 0; i--) {
            tdia += arr[i][rowCounter++];
        }
        if (tdia != dia) { // check if sum is equal to base condition
            System.out.println("F " + tdia + " != " + dia);
            return false;
        }
        return true;
    }
}
