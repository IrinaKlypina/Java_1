package Lesson_2;

import java.util.Arrays;

public class MainClass {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

//        changeArray();
//        fillArray();
//        ifSmallThenMultiply();
//        fillDiagonals(5);
//        findMinMax();    
//        System.out.println(checkBalance(arr));
//        shift(arr, 3);
        spiral(5,7);
    }

    static void changeArray() {
        int[] arr = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] + 1) % 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0, j = 0; i < arr.length; i++, j += 3) {
            arr[i] = j;
        }
        System.out.println(Arrays.toString(arr));
    }

    static void ifSmallThenMultiply() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void fillDiagonals(int size) {
        int[][] arr = new int[size][size];
        for (int i = 0, j = 0, k = size - 1; i < arr.length; i++, j++, k--) {
            arr[i][j] = 1;
            arr[i][k] = 1;
        }
        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    static void findMinMax() {
        int[] arr = {5, 4, 1, 2, -100, 50};
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("min = " + min + "\nmax = " + max);
    }

    static boolean checkBalance(int[] arr) {
        int rightSum, leftSum;
        for (int i = 1; i < arr.length; i++) {
            leftSum = findSum(0, i, arr);
            rightSum = findSum(i, arr.length, arr);
            System.out.println(leftSum + " " + rightSum);
            if (rightSum == leftSum) {
                return true;
            }
        }
        return false;
    }

    static int findSum(int start, int end, int[] arr) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static void shift(int[] arr, int n) {
        if (arr.length == 0 || n == 0 || Math.abs(n) > arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        int temp, prevNumb;
        for (int j = n > 0 ? 0 : arr.length - 1; n > 0 && j < n || n < 0 && j > arr.length + n - 1;) {
            prevNumb = arr[j];
            for (int i = n > 0 ? j + 1 : j - 1; n > 0 && i < arr.length || n < 0 && i >= 0;) {
                temp = arr[i];
                arr[i] = prevNumb;
                prevNumb = temp;
                if (n > 0) {
                    i++;
                } else {
                    i--;
                }
            }
            arr[j] = 0;
            if (n > 0) {
                j++;
            } else {
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void spiral(int n, int m) {
        int[][] arr = new int[n][m];

        int counter = 1;

        int countOfCircles = m / 2 + (m % 2 == 0 ? 0 : 1);

        for (int j = 0; j < countOfCircles; j++) {

            for (int i = j; i < m - j; i++) { // top
                if (arr[j][i] > 0) {
                    break;
                }
                arr[j][i] = counter++;
            }

            for (int i = j + 1; i < n - j; i++) { // right
                if (arr[i][m - 1 - j] > 0) {
                    break;
                }
                arr[i][m - 1 - j] = counter++;
            }

            for (int i = m - 2 - j; i >= j; i--) { // bottom
                if (arr[n - 1 - j][i] > 0) {
                    break;
                }
                arr[n - 1 - j][i] = counter++;
            }

            for (int i = n - 2 - j; i > j; i--) { // left
                if (arr[i][j] > 0) {
                    break;
                }
                arr[i][j] = counter++;
            }
        }

        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }
}
