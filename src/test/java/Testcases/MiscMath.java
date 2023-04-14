package Testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MiscMath {

    public boolean SumOfCubesAndSquareOfSum(int n) {
        int cube = 0;
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            cube += i * i * i;
            sum += i;
        }

        return cube == (sum * sum);
    }

    public double DistanceFormula(int x1, int y1, int x2, int y2) {
        var XDiff = (x2 - x1) * (x2 - x1);
        var YDiff = (y2 - y1) * (y2 - y1);

        return Math.sqrt(XDiff + YDiff);
    }

    public double[] QuadraticFormula(double a, double b, double c) throws Exception{
        double discrim = Math.pow(b, 2) - 4 * a * c ;
        if (discrim < 0) {
            throw new Exception("No real solutions");
        }

        double firstZero = -1 * b + Math.sqrt(discrim);
        firstZero /= 2 * a;
        double secondZero = -1 * b - Math.sqrt(discrim);
        secondZero /= 2 * a;

        return new double[]{firstZero, secondZero};
    }
    
    
     public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int rowsB = matrixB.length;
        int colsB = matrixB[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Number of columns in Matrix A must be equal to the number of rows in Matrix B");
        }

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }


    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    
    //Grace's methods
    public static boolean isPalindrome(String input) {
        String cleanedInput = input.toLowerCase().replaceAll("\\s+", "").replaceAll("\\p{Punct}", "");
        int left = 0;
        int right = cleanedInput.length() - 1;

        while (left < right) {
            if (cleanedInput.charAt(left) != cleanedInput.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    
    //Testing

    @Test
    public void SumsTest() {
        Assert.assertEquals(SumOfCubesAndSquareOfSum(5), true);
        Assert.assertEquals(SumOfCubesAndSquareOfSum(18), true);
        Assert.assertEquals(SumOfCubesAndSquareOfSum(34), true);
    }

    @Test
    public void DistanceTest() {
        Assert.assertEquals(DistanceFormula(0, 0, 0, 5), 5);
        Assert.assertEquals(DistanceFormula(5, 5, 8, 8), 4.24, 0.01 );
        Assert.assertEquals(DistanceFormula(-5, -5, 8, 8), 18.38, 0.01 );
    }

    @Test
    public void QuadTest() throws Exception {
        Assert.assertEquals(QuadraticFormula(1.0, 0.0, -1.0), new double[]{1, -1}, 0.01);
        Assert.assertEquals(QuadraticFormula(-0.2, 1.2, 0.0), new double[]{0, 6}, 0.01);
        Assert.assertEquals(QuadraticFormula(0.1, 1.2, 3.2), new double[]{-4, -8}, 0.01);

    }

}
